package com.assignment7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MedicalTestAnalyzer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Double> testResults = new ArrayList<>();
        testResults.add(75.0);
        testResults.add(90.0);
        testResults.add(105.0);
        testResults.add(110.0);
        testResults.add(80.0);
        testResults.add(120.0);
        HashMap<String, ArrayList<Double>> hm = new HashMap<>();
        hm.put("normal",new ArrayList<Double>(Arrays.asList(0.0, 0.0)));
        hm.put("borderline",new ArrayList<Double>(Arrays.asList(0.0, 0.0)));
        hm.put("high",new ArrayList<Double>(Arrays.asList(0.0, 0.0)));
        for (Double val : testResults) {
        	if (val >= 70.0  && val < 100.0)
        	{
        		ArrayList<Double> ar = hm.get("normal");
        		ar.set(0, ar.get(0)+1);
        		ar.set(1, ar.get(1)+val);
        		hm.put("normal", ar);
        	}
        	else if (val >= 100.0  && val < 120.0)
        	{
        		ArrayList<Double> ar = hm.get("borderline");
        		ar.set(0, ar.get(0)+1);
        		ar.set(1, ar.get(1)+val);
        		hm.put("borderline", ar);
        	}
        	else
        	{
        		ArrayList<Double> ar = hm.get("high");
        		ar.set(0, ar.get(0)+1);
        		ar.set(1, ar.get(1)+val);
        		hm.put("high", ar);
        	}
        }
        System.out.println(hm);
        for(String range : hm.keySet())
        {
     	   
     	   ArrayList<Double> ardata = hm.get(range);
     	   if(ardata.get(0) != 0.0 && ardata.get(1) != 0.0)
     	   {
     	      System.out.println(range+" - No of Patients : "+ardata.get(0).intValue()+" and Average value :  "+(float)(ardata.get(1)/ardata.get(0)));
     	   }
     	   else
     	   {
     		   System.out.println(range+" - No of Patients : "+0+" and Average value:  "+0.0);
     	   }
        }
	}

}
