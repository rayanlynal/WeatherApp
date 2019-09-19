package roomdb;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class WeatherViewModel extends AndroidViewModel {
    private Application application;

    public WeatherViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
    }
}
