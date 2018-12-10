package jp.co.run;

import jp.co.run.enums.JapaneseEras;

public class Main {

    
    public static void main(String[] args) {

        JapaneseEras[] japaneseEras = JapaneseEras.values();
        int length = japaneseEras.length;
        System.err.println(length);
        for (int i = 0; i < length; i++) {
            if (japaneseEras[i].isEras("19450901", "yyyyMMdd")) {
            }
        }

    }
}
