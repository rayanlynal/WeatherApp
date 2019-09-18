
package beans;

import com.google.gson.annotations.Expose;

public class Currently {

    @Expose
    private Double apparentTemperature;
    @Expose
    private Double cloudCover;
    @Expose
    private Double dewPoint;
    @Expose
    private Double humidity;
    @Expose
    private String icon;
    @Expose
    private Long nearestStormBearing;
    @Expose
    private Long nearestStormDistance;
    @Expose
    private Double ozone;
    @Expose
    private Long precipIntensity;
    @Expose
    private Long precipProbability;
    @Expose
    private Double pressure;
    @Expose
    private String summary;
    @Expose
    private Double temperature;
    @Expose
    private Long time;
    @Expose
    private Long uvIndex;
    @Expose
    private Double visibility;
    @Expose
    private Long windBearing;
    @Expose
    private Double windGust;
    @Expose
    private Double windSpeed;

    public Double getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(Double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public Double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(Double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public Double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getNearestStormBearing() {
        return nearestStormBearing;
    }

    public void setNearestStormBearing(Long nearestStormBearing) {
        this.nearestStormBearing = nearestStormBearing;
    }

    public Long getNearestStormDistance() {
        return nearestStormDistance;
    }

    public void setNearestStormDistance(Long nearestStormDistance) {
        this.nearestStormDistance = nearestStormDistance;
    }

    public Double getOzone() {
        return ozone;
    }

    public void setOzone(Double ozone) {
        this.ozone = ozone;
    }

    public Long getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(Long precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public Long getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(Long precipProbability) {
        this.precipProbability = precipProbability;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(Long uvIndex) {
        this.uvIndex = uvIndex;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Long getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(Long windBearing) {
        this.windBearing = windBearing;
    }

    public Double getWindGust() {
        return windGust;
    }

    public void setWindGust(Double windGust) {
        this.windGust = windGust;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

}
