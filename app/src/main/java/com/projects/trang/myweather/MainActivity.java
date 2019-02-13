package com.projects.trang.myweather;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.openweathermap.OpenWeatherMap;
import com.projects.trang.myweather.common.common;
import com.projects.trang.myweather.helper.helper;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity implements LocationListener {

    //Declare variables
    private static final String TAG = MainActivity.class.getName();
    TextView txtCity, txtLastUpdate, txtDescription, txtHumidity, txtTime, txtCelsius;
    ImageView imageView;
    LocationManager locationManager;
    OpenWeatherMap openWeatherMap;
    int MY_PERMISSION = 0;
    helper a_helper = new helper();
    String api_request_str;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Control
        txtCity = (TextView) findViewById(R.id.txtCity);
        txtLastUpdate = (TextView) findViewById(R.id.txtLastUpdate);
        txtDescription = (TextView) findViewById(R.id.txtDescription);
        txtHumidity = (TextView) findViewById(R.id.txtHumidity);
        txtTime = (TextView) findViewById(R.id.txtTime);
        imageView = (ImageView) findViewById(R.id.ImagineView);
        //btnrequestAPI =(Button) findViewById(R.id.btnrequestAPI);
        txtCelsius = (TextView) findViewById(R.id.txtCelsius);

       //Get coordinate
        Location location = this.getLocation();
        this.onLocationChanged(location);

        api_request_str = common.APIRequest(String.valueOf(location.getLatitude()),String.valueOf(location.getLongitude()));
        Log.d(TAG, api_request_str);

        new GetWeather().execute(api_request_str);

    }

    private void printDataForDebug(OpenWeatherMap openWeatherMap){
        Log.d(TAG, "Lon: " + String.valueOf(openWeatherMap.getCoord().getLon()));
        Log.d(TAG, "Lat: " + String.valueOf(openWeatherMap.getCoord().getLat()));
        Log.d(TAG, "City: " + String.valueOf(openWeatherMap.getName()));
        Log.d(TAG, "Country: " + String.valueOf(openWeatherMap.getSys().getCountry()));
        Log.d(TAG, "Description: " + String.valueOf(openWeatherMap.getWeather().get(0).getDescription()));
        Log.d(TAG, "Humidity: " + String.valueOf(openWeatherMap.getMain().getHumidity()));
        Log.d(TAG, "Sunrise: " + String.valueOf(openWeatherMap.getSys().getSunrise()));
        Log.d(TAG, "Sunset: " + String.valueOf(openWeatherMap.getSys().getSunset()));
        Log.d(TAG, "Temp: " + String.valueOf(openWeatherMap.getMain().getTemp()));
    }

    private OpenWeatherMap convertFromJSonToObject(String str_data){
        Gson gson = new Gson();
        return gson.fromJson(str_data,OpenWeatherMap.class);

    }

    //Check permission
    private void checkPermission(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    Manifest.permission.INTERNET,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
            }, MY_PERMISSION);

        }
    }

    private Location getLocation(){
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        this.checkPermission();
        Location location = locationManager.getLastKnownLocation( LocationManager.NETWORK_PROVIDER);
        if (location == null) {
            //Log.e("TAG", "No location");
            location = new Location("dummyprovider");
            location.setLatitude(48.185556);
            location.setLongitude(16.324813);

        }
        return location;
    }
    @Override
    protected void onPause() {
        super.onPause();

        this.checkPermission();
        locationManager.removeUpdates(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.checkPermission();
        locationManager.requestLocationUpdates( LocationManager.NETWORK_PROVIDER, 400, 1, this);
    }

    @Override
    public void onLocationChanged(Location location) {

        api_request_str = common.APIRequest(String.valueOf(location.getLatitude()),String.valueOf(location.getLongitude()));
        Log.d(TAG, api_request_str);
        new GetWeather().execute(api_request_str);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    private class GetWeather extends AsyncTask<String,Void,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            String stream = null;
            String urlstring = params[0];

            helper http = new helper();
            stream = http.GetHTTPData(urlstring);

            return stream;

        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if(result.contains("Error:Not found City")){
                progress.dismiss();
                return;
            }

            Gson gson = new Gson();
            openWeatherMap= convertFromJSonToObject(result);

            txtCity.setText(String.format("%s,%s",openWeatherMap.getName(),openWeatherMap.getSys().getCountry()));
            System.out.println("City Name: " + openWeatherMap.getName());
            txtLastUpdate.setText((String.format("Last update: %s", common.GetDateNow())));
            txtDescription.setText(String.format("Description: %s",openWeatherMap.getWeather().get(0).getDescription()));
            txtHumidity.setText(String.format("Humidity: %.2f %%",openWeatherMap.getMain().getHumidity()));
            txtTime.setText(String.format("Sunrise/sunset: %s/%s",common.UnixTimeStampToDateTime(openWeatherMap.getSys().getSunrise()),common.UnixTimeStampToDateTime(openWeatherMap.getSys().getSunset())));
            txtCelsius.setText(String.format("Temperature: %.2f °C",openWeatherMap.getMain().getTemp()));

            Picasso.with(MainActivity.this)
                    .load(common.GetImagine(openWeatherMap.getWeather().get(0).getIcon()))
                    .into(imageView);

        }
    }
}
