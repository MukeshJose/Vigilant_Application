package com.example.vigilantapplication.retrofit;

import com.example.vigilantapplication.model.Root;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("login_client.php")
    Call<Root> CALL_APIUserLogin(@Query("phone") String phone_number, @Query("password") String password, @Query("device_token") String device_token);


    @Multipart
    @POST("client_reg.php")
    Call<Root> CALL_APIRegistration(@Part("name") RequestBody name,
                                    @Part("email") RequestBody email,
                                    @Part("phone") RequestBody phone,
                                    @Part("password") RequestBody password,
                                    @Part("address") RequestBody address,
                                    @Part("id_type") RequestBody id_type,
                                    @Part("id_number") RequestBody id_number);

    @GET("login_vigilance.php")
    Call<Root> CALL_APIOfficerLogin(@Query("id") String id, @Query("password") String password, @Query("device_token") String device_token);
}
