package dataaccesslayer;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import Object.RootObject;
import com.google.gson.Gson;

import Model.Weather;

public class Request {
	private static Weather weather;
	final String appid = "a8dc59407794bb568f0bc0c0b8b9f5dc";

	public Request(Weather weathers) {

		Request.weather = weathers;

	}

	public Weather RequestAt(String loc) throws JSONException, IOException {

		String url = "http://api.openweathermap.org/data/2.5/weather?q=" + loc + "&units=metric&APPID=" + appid;
		System.out.println(loc);
		JSONObject yeniJObject = new JSONObject(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));
		Gson gson = new Gson();
		RootObject root = gson.fromJson(yeniJObject.toString(), RootObject.class);
		weather.setLocation(root.getName().toString());
		weather.setDescription(root.getWeather().get(0).getDescription());
		weather.setTemp(root.getMain().getTemp());

		System.out.println(yeniJObject.toString());
		return weather;

	}

}
