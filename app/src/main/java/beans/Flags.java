
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Flags {

    @SerializedName("nearest-station")
    private Double nearestStation;
    @Expose
    private List<String> sources;
    @Expose
    private String units;

    public Double getNearestStation() {
        return nearestStation;
    }

    public void setNearestStation(Double nearestStation) {
        this.nearestStation = nearestStation;
    }

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

}
