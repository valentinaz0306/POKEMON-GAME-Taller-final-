package model;

import threads.ChronometerThread;

public class Chronometer {
	
	    //-------------------------------------
	    // Atributtes 
	    //-------------------------------------
	
	    private int min;
	    private int sec;
	    private String time;

	    //-------------------------------------
	    // Constructor
	    //-------------------------------------
	    public Chronometer() {
	        int min=0;
	        int sec=0;
	        time="";
	       
	    }

	    public void changeTime(String time) {
	        this.time=time;
	    }
	    public String getTime() {
	        return time;
	    }


}
