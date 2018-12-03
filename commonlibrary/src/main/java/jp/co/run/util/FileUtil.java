package jp.co.run.util;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public final class FileUtil {

    public static boolean exportCSV(String fileName, String extension, String encoding, List<String> header,
        List<String> data) throws IOException {

        File file = new File(fileName);

        if (file.exists()) {
            return false;
        }

        Charset charset = Charset.forName(encoding);

        PrintWriter printWriter = new PrintWriter(file, charset.name());

        BufferedWriter bufferedWriter = new BufferedWriter(printWriter);

        for (String s : data) {
            bufferedWriter.write(s);
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();

        return false;
    }

    public static boolean uploadFile(InputStream inputStream, String fileName, String parentFolder, boolean canOverride)
        throws IOException {

        if (inputStream == null || fileName == null || parentFolder == null) {
            return false;
        }

        File file = new File(parentFolder, fileName);

        if (!file.getParentFile().canWrite()) {
            return false;
        }

        if (file.exists() && !canOverride) {
            return false;
        }

        int read = 0;
        byte[] bytes = new byte[1024];
        
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        
        return true;
    }

    public static void main(String[] args) throws IOException {

        File file = new File("/home/datnguyen/Downloads/test.csv");
        InputStream inputStream = new FileInputStream(file);

        System.err.println(uploadFile(inputStream, "adasd", "/home/datnguyen/Downloads", true));
    }
}
