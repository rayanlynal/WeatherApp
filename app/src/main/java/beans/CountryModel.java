package beans;

public class CountryModel {

    private String countryName;
    private String latlng;

    public CountryModel(String countryName, String countryModel) {
        this.countryName = countryName;
        this.latlng = countryModel;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getLatlng() {
        return latlng;
    }

    public void setLatlng(String latlng) {
        this.latlng = latlng;
    }
}
