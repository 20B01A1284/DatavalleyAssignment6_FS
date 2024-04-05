package com.assignment7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WorkHoursAnalyzer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Double>> workHoursList = new ArrayList<>();
        workHoursList.add(new ArrayList<Double>(Arrays.asList(8.0, 8.0, 8.0, 8.0, 8.0))); 
        workHoursList.add(new ArrayList<Double>(Arrays.asList(7.0, 7.0, 9.0, 9.0, 8.0)));
        workHoursList.add(new ArrayList<Double>(Arrays.asList(9.0, 8.0, 8.0, 8.0, 8.0)));
        workHoursList.add(new ArrayList<Double>(Arrays.asList(9.0, 9.0, 9.0, 8.0, 8.0)));
        workHoursList.add(new ArrayList<Double>(Arrays.asList(7.0, 8.0, 8.0, 8.0, 8.0)));
        workHoursList.add(new ArrayList<Double>(Arrays.asList(9.0, 9.0, 9.0, 9.0, 8.0)));
        HashMap<String, ArrayList<Double>> hm = new HashMap<>();
        hm.put("<40hrs",new ArrayList<Double>(Arrays.asList(0.0, 0.0)));
        hm.put("40hrs",new ArrayList<Double>(Arrays.asList(0.0, 0.0)));
        hm.put(">40hrs",new ArrayList<Double>(Arrays.asList(0.0, 0.0)));
        for (ArrayList<Double> hrs_list : workHoursList) {
        	Double total_hrs = 0.0;
        	for(Double hr : hrs_list)
        	{
        		total_hrs += hr;
        	}
        	if (total_hrs < 40)
        	{
        		ArrayList<Double> ar = hm.get("<40hrs");
        		ar.set(0, ar.get(0)+1);
        		ar.set(1, ar.get(1)+total_hrs);
        		hm.put("<40hrs", ar);
        	}
        	else if (total_hrs == 40)
        	{
        		ArrayList<Double> ar = hm.get("40hrs");
        		ar.set(0, ar.get(0)+1);
        		ar.set(1, ar.get(1)+total_hrs);
        		hm.put("40hrs", ar);
        	}
        	else
        	{
        		ArrayList<Double> ar = hm.get(">40hrs");
        		ar.set(0, ar.get(0)+1);
        		ar.set(1, ar.get(1)+total_hrs);
        		hm.put(">40hrs", ar);
        	}
        }
        for(String range : hm.keySet())
        {
     	   
     	   ArrayList<Double> ardata = hm.get(range);
     	   if(ardata.get(0) != 0.0 && ardata.get(1) != 0.0)
     	   {
     	      System.out.println(range+" - No of workers : "+ardata.get(0).intValue()+" and Average working hrs per day :  "+(float)((ardata.get(1)/ardata.get(0)/5)));
     	   }
     	   else
     	   {
     		   System.out.println(range+" - No of workers : "+0+" and Average working hrs per day :  "+0.0);
     	   }
        }
	}

}
