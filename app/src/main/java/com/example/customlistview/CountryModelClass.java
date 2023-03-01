package com.example.customlistview;

public class CountryModelClass {
    private String countryName, winTitleCount;
    private int flagImage;

    public CountryModelClass(String countryName, String winTitleCount, int flagImage) {
        this.countryName = countryName;
        this.winTitleCount = winTitleCount;
        this.flagImage = flagImage;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getWinTitleCount() {
        return winTitleCount;
    }

    public void setWinTitleCount(String winTitleCount) {
        this.winTitleCount = winTitleCount;
    }

    public int getFlagImage() {
        return flagImage;
    }

    public void setFlagImage(int flagImage) {
        this.flagImage = flagImage;
    }
}
