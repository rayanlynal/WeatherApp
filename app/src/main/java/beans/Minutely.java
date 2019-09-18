
package beans;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Minutely {

    @Expose
    private List<Datum> data;
    @Expose
    private String icon;
    @Expose
    private String summary;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
