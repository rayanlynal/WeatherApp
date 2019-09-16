package remote;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RemoteAPI {
    public static final String BASE_URL = "https://api.darksky.net/forecast/4fcf0d2ae5be0c28c6db9099bc8b692c/37.8267,-122.4233/";

    private static OkHttpClient.Builder httpClient;
    private static Retrofit.Builder builder;

    public static <S> S createService(Class<S> serviceClass, boolean addHeader) {

        httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new HttpLoggingInterceptor().
                setLevel(HttpLoggingInterceptor.Level.BODY));
        httpClient.readTimeout(60, TimeUnit.SECONDS);
        httpClient.connectTimeout(60, TimeUnit.SECONDS);

        if (addHeader) {
            httpClient.addInterceptor(chain -> {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder().addHeader("Authorization", "");
                Request request = requestBuilder.build();
                return chain.proceed(request);
            });
        }

        builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }
}
