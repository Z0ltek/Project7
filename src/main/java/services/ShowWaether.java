package services;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import domain.CurrentWeather;


public class ShowWaether {
	
	public StringBuilder make (OpenWeatherMapApiService apiService) 
			throws JsonParseException, JsonMappingException, IOException 
			{
		
		String url = "http://api.openweathermap.org/data/2.5/weather?units"
				+"=metric&lang=pl&appid=e5c66ac902da92c2a1114e3c903d8aa7&q="
				+apiService.getCity();
		

		CurrentWeather currentWeather;
		currentWeather = apiService.getAll(url);
		
		StringBuilder stringBuilder = new StringBuilder();
		
		try {
			stringBuilder.append(
					"<h3>"+currentWeather.getName()+"</h3>"
					+"<h4>"+currentWeather.getWeather()[6]+"</h4>"
					+"<table>"
					+ "<tr><td>Temperatura:</td><td>"+currentWeather.getMain().getTemp()+" <sup>o</sup>C</td></tr>"
					+ "<tr><td>Zachmurzenie:</td><td>"+currentWeather.getClouds().getAll()+"%</td></tr>"
					+ "<tr><td>Cisnienie atmosferyczne:</td><td>"+currentWeather.getMain().getPressure()+" hPa</td></tr>"
					+ "<tr><td>Predkosc wiatru:</td><td>"+currentWeather.getWind().getSpeed()+" m/s</td></tr>"
					+ "</table>"
					
);
		} catch (NullPointerException e) {

			e.printStackTrace();
			stringBuilder.append("<br><br><br>API error...");
			return stringBuilder;
		}
		
		return stringBuilder;
		
	}

}
