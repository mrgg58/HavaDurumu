package ModelView;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.json.JSONException;

import Model.Weather;
import dataaccesslayer.Request;

public class Manage {

	private Request req;
	private Weather weather;
	private String location;

	public Manage(Request reqs, Weather weathers) {
		req =  reqs;
		weather = weathers;
	}

	public Weather  modalAta() throws JSONException, IOException {
		weather = req.RequestAt(location);
		return weather;
	}

	public void setLocation(String location) {
		
		if(location.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Girdiðiniz boþ");
			
			
		}
		if(location.contains("1234567890")) {
			
			JOptionPane.showMessageDialog(null,"Sayý giremezsiniz");
			
			
		}
			
		this.location = location;
		
	}
	

}
