package com.assignment7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class HousingSale {
    double price;
    double squareFootage;

    public HousingSale(double price, double squareFootage) {
        this.price = price;
        this.squareFootage = squareFootage;
    }
}
public class HousingAnalyzer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<HousingSale> sales = new ArrayList<>();
	     sales.add(new HousingSale(150000, 1200));
	     sales.add(new HousingSale(180000, 1400));
	     sales.add(new HousingSale(220000, 1600));
	     sales.add(new HousingSale(250000, 1800));
	     sales.add(new HousingSale(280000, 2000));
	     sales.add(new HousingSale(300000, 2200));
	     sales.add(new HousingSale(500000, 2200));
	      
	     HashMap<String, ArrayList<Double>> hm = new HashMap<>();
	        
	     hm.put("$100,000-200,000", new ArrayList<Double>(Arrays.asList(0.0, 0.0)));
	     hm.put("$200,000-300,000", new ArrayList<Double>(Arrays.asList(0.0, 0.0)));
	     hm.put("above $300,000", new ArrayList<Double>(Arrays.asList(0.0, 0.0)));
	     
	     for (HousingSale sale : sales) {
	            double price = sale.price;
	            double squareFootage = sale.squareFootage;
	            if(price >= 100000.0 && price < 200000.0)
	            {
	            	ArrayList<Double> ardata;
	                ardata = hm.get("$100,000-200,000");
	                ardata.set(0, ardata.get(0)+1);
	                ardata.set(1, ardata.get(1)+squareFootage);
	            	hm.put("$100,000-200,000", ardata);
	            }
	            else if(price >= 200000.0 && price < 300000.0)
	            {
	            	ArrayList<Double> ardata;
	            	ardata = hm.get("$200,000-300,000");
	            	ardata.set(0, ardata.get(0)+1);
	                ardata.set(1, ardata.get(1)+squareFootage);
	            	hm.put("$200,000-300,000", ardata);
	            }
	            else if(price >= 300000.0)
	            {
	            	ArrayList<Double> ardata;
	            	ardata = hm.get("above $300,000");
	            	ardata.set(0, ardata.get(0)+1);
	                ardata.set(1, ardata.get(1)+squareFootage);
	            	hm.put("above $300,000", ardata);
	            	
	            }
	     }
	     for(String priceRange : hm.keySet())
	       {
	    	   
	    	   ArrayList<Double> ardata = hm.get(priceRange);
	    	   if(ardata.get(0) != 0.0 && ardata.get(1) != 0.0)
	    	   {
	    	      System.out.println(priceRange+" : No of houses sold : "+ardata.get(0).intValue()+" and Average squareFootage :  "+(ardata.get(1)/ardata.get(0)));
	    	   }
	    	   else
	    	   {
	    		   System.out.println(priceRange+" : No of houses sold : "+0+" and Average squareFootage :  "+0.0);
	    	   }
	       }
	}

}
