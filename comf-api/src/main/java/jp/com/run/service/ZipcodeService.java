package jp.com.run.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jp.com.run.model.request.SearchZipcodeRequestModel;
import jp.com.run.util.FileUtil;
import jp.com.run.util.ResponseUtil;

@Service
public class ZipcodeService {

    public ResponseEntity<?> searchZipcodeAddress(SearchZipcodeRequestModel model) {
        return new ResponseEntity<>(ResponseUtil.createResult(getData(model.getSearchKey(), model.isZipcode(), model.isEnglish())), HttpStatus.OK);
    }
    
    private String getData(String searchKey, boolean isZipcode, boolean isEn) {
        
        StringBuilder builder = new StringBuilder();
        if (searchKey == null || searchKey.isEmpty()) {
            return builder.toString();
        }
        
        File file = new File(FileUtil.getFilePathResource("KEN_ALL_ROME.CSV"));
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        searchKey = removeSpeChar(searchKey);

        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis, "Shift-JIS");
            br = new BufferedReader(isr);
            String s;
            while ((s = br.readLine()).length() > 0) {
                String[] lines = s.split("\u002C");
                lines = removeQuot(lines);
                String enAddr = buildString(lines, true);
                String jpAddr = buildString(lines, false);
                if (isZipcode) {
                    if (removeSpeChar(searchKey).equals(lines[0])) {
                        builder.append(isEn ? enAddr : jpAddr);
                        break;
                    }
                } else {
                    if (searchKey.equals(removeSpeChar(enAddr)) || searchKey.equals(removeSpeChar(jpAddr))) {
                        builder.append(lines[0]);
                        break;
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
            } catch (Exception e) {
            }
        }
        
        return builder.toString();
    }

    private String[] removeQuot(String[] array) {
        if (array == null) {
            return null;
        }
        int i = 0;
        while (i < array.length) {
            array[i] = array[i].replaceAll("\"", "");
            i++;
        }
        return array;
    }
    
    private String removeSpeChar(String s) {
        if (s == null) {
            return null;
        }
        return s.replaceAll("[\\u0020\\u3000\\u002C\\uFF0C\\u002D\\uFF0D]", "");
    }
    
    private String buildString(String[] array, boolean isEn) {
        StringBuilder builder = new StringBuilder();
        if (array == null || array.length < 7) {
            return builder.toString();
        }
        if (isEn) {
            builder.append(array[4]);
            builder.append(", ");
            builder.append(array[5]);
            builder.append(", ");
            builder.append(array[6]);
        } else {
            builder.append(array[1]);
            builder.append(" ");
            builder.append(array[2]);
            builder.append(" ");
            builder.append(array[3]);
        }
        return builder.toString();
    }
}
