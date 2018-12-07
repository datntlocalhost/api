package jp.co.run;

public class Zipcode {

    private String zipcode;

    private String country;

    private String regionEN;

    private String regionJP;

    private String cityEN;

    private String cityJP;

    private String prefectureEN;

    private String prefectureJP;

    public Zipcode(String zipcode, String country, String regionEN, String regionJP, String cityEN, String cityJP,
        String prefectureEN, String prefectureJP) {
        this.zipcode = zipcode;
        this.country = country;
        this.regionEN = regionEN;
        this.regionJP = regionJP;
        this.cityEN = cityEN;
        this.cityJP = cityJP;
        this.prefectureEN = prefectureEN;
        this.prefectureJP = prefectureJP;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegionEN() {
        return regionEN;
    }

    public void setRegionEN(String regionEN) {
        this.regionEN = regionEN;
    }

    public String getRegionJP() {
        return regionJP;
    }

    public void setRegionJP(String regionJP) {
        this.regionJP = regionJP;
    }

    public String getCityEN() {
        return cityEN;
    }

    public void setCityEN(String cityEN) {
        this.cityEN = cityEN;
    }

    public String getCityJP() {
        return cityJP;
    }

    public void setCityJP(String cityJP) {
        this.cityJP = cityJP;
    }

    public String getPrefectureEN() {
        return prefectureEN;
    }

    public void setPrefectureEN(String prefectureEN) {
        this.prefectureEN = prefectureEN;
    }

    public String getPrefectureJP() {
        return prefectureJP;
    }

    public void setPrefectureJP(String prefectureJP) {
        this.prefectureJP = prefectureJP;
    }

    @Override
    public String toString() {
        return zipcode + "," + country + "," + regionEN + "," + regionJP + "," + cityEN + "," + cityJP + ","
            + prefectureEN + "," + prefectureJP;
    }

}
