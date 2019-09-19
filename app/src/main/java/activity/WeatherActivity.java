package activity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.exercise.R;
import com.example.exercise.databinding.ActivityWeatherBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import adapter.DailyWeatherAdapter;
import beans.CountryModel;
import beans.DailyData;
import beans.WeatherMainModel;
import remote.Repository;
import util.EasyPermissions;
import util.PermissionDialog;
import util.Utils;

public class WeatherActivity extends AppCompatActivity implements LocationListener {

    private ActivityWeatherBinding binding;
    protected ObservableBoolean busy = new ObservableBoolean(false);
    private ArrayList<DailyData> dailyDataArrayList = new ArrayList<>();
    private boolean isFetchedOnce = false;
    protected LocationManager locationManager;
    private PermissionDialog permissionDialog;

    /**
     * Set button onClick listener and register it with DataBinding
     */
    private View.OnClickListener listener = v -> {
        if (v.getId() == R.id.btChangeCity) {
            startActivity(new Intent(this, CountryListActivity.class));
        }
    };

    /**
     * Handle permission dialog listener
     */
    private PermissionDialog.OnClickListener onOkClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            permissionDialog.dismiss();
            Utils.appSettingsIntent(WeatherActivity.this);
        }
    };

    /**
     * Handle permission dialog listener
     */
    private PermissionDialog.OnClickListener onCancelClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            permissionDialog.dismiss();
        }
    };

    /**
     * Register EventBus with the activity
     */
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather);

        binding.setBusy(busy);
        binding.setListener(listener);

        initRecyclerView();
        locationPermission();

        //Swipe To Refresh view for when user want to refresh the weather
        binding.swipeRefresh.setOnRefreshListener(() -> {
            isFetchedOnce = false;
            binding.swipeRefresh.setRefreshing(false);
        });
    }

    /**
     * initialize RecyclerView
     */
    private void initRecyclerView() {
        binding.rvDailyTemp.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.rvDailyTemp.setAdapter(new DailyWeatherAdapter(dailyDataArrayList));
    }

    /**
     * Call API for fetch weather by checking network connectivity
     *
     * @param latLng
     */
    private void callApiToFetchWeather(String latLng) {
        busy.set(true);
        if (Utils.hasInternet(this)) {
            callGetForeCast(latLng);
        } else {
            Toast.makeText(this, getString(R.string.err_check_internet), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Calling API to fetch weather data and return list response with the help of livedata object
     */
    private void callGetForeCast(String latLng) {
        busy.set(true);
        Repository.getInstance().callWeatherAPI(latLng)
                .observe(this, weatherMainModelResponse -> {
                    busy.set(false);
                    try {
                        if (weatherMainModelResponse != null && weatherMainModelResponse.isSuccessful()) {
                            WeatherMainModel weatherMainModel = weatherMainModelResponse.body();
                            if (weatherMainModel != null) {
                                populateDataInForm(weatherMainModel);
                            }
                        } else {
                            if (weatherMainModelResponse.errorBody() != null) {
                                Toast.makeText(WeatherActivity.this, weatherMainModelResponse.errorBody().string(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    /**
     * Handle and populate data after success response
     */
    private void populateDataInForm(WeatherMainModel weatherMainModel) {
        binding.setWeatherModel(weatherMainModel);
        dailyDataArrayList.addAll(weatherMainModel.getDaily().getData());
        binding.rvDailyTemp.getAdapter().notifyDataSetChanged();
        binding.ivWeatherIcon.setImageResource(Utils.getWeatherIcons(weatherMainModel.getCurrently().getIcon()));
        binding.tvDayTime.setText(Utils.getFormatedTime(weatherMainModel.getCurrently().getTime().toString(), "dd-MM-yyyy hh:mm"));
        binding.tvSunSetTime.setText(Utils.getFormatedTime(weatherMainModel.getDaily().getData().get(0).getSunsetTime().toString(), "hh:mm"));
        binding.tvSunRiseTime.setText(Utils.getFormatedTime(weatherMainModel.getDaily().getData().get(0).getSunriseTime().toString(), "hh:mm"));
    }

    /**
     * Location listener callbacks
     */
    @Override
    public void onLocationChanged(Location location) {
        if (!isFetchedOnce) {
            if (location.getLatitude() != 0 && location.getLongitude() != 0) {
                isFetchedOnce = true;
                callApiToFetchWeather(location.getLatitude() + "," + location.getLongitude());
            }
        }
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    /**
     * Ask for location permission grants from user and show setting dialog
     * if location permission is permanently denied
     */
    private void locationPermission() {
        EasyPermissions.requestPermissions(this, new EasyPermissions.PermissionCallbacks() {
            @Override
            public void onPermissionsGranted(int requestCode, List<String> perms) {
                requestLocationUpdate();
            }

            @Override
            public void onPermissionsDenied(int requestCode, List<String> perms) {
                Toast.makeText(WeatherActivity.this, getString(R.string.err_permission_denied), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionsPermanentlyDeclined(int requestCode, List<String> perms) {
                permissionDialog = new PermissionDialog(WeatherActivity.this, onOkClickListener, onCancelClickListener,
                        getString(R.string.lbl_location_denied_message),
                        getString(R.string.app_name));
            }
        }, getString(R.string.lbl_allow_permission), 110, Manifest.permission_group.LOCATION);
    }


    /**
     * Request location update for get user current geo-location
     */
    private void requestLocationUpdate() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    /**
     * Unregister EventBus From Activity
     */
    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    /**
     * Handle EventBus Callback with sticky event.
     *
     * @param countryModel
     */
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(CountryModel countryModel) {
        Log.e("Country Name : ", countryModel.getCountryName());
        callApiToFetchWeather(countryModel.getLatlng());
    }
}
