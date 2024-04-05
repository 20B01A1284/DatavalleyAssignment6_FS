package com.assignment7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class WeatherData {
    double temperature;
    double humidity;

    public WeatherData(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }
}

public class WeatherAnalyzer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<WeatherData> weatherDataList = new ArrayList<>();
        weatherDataList.add(new WeatherData(5.0, 60.0));
        weatherDataList.add(new WeatherData(15.0, 70.0));
        weatherDataList.add(new WeatherData(25.0, 75.0));
        weatherDataList.add(new WeatherData(8.0, 80.0));
        weatherDataList.add(new WeatherData(12.0, 65.0));
        weatherDataList.add(new WeatherData(18.0, 72.0));
        
        HashMap<String, ArrayList<Double>> hm = new HashMap<>();
       
        hm.put("0°C", new ArrayList<Double>(Arrays.asList(0.0, 0.0)));
        hm.put("0-10°C", new ArrayList<Double>(Arrays.asList(0.0, 0.0)));
        hm.put("10-20°C", new ArrayList<Double>(Arrays.asList(0.0, 0.0)));
        hm.put("20-30°C", new ArrayList<Double>(Arrays.asList(0.0, 0.0)));
        hm.put(">=30°C", new ArrayList<Double>(Arrays.asList(0.0, 0.0)));
        for (WeatherData data : weatherDataList) {
            double temperature = data.temperature;
            double humidity = data.humidity;
            if(temperature == 0.0)
            {
            	ArrayList<Double> ardata;
                ardata = hm.get("0°C");
                ardata.set(0, ardata.get(0)+1);
                ardata.set(1, ardata.get(1)+humidity);
            	hm.put("0°C", ardata);
            }
            else if(temperature > 0.0 && temperature < 10.0)
            {
            	ArrayList<Double> ardata;
            	ardata = hm.get("0-10°C");
            	ardata.set(0, ardata.get(0)+1);
                ardata.set(1, ardata.get(1)+humidity);
            	hm.put("0-10°C", ardata);
            }
            else if(temperature > 10.0 && temperature < 20.0)
            {
            	ArrayList<Double> ardata;
            	ardata = hm.get("10-20°C");
            	ardata.set(0, ardata.get(0)+1);
                ardata.set(1, ardata.get(1)+humidity);
            	hm.put("10-20°C", ardata);
            }
            else if(temperature > 20.0 && temperature < 30.0)
            {
            	ArrayList<Double> ardata;
            	ardata = hm.get("20-30°C");
            	ardata.set(0, ardata.get(0)+1);
                ardata.set(1, ardata.get(1)+humidity);
            	hm.put("20-30°C", ardata);
            }
            else
            {
            	ArrayList<Double> ardata;
            	ardata = hm.get(">=30°C");
            	ardata.set(0, ardata.get(0)+1);
                ardata.set(1, ardata.get(1)+humidity);
            	hm.put(">=30°C", ardata);
            }
        }
    
       for(String temp : hm.keySet())
       {
    	   
    	   ArrayList<Double> ardata = hm.get(temp);
    	   if(ardata.get(0) != 0.0 && ardata.get(1) != 0.0)
    	   {
    	      System.out.println(temp+" : No of Days : "+ardata.get(0).intValue()+" and Average Humidity :  "+(ardata.get(1)/ardata.get(0)));
    	   }
    	   else
    	   {
    		   System.out.println(temp+" : No of Days : "+0+" and Average Humidity :  "+0.0);
    	   }
       }
	}

}
