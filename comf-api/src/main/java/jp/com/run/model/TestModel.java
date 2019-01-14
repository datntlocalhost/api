package jp.com.run.model;

public class TestModel {

    private String site_id;
    
    private String site_key;
    private String password;
    private String tid;
    private String to_site_id;
    private String mov_url;
    public String getSite_id() {
        return site_id;
    }
    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }
    public String getSite_key() {
        return site_key;
    }
    public void setSite_key(String site_key) {
        this.site_key = site_key;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTid() {
        return tid;
    }
    public void setTid(String tid) {
        this.tid = tid;
    }
    public String getTo_site_id() {
        return to_site_id;
    }
    public void setTo_site_id(String to_site_id) {
        this.to_site_id = to_site_id;
    }
    public String getMov_url() {
        return mov_url;
    }
    public void setMov_url(String mov_url) {
        this.mov_url = mov_url;
    }
    @Override
    public String toString() {
        return "TestModel [site_id=" + site_id + ", site_key=" + site_key + ", password=" + password + ", tid=" + tid
            + ", to_site_id=" + to_site_id + ", mov_url=" + mov_url + "]";
    }
    
    
}
