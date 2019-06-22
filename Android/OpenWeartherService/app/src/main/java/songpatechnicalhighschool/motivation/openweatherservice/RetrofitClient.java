package songpatechnicalhighschool.motivation.openweatherservice;

import android.util.Log;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    public static RetrofitClient retrofitClient = new RetrofitClient();

    public RetrofitClient() {

    }

    public static RetrofitClient getInstance() {
        return retrofitClient;
    }

    public RetrofitService buildRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        return retrofitService;
    }
}
