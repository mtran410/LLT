package com.example.helloworld;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView textLIGHT_available, textLIGHT_reading;
	 Uri notification;
	 Ringtone r;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 textLIGHT_available 
         = (TextView)findViewById(R.id.LIGHT_available);
        textLIGHT_reading 
         = (TextView)findViewById(R.id.LIGHT_reading);
        
        SensorManager mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        
        Sensor LightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(LightSensor != null){
         textLIGHT_available.setText("Sensor.TYPE_LIGHT Available");
         mySensorManager.registerListener(
           LightSensorListener, 
           LightSensor, 
           SensorManager.SENSOR_DELAY_NORMAL);
         
        }else{
         textLIGHT_available.setText("Sensor.TYPE_LIGHT NOT Available");
        }
        
        try {
			 notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
			 r = RingtoneManager.getRingtone(getApplicationContext(), notification);
		  
		 } catch (Exception e) {
		    e.printStackTrace();
		 }
       

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private final SensorEventListener LightSensorListener
	     = new SensorEventListener(){

		
	   @Override
	   public void onAccuracyChanged(Sensor sensor, int accuracy) {
	    // TODO Auto-generated method stub
	    
	   }

	   @Override
	   public void onSensorChanged(SensorEvent event) {
		 if(event.sensor.getType() == Sensor.TYPE_LIGHT){
		     textLIGHT_reading.setText("LIGHT: " + event.values[0]);
		    }
		 if(event.values[0]>200){
			 r.play();
		 }
		
	   }
	   
	};

}
