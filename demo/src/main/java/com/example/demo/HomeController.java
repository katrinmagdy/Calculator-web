package com.example.demo;

public class HomeController {


    public float Add(float x, float y){
        return x+y;
    }

    public float Subtract(float x , float y){
        return x-y;
    }

    public float multiply(float x, float y){
        return x*y;
    }

    public String divide(float x , float y){
        float z=0;
    	if(y==0) {
    		return "E";
    	}
    	else {
            z=(float)((x*1.0)/y);
            String s = Float.toString(z);
    		return s;
    	}
    }

    public String squareroot(double x){
        if(x<0){
            return "E";
        }
        else{
            String s = Double.toString(Math.sqrt(x)) ;
            return s;

        }

        
    }
}
