package jp.co.run.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class FileUtil {

    public static boolean exportCSV(String fileName, String extension, String encoding, List<String> header,
        List<? extends Object> data) throws IOException {

        boolean isSuccess = true;

        PrintWriter printWriter = null;

        BufferedWriter bufferedWriter = null;

        try {

            File file = new File(fileName);

            printWriter = new PrintWriter(file, encoding);

            bufferedWriter = new BufferedWriter(printWriter);

            if (header != null && header.size() > 0) {

                StringBuilder builder = new StringBuilder();

                for (int i = 0; i < header.size(); i++) {
                    if (i != (header.size() - 1)) {
                        builder.append(header.get(i) + ",");
                    } else {
                        builder.append(header.get(i));
                    }
                }

                bufferedWriter.write(builder.toString());
                bufferedWriter.newLine();
            }

            if (data != null && data.size() > 0) {

                Class<?> clazz = data.get(0).getClass();
                List<String> getters = new ArrayList<String>();

                for (Field field : clazz.getDeclaredFields()) {
                    String fieldName = field.getName();
                    getters.add("get" + fieldName.replace(fieldName.charAt(0), (char) (fieldName.charAt(0) - 32)));
                }

                for (Object object : data) {
                    StringBuilder builder = new StringBuilder();
                    
                    for (String getter : getters) {
                        try {

                            Method method = clazz.getMethod(getter);

                            if (method != null) {
                                builder.append(method.invoke(object).toString() + ",");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    
                    bufferedWriter.write(builder.toString());
                    bufferedWriter.newLine();
                }
            }
        } catch (Exception e) {
            isSuccess = false;
        } finally {
            try {

                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }

                if (printWriter != null) {
                    printWriter.close();
                }

            } catch (Exception e) {
            }
        }

        return isSuccess;
    }
}
