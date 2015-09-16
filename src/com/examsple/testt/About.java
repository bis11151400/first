package com.examsple.testt;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.*;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

public class About extends Activity {
	private String url1 = "http://api.openweathermap.org/data/2.5/weather?q=tehran"; 
	
	Button load;
	TextView weather,humidity,windSpeed;
	String weatherResult;
	double windSpeedResult;
	int humidityResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		load=(Button)findViewById(R.id.btnLoad);
		
		weather=(TextView)findViewById(R.id.tvWeatherValue);
		humidity=(TextView)findViewById(R.id.tvHumidityValue);
		windSpeed=(TextView)findViewById(R.id.tvWindSpeedValue);
		
		load.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				ReadJSON rj=new ReadJSON();
				rj.execute();
			}
		});
	
	}
	class ReadJSON extends AsyncTask<String, String, String> {
		 
           protected String doInBackground(String... args) {
        	InputStream jsonStream=getStreamFromURL(url1,"GET");
        	String jsonString=streamToString(jsonStream);
        	parseJSON(jsonString);
        	return null;
        }
        
        protected void onPostExecute(String file_url) {
        	weather.setText(weatherResult);
        	windSpeed.setText(""+windSpeedResult);
        	humidity.setText(""+humidityResult);
        }
 
    }
	
	void parseJSON(String JSONString){
		try {
			
			JSONObject jo=new JSONObject(JSONString);
			
			JSONArray weatherArray=jo.getJSONArray("weather");
			JSONObject firstWeatherArrayObject=weatherArray.getJSONObject(0);
			weatherResult=firstWeatherArrayObject.getString("description");
			
			JSONObject windObject=jo.getJSONObject("wind");
			windSpeedResult=windObject.getDouble("speed");
			
			JSONObject mainObject=jo.getJSONObject("main");
			humidityResult=mainObject.getInt("humidity");
			
		} catch (JSONException e) {}
	}
	InputStream getStreamFromURL(String urlString,String method){
		try {
			URL url=new URL(urlString);
			HttpURLConnection huc=(HttpURLConnection)url.openConnection();
			huc.setReadTimeout(10000);
			huc.setConnectTimeout(15000);
			huc.setRequestMethod(method);
			huc.setDoInput(true);
			
			huc.connect();
			
			return huc.getInputStream();
		} catch (Exception e) {
			return null;
		}
		
	}
	String streamToString(InputStream is){
		String result="";
		String line=null;
		
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			while((line=br.readLine())!=null){
				result=line+"\n";
			}
		} catch (Exception e) {}
		
		return result;
	}
	
	
	
}