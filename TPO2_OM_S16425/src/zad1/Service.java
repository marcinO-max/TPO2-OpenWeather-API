/**
 *
 *  @author Ossowski Marcin S16425
 *
 */

package zad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Service{
	
	String kraj;
	String miasto;
	String kod_waluty;
	String opisMiasta;
	Double kursWaluty;
	static String apiId = "1567e7d154f7243c6e4976dfc26f5397";
	static double kelvin = 273.15;
	String pogoda;
	
	public Service()
	{
		this.kraj=kraj;	
	}
	

	public String getWeather(String miasto){
		// TODO Auto-generated method stub
		URL url = null;
		String n;
		try {
			url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+ miasto +"&appid="+apiId);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String cont ="";
		try(BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"))){
			String line;
			while((line=in.readLine()) != null){
				cont+=line;
			}
		
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		
		return cont;
	}
	
	public String pogoda(String jsonPogoda) {
		String pogodaString= null;
		try {
			JSONObject jsonObject = new JSONObject(jsonPogoda);
			JSONArray array = jsonObject.getJSONArray("weather");
			JSONObject zero = array.getJSONObject(0);
			pogodaString = zero.getString("description");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pogodaString;
	}
	

	public Double getRateFor(String wal) {
		// TODO Auto-generated method stub
		String url = "https://api.exchangeratesapi.io/latest?base=" + wal;
		String result="";
		Double value = null;
		URL change = null;
		String PLN = "PLN";
		
		try {
			change = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpURLConnection httpurlConnection = null;
		try {
			httpurlConnection = (HttpURLConnection) change.openConnection();
		}catch(IOException e) {
			e.printStackTrace();
		}
			
			try {
				
			if(httpurlConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
				InputStreamReader inputStreamReader = new InputStreamReader(httpurlConnection.getInputStream());
				BufferedReader bReader = new BufferedReader(inputStreamReader);
				String line = null;
			
				while((line = bReader.readLine()) != null) {
					result+= line;
				}
				bReader.close();
				
				JSONObject jsonObject = new JSONObject(result);
				System.out.println(result);
				JSONArray array = jsonObject.getJSONArray("base");
			//	JSONObject zero = array.getJSONObject(0);
			//	System.out.println(array);
			
				
				
			}
			}catch(IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return value;
	}

	public Double getNBPRate(){
		// TODO Auto-generated method stub
		String USD = "USD";
		String url1 = "http://api.nbp.pl/api/exchangerates/rates/a/" + USD + "/";
		Double kursWaluty = null;
		String PLN = "PLN";
		String result = "";
		Double value = null;
		URL url = null;
		try {
			url = new URL(url1);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpURLConnection httpurlConnection = null;
		try {
			httpurlConnection = (HttpURLConnection) url.openConnection();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
			
			try {
				
			if(httpurlConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
				InputStreamReader inputStreamReader = new InputStreamReader(httpurlConnection.getInputStream());
				BufferedReader bReader = new BufferedReader(inputStreamReader);
				String line = null;
				while((line = bReader.readLine()) != null) {
					result+= line;
				}
				bReader.close();
				
				
				
				JSONObject jsonObject = new JSONObject(result);
				
				JSONArray rates = jsonObject.getJSONArray("rates");
				JSONObject zero = rates.getJSONObject(0);
				value = zero.getDouble("mid");
				
				
				
				
		
			}
			
			}catch(IOException e) {
				e.printStackTrace();
	}catch (JSONException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
			return value;
	}
	
	
	
	
	
	


	public String getKraj() {
		return kraj;
	}


	public void setKraj(String kraj) {
		this.kraj = kraj;
	}


	public String getMiasto() {
		return miasto;
	}


	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}


	public String getKod_waluty() {
		return kod_waluty;
	}


	public void setKod_waluty(String kod_waluty) {
		this.kod_waluty = kod_waluty;
	}


	public String getOpisMiasta() {
		return opisMiasta;
	}


	public void setOpisMiasta(String opisMiasta) {
		this.opisMiasta = opisMiasta;
	}


	public Double getKursWaluty() {
		return kursWaluty;
	}


	public void setKursWaluty(Double kursWaluty) {
		this.kursWaluty = kursWaluty;
	}


	public static String getApiId() {
		return apiId;
	}


	public static void setApiId(String apiId) {
		Service.apiId = apiId;
	}


	
}  
