package test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.json.JsonException;

import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;

import com.sun.jersey.api.client.ClientHandlerException;

import services.OpenWeatherMapApiService;

public class TestOpenWeatherMapApiService {

	@Test(expected = ClientHandlerException.class) 
	public void test_should_give_exception_when_url_is_wrong() throws JsonMappingException, JsonException, IOException {
		
		OpenWeatherMapApiService apiService = new OpenWeatherMapApiService();
		apiService.getAll("openwaether.xx");
		
		
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void test_should_give_exception_when_name_of_city_is_wrong() throws JsonMappingException, JsonException, IOException {
		
		OpenWeatherMapApiService apiService = new OpenWeatherMapApiService();
		apiService.getAll("http://api.openweathermap.org/data/2.5/weather?units"
				+"=metric&lang=pl&appid=e5c66ac902da92c2a1114e3c903d8aa7&q=Zielona Gora");
		
		
	}

}
