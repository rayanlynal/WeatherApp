package util;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.Settings;
import android.text.format.Time;

import com.example.exercise.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Utils {

    private static String CLEAR_DAY = "clear-day";
    private static String CLEAR_NIGHT = "clear-night";
    private static String RAIN = "rain";
    private static String SNOW = "snow";
    private static String SLEET = "sleet";
    private static String WIND = "wind";
    private static String FOG = "fog";
    private static String CLOUDY = "cloudy";
    private static String PARTLY_CLOUDY_DAY = "partly-cloudy-day";
    private static String PARTLY_CLOUDY_NIGHT = "partly-cloudy-night";

    public static boolean hasInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    public static String getFormatedTime(String mills, String format) {
        mills = mills + "000";
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone(Time.TIMEZONE_UTC));
        calendar.setTimeInMillis(Long.parseLong(mills));
        return formatter.format(calendar.getTime());
    }


    public static int getWeatherIcons(String iconsType) {
        if (iconsType.equals(CLEAR_DAY)) {
            return R.drawable.ic_daynightclear;
        } else if (iconsType.equals(CLEAR_NIGHT)) {
            return R.drawable.ic_daynightclear;
        } else if (iconsType.equals(RAIN)) {
            return R.drawable.ic_rain;
        } else if (iconsType.equals(SNOW)) {
            return R.drawable.ic_snow;
        } else if (iconsType.equals(SLEET)) {
            return R.drawable.ic_sleet;
        } else if (iconsType.equals(WIND)) {
            return R.drawable.ic_windy;
        } else if (iconsType.equals(FOG)) {
            return R.drawable.ic_fog;
        } else if (iconsType.equals(CLOUDY)) {
            return R.drawable.ic_cloudy;
        } else if (iconsType.equals(PARTLY_CLOUDY_DAY)) {
            return R.drawable.ic_day_partial;
        } else if (iconsType.equals(PARTLY_CLOUDY_NIGHT)) {
            return R.drawable.ic_night_partly_cloudy;
        }
        return 0;
    }

    public static void appSettingsIntent(Context mContext) {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", mContext.getPackageName(), null);
        intent.setData(uri);
        mContext.startActivity(intent);
    }
}
