package com.example.QuantityMeasurementApp;

public class QuantityMeasuringApp {
	
   public static class Feet{
	   private final double value;
	   
	   public Feet(double value) {
		   this.value=value;
	   }
	   
	   @Override
	   public boolean equals(Object obj) {
		    
		   if(this==obj) {
			   return true;
		   }
		   
		   if(obj==null) {
			   return false;
		   }
		   
		   if(getClass()!=obj.getClass()) {
			   return false;
		   }
		   
		   Feet f=(Feet)obj;
		   
		   return Double.compare(this.value, f.value)==0;
	   }
	   
	   @Override
	   public int hashCode() {
		   return Double.hashCode(value);
	   }
   }
   
   public static void main(String[]args) {
	   
	   Feet v1=new Feet(1.0);
	   Feet v2=new Feet(1.0);
	   
	   boolean result=v1.equals(v2);
	   
	   System.out.println("both are : "+result);
	   
   }
}
