package jp.co.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static final String baseUrl = "https://yubin.senmon.net/en/";

    public static final String[] links = {"http://japanzipcodes.blogspot.com/search/label/Aichi%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Akita%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Aomori%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Chiba%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Ehime%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Fukui%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Fukuoka%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Fukushima%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Gifu%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Gunma%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Hiroshima%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Hokkaido%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Hyogo%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Ibaraki%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Ishikawa%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Iwate%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Kagawa%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Kagoshima%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Kanagawa%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Kochi%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Kumamoto%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Kyoto%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Mie%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Miyagi%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Miyazaki%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Nagano%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Nagasaki%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Nara%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Niigata%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Oita%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Okayama%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Okinawa%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Osaka%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Saga%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Saitama%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Shiga%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Shimane%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Shizuoka%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Tochigi%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Tokushima%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Tokyo%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Tottori%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Toyama%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Wakayama%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Yamagata%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Yamaguchi%20ZIP%20codes",
        "http://japanzipcodes.blogspot.com/search/label/Yamanashi%20ZIP%20codes"};

    public static Set<String> startNumZipcodes = new HashSet<String>();

    public static void main(String[] args) throws IOException, InterruptedException {

        scanStartNumZipcode();

        Object linkArrays[] = startNumZipcodes.toArray();

        for (int i = 0; i < linkArrays.length;) {
            if (Thread.activeCount() < 51) {
                MyThread thread = new MyThread(baseUrl, linkArrays[i++].toString(), 0, 10000);
                thread.start();
            }
        }
    }

    public static void scanStartNumZipcode() {

        for (String link : links) {

            BufferedReader bufferedReader = null;

            try {

                URL url = new URL(link);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    if (line.startsWith("The Zip code of")) {
                        startNumZipcodes.add(line.replaceAll(". <br />", "").split("Japan is")[1].trim().split("-")[0]);
                    }
                }

                connection.disconnect();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                try {

                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }

                } catch (Exception e) {
                }
            }

        }
    }
}
