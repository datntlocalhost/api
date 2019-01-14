package jp.com.run.model.request;

import javax.validation.constraints.NotNull;

public class SearchZipcodeRequestModel {

    @NotNull
    private String searchKey;

    @NotNull
    private boolean zipcode;

    @NotNull
    private boolean english;

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public boolean isEnglish() {
        return english;
    }

    public void setEnglish(boolean english) {
        this.english = english;
    }

    public boolean isZipcode() {
        return zipcode;
    }

    public void setZipcode(boolean zipcode) {
        this.zipcode = zipcode;
    }

}
