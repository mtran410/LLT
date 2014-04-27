package com.example.something;

import java.util.ArrayList;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlayingPage extends Activity {
	
	private ArrayList<Integer> id = new ArrayList<Integer>();//id number for identification
	private ArrayList<Integer> playerDeath =new ArrayList<Integer>();
	TextView name1, name2, name3, name4, name5, name6 , teamName;//to change the players name
	TextView death1, death2, death3, death4, death5, death6;//to change the number of death
	Button health1, health2, health3, health4, health5, health6;//to change the health Bar
	LinearLayout l1, l2, l3, l4, l5, l6;
	TextView player1Image, player2Image, player3Image ,player4Image, player5Image, player6Image;//to change the image
	ArrayList<Boolean> playerDead = new ArrayList<Boolean>();
	boolean light=false;
	int numberPlayer=6;
	public ArrayList<Double>playerHealth= new ArrayList<Double>();
	String teamNames="Dragon Lords";
	Uri notification;
	Ringtone r;
	double value;
	Vibrator v;
	
	 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playingpage);
		v =(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		SensorManager mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
	    Sensor LightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
	     if(LightSensor != null){
	        	mySensorManager.registerListener(
	            LightSensorListener, 
	            LightSensor, 
	            SensorManager.SENSOR_DELAY_NORMAL);
	     }
	     try {
			 notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
			 r = RingtoneManager.getRingtone(getApplicationContext(), notification);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		for(int i=0;i<6; i++){
			id.add(i);
			
			playerDeath.add(i);
			playerHealth.add(1.0);
			playerDead.add(false);
			
		}
		
		
		//passHealth1=1;//set the player health to full
		
		assignView(); //assign view 
		createPlayer(); // put the player on the screen
		setImageAvatar();
		setName();
		setDeath();
		setPlayerHealth(playerHealth.get(0), id.get(0));
		setTeamName(teamNames);
		 
    
		/*for(double i=1; i>=0; i=i-.1)
		{
			
			
			setPlayerHealth(i, id.get(0));
		}*/
		
		//setPlayerHealth(playerHealth.get(2), id.get(2));
	}
	private final SensorEventListener LightSensorListener = new SensorEventListener(){

		 @Override
		   public void onAccuracyChanged(Sensor sensor, int accuracy) {
		    // TODO Auto-generated method stub
		    
		   }
		 @SuppressWarnings("deprecation")
		 @Override
		   public void onSensorChanged(SensorEvent event) {
			    if(event.sensor.getType() == Sensor.TYPE_LIGHT){
			   
			     if (event.values[0]<250.00f) {
			    	 subtractLife(0);
			    	 r.play();

			     }
			    	
			     //else mWakeLock.release();
			    }
			   }
			     
			    };

	//subtract life from player health
	public void subtractLife(Integer id){
		playerHealth.set((int)id, playerHealth.get(id)-0.01);
		setPlayerHealth(playerHealth.get(id), id);
	}
	public void setPlayerHealth(Double lessHealth, Integer playerNum){ //method change the player health must be pass number<=1
	
	if(playerNum == id.get(0)){
		String player1health = ""+lessHealth;
		if(lessHealth<0.0) lessHealth = 0.0;
		health1.setScaleX(Float.parseFloat(player1health));
		if(lessHealth==0.0){
			playerDead.set(0, true);
			player1Image.setText(" X");	
			v.vibrate(3000);
		}
	}
	
	if(playerNum == id.get(1)){
		String player1health = ""+lessHealth;
		if(lessHealth<=0.0) lessHealth = 0.0;
		health2.setScaleX(Float.parseFloat(player1health));
		if(lessHealth==0.0){
			playerDead.set(1, true);
			player2Image.setText(" X");	
		}
	}
	
	
	if(playerNum == id.get(2)){
		String player1health = ""+lessHealth;
		if(lessHealth<0.0) lessHealth = 0.0;
		health3.setScaleX(Float.parseFloat(player1health));
		if(lessHealth==0.0){
			playerDead.set(2, true);
			player3Image.setText(" X");	
		}
	}
	
	
	if(playerNum == id.get(3)){
		String player1health = ""+lessHealth;
		if(lessHealth<0.0) lessHealth = 0.0;
		health4.setScaleX(Float.parseFloat(player1health));
		if(lessHealth==0.0){
			playerDead.set(3, true);
			player4Image.setText(" X");	
		}
	}
	if(playerNum == id.get(4)){
		String player1health = ""+lessHealth;
		if(lessHealth<0.0) lessHealth = 0.0;
		health5.setScaleX(Float.parseFloat(player1health));
		if(lessHealth==0.0){
			playerDead.set(4, true);
			player5Image.setText(" X");	
		}
	}
	
	
	if(playerNum == id.get(5)){
		String player1health = ""+lessHealth;
		if(lessHealth<0.0) lessHealth = 0.0;
		health6.setScaleX(Float.parseFloat(player1health));
		if(lessHealth==0.0){
			playerDead.set(5, true);
			player6Image.setText(" X");	
		}
	}
	
	
}

public void setImageAvatar(){//method changes the player avatar
	player1Image.setBackgroundResource(R.drawable.pic8);
	player2Image.setBackgroundResource(R.drawable.avatar);
	player3Image.setBackgroundResource(R.drawable.pic2);
	player4Image.setBackgroundResource(R.drawable.pic3);
	player5Image.setBackgroundResource(R.drawable.pic4);
	player6Image.setBackgroundResource(R.drawable.pic5);
}

//set the number of death
public void setDeath(){ 
	
	death1.setText(playerDeath.get(0).toString());
	death2.setText(playerDeath.get(1).toString());
	death3.setText(playerDeath.get(2).toString());
	death4.setText(playerDeath.get(3).toString());
	death5.setText(playerDeath.get(4).toString());
	death6.setText(playerDeath.get(5).toString());
}
public void setName(){
	name2.setText("Paul");
	name1.setText("Sang");
	name3.setText("Micheal");
	name4.setText("John");
	name5.setText("Cool Guy");
	name6.setText("Magic Man");
}
public void setTeamName(String name){
	teamName.setText(name);
}

public void assignView(){
	teamName= (TextView)findViewById(R.id.txtTeamName1);
	name1 = (TextView)findViewById(R.id.txtPlayerName1);
	name2 = (TextView)findViewById(R.id.txtPlayerName2);
	name3 = (TextView)findViewById(R.id.txtPlayerName3);
	name4 = (TextView)findViewById(R.id.txtPlayerName4);
	name5 = (TextView)findViewById(R.id.txtPlayerName5);
	name6 = (TextView)findViewById(R.id.txtPlayerName6);
	
	death1 = (TextView)findViewById(R.id.death1);
	death2 = (TextView)findViewById(R.id.death2);
	death3 = (TextView)findViewById(R.id.death3);
	death4 = (TextView)findViewById(R.id.death4);
	death5 = (TextView)findViewById(R.id.death5);
	death6 = (TextView)findViewById(R.id.death6);
	
	//assign to actual xml 
	health1 = (Button)findViewById(R.id.healthBar1);
	health2 = (Button)findViewById(R.id.healthBar2);
	health3 = (Button)findViewById(R.id.healthBar3);
	health4 = (Button)findViewById(R.id.healthBar4);
	health5 = (Button)findViewById(R.id.healthBar5);
	health6 = (Button)findViewById(R.id.healthBar6);
	
	//set the health bar to the right of pic
	health1.setPivotX(1);
	health2.setPivotX(1);
	health3.setPivotX(1);
	health4.setPivotX(1);
	health5.setPivotX(1);
	health6.setPivotX(1);
	
	health1.setLeft(1);
	health2.setLeft(1);
	health3.setLeft(1);
	health4.setLeft(1);
	health5.setLeft(1);
	health6.setLeft(1);
	
	
	//create the dialogue image
	player1Image = (TextView)findViewById(R.id.avatar1);
	player2Image = (TextView)findViewById(R.id.avatar2);
	player3Image = (TextView)findViewById(R.id.avatar3);
	player4Image = (TextView)findViewById(R.id.avatar4);
	player5Image = (TextView)findViewById(R.id.avatar5);
	player6Image = (TextView)findViewById(R.id.avatar6);
	
	//match up LinearLayout
	l1 = (LinearLayout)findViewById(R.id.L1);
	l2 = (LinearLayout)findViewById(R.id.L2);
	l3 = (LinearLayout)findViewById(R.id.L3);
	l4 = (LinearLayout)findViewById(R.id.L4);
	l5 = (LinearLayout)findViewById(R.id.L5);
	l6 = (LinearLayout)findViewById(R.id.L6);
}

public void createPlayer(){
	
	if(numberPlayer>=2){	
		l2.setVisibility(View.VISIBLE);
	}
	if(numberPlayer>=3){	
		l3.setVisibility(View.VISIBLE);
	}
	if(numberPlayer>=4){	
		l4.setVisibility(View.VISIBLE);
	}
	if(numberPlayer>=5){	
		l5.setVisibility(View.VISIBLE);
	}
	if(numberPlayer>=6){	
		l6.setVisibility(View.VISIBLE);
	}
	
	
}

		
		
		
}
