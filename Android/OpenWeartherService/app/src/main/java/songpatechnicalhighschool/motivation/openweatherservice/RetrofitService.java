package songpatechnicalhighschool.motivation.openweatherservice;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface RetrofitService {
    @GET("weather?")
    Call<JsonObject> getCurrentWeather(
            @Query("lat") String lat,
            @Query("lon") String lon,
            @Query("APPID") String appID);
}
