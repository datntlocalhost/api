package jp.co.run;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MyThread extends Thread {

    private String urlString;

    private String prefixCode;

    private int startNumBruteForce;

    private int endNumBruteForce;

    public MyThread(String urlString, String prefixCode, int startNumBruteForce, int endNumBruteForce) {
        this.urlString = urlString;
        this.prefixCode = prefixCode;
        this.startNumBruteForce = startNumBruteForce;
        this.endNumBruteForce = endNumBruteForce;
    }

    @Override
    public void run() {

        System.out.println("Thread " + this.getId() + " is running.");

        String queryString = "insert into zipcode(code, country, region_en, region_jp, city_en, city_jp, prefecture_en, prefecture_jp) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?)";

        Connection mysqlConnection = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost/zipcode?useUnicode=true&characterEncoding=UTF-8", "datnt", "datnt");

            for (int i = this.startNumBruteForce; i < this.endNumBruteForce; i++) {

                String completeUrl = this.urlString + this.prefixCode + String.format("%04d", i) + ".html";

                PreparedStatement statement = null;
                
                try {

                    URL url = new URL(completeUrl);

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    if (connection.getResponseCode() == 200) {
                        System.out.println("[OK] " + completeUrl);

                        Document document = Jsoup.parse(connection.getInputStream(), "UTF-8", "");

                        Elements tableBodyElement = document.select("table tbody");

                        Elements rowsElement = tableBodyElement.select("tr");

                        Elements prefecs = rowsElement.get(2).select("td");
                        Elements cities = rowsElement.get(3).select("td");
                        Elements regions = rowsElement.get(4).select("td");

                        Zipcode zipcode = new Zipcode(this.prefixCode + "-" + String.format("%04d", i), "Japan",
                            regions.get(0).text().split(" \\(aka:")[0], regions.get(1).text(), cities.get(0).text(),
                            cities.get(1).text(), prefecs.get(0).text(), prefecs.get(1).text());
                        System.out.println("\t[Result] " + zipcode.toString());

                        statement = mysqlConnection.prepareStatement(queryString);
                        statement.setString(1, zipcode.getZipcode());
                        statement.setString(2, zipcode.getCountry());
                        statement.setString(3, zipcode.getRegionEN());
                        statement.setString(4, zipcode.getRegionJP());
                        statement.setString(5, zipcode.getCityEN());
                        statement.setString(6, zipcode.getCityJP());
                        statement.setString(7, zipcode.getPrefectureEN());
                        statement.setString(8, zipcode.getPrefectureJP());
                        
                        if (statement.executeUpdate() != 0) {
                            System.out.println("\t[INSERT DATABASE] Success.");
                        } else {
                            System.err.println("\t[INSERT DATABASE] Failed.");
                        }
                        
                    } else if (connection.getResponseCode() == 404) {
                        System.err.println("[Error] " + completeUrl);
                    } else {
                        System.err.println("<!> " + completeUrl);
                    }

                    connection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                    
                    if (statement != null) {
                        statement.close();
                    }
                }
                
                MyThread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (mysqlConnection != null) {
                try {
                    mysqlConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
