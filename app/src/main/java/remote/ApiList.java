package remote;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiList {
    @FormUrlEncoded
    @POST("login")
    Call<Response> loginUser(@Field("email") String email, @Field("password") String password);
}