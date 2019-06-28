package songpatechnicalhighschool.motivation.openweatherservice;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    final String OPEN_WEATHER_MAP_KEY = "704a83a5f8f3436366adba0f15c18d38";

    WeatherService weatherService;
    LocationManager lm;
    double longitude;
    double latitude;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        weatherService = new WeatherService();

        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
                getCurrentWeather(Double.toString(latitude), Double.toString(longitude));
            }
        });
    }

    private void getLocation() {
        Location currentLocation = null;
        // Register the listener with the Location Manager to receive location updates
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
            getLocation(); //이건 써도되고 안써도 되지만, 전 권한 승인하면 즉시 위치값 받아오려고 썼습니다!
        } else {

            // 수동으로 위치 구하기
            String locationProvider = LocationManager.GPS_PROVIDER;
            currentLocation = lm.getLastKnownLocation(locationProvider);
            if (currentLocation != null) {
                latitude = currentLocation.getLatitude();
                longitude = currentLocation.getLongitude();
                Log.d("GPSlocation", latitude + ", " + longitude);
            }
        }
    }

    public void getCurrentWeather(String latitude, String longitude) {

        final Call<JsonObject> res = RetrofitClient
                .getInstance()
                .buildRetrofit()
                .getCurrentWeather(latitude, longitude, OPEN_WEATHER_MAP_KEY);

        res.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                String jsonObj = null;
                if (response.body() != null) {
                    jsonObj = response.body().toString();
                     Weather weather = weatherService.weatherToText(response.body());
                        textView.setText(weather.getText() + "\n" + weather.getTemperature()+"도");
                } else {
                    System.out.println(response.toString());
                }
                Log.d("Retrofit", "Success :" + jsonObj);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("Retrofit", "Failure : " + t.getMessage());
            }
        });
    }
}
