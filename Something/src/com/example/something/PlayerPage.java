package com.example.something;




import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerPage extends FragmentActivity {
	private int id1, id2, id3, id4, id5, id6,numberPlayer=6;//id number for identification
	private int play1Death,play2Death ,play3Death,play4Death, play5Death,play6Death;
	TextView name1, name2, name3, name4, name5, name6 ;//to change the players name
	TextView death1, death2, death3, death4, death5, death6;//to change the number of death
	TextView health1, health2, health3, health4, health5, health6;//to change the health Bar
	TextView player1Image, player2Image, player3Image ,player4Image, player5Image, player6Image;//to change the image
	boolean play1dead= false;
	private float passHealth1;
	private float healthDecrament;
	TextView textLIGHT_available, textLIGHT_reading;
	String changeHealthBar;
	Ringtone r; //sound to play when hit
	Uri notification;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playerpage);
		play1Death=play2Death=play3Death=play4Death= play5Death=play6Death=6; //number of death the players have
		passHealth1=1;//set the player health to full
		healthDecrament =(float) 0.00000003;
		createPlayer(); // put the player on the screen
		assignView(); //assign view 
		setImageAvatar();
		setName();
		setDeath();
		setPlayerHealth();
		//textLIGHT_available = (TextView)findViewById(R.id.LIGHT_available);
        //textLIGHT_reading = (TextView)findViewById(R.id.LIGHT_reading);
		
		SensorManager mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);//create a sensor manager
		Sensor LightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);//create a light sensor object
		
	
	       mySensorManager.registerListener(
	            LightSensorListener, 
	            LightSensor, 
	            SensorManager.SENSOR_DELAY_NORMAL);
	        
	        
	        try {
				 notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
				 r = RingtoneManager.getRingtone(getApplicationContext(), notification);
			} catch (Exception e) {
			    e.printStackTrace();
			}
	
		
		
		
	}
	private final SensorEventListener LightSensorListener = new SensorEventListener(){
		   @Override
		   public void onAccuracyChanged(Sensor sensor, int accuracy) {
		    // TODO Auto-generated method stub
		   }

		   @Override
		   public void onSensorChanged(SensorEvent event) {
			 //if(event.sensor.getType() == Sensor.TYPE_LIGHT)
			    // health1.setText("LIGHT: " + event.values[0]);
			 if(event.values[0]>20){
				 passHealth1 = passHealth1-healthDecrament;
				 if(passHealth1<=0){
					 passHealth1 =0;
					 play1dead = true;
					 health1.setText(changeHealthBar);
				 }
				 if(play1dead == false){
					 changeHealthBar = ""+passHealth1;
					 health1.setText(changeHealthBar);
					 r.play();
				 }
			 }
		   }
		};
	public void setPlayerHealth(){ //method change the player health must be pass number<=1
		String player1health = ""+1;
		health1.setText(player1health);
		
		String player2health = ""+1;
		health2.setText(player2health);
		
		String player3health = ""+.8;
		health3.setText(player3health);
		
		String player4health = ""+.6;
		health4.setText(player4health);
		
		String player5health = ""+0;
		health5.setText(player5health);
		
		String player6health = ""+1;
		health6.setText(player6health);
		
	}
	
	public void setImageAvatar(){//method changes the player avatar
		
		player1Image.setBackgroundResource(R.drawable.pic1);
		player2Image.setBackgroundResource(R.drawable.avatar);
		player3Image.setBackgroundResource(R.drawable.pic2);
		player4Image.setBackgroundResource(R.drawable.pic3);
		player5Image.setBackgroundResource(R.drawable.pic4);
		player6Image.setBackgroundResource(R.drawable.pic5);
	}
	
	public void setDeath(){ 
		String temp = ""+play1Death;
		death1.setText(temp);
		death2.setText(temp);
		death3.setText(temp);
		death4.setText(temp);
		death5.setText(temp);
		death6.setText(temp);
	}
	public void setName(){
		name2.setText("Paul");
		name1.setText("Sang");
		name3.setText("Micheal");
		name4.setText("John");
		name5.setText("Cool Guy");
		name6.setText("Magic Man");
	}
	
	public void assignView(){
		name1 = (TextView)findViewById(R.id.msg);
		name2 = (TextView)findViewById(R.id.msg2);
		name3 = (TextView)findViewById(R.id.msg3);
		name4 = (TextView)findViewById(R.id.msg4);
		name5 = (TextView)findViewById(R.id.msg5);
		name6 = (TextView)findViewById(R.id.msg6);
		
		death1 = (TextView)findViewById(R.id.d1);
		death2 = (TextView)findViewById(R.id.d2);
		death3 = (TextView)findViewById(R.id.d3);
		death4 = (TextView)findViewById(R.id.d4);
		death5 = (TextView)findViewById(R.id.d5);
		death6 = (TextView)findViewById(R.id.d6);
		
		health1 = (TextView)findViewById(R.id.h1);
		health2 = (TextView)findViewById(R.id.h2);
		health3 = (TextView)findViewById(R.id.h3);
		health4 = (TextView)findViewById(R.id.h4);
		health5 = (TextView)findViewById(R.id.h5);
		health6 = (TextView)findViewById(R.id.h6);
		
		//create the dialogue image
		player1Image = (TextView)findViewById(R.id.p1Image);
		player2Image = (TextView)findViewById(R.id.p2Image);
		player3Image = (TextView)findViewById(R.id.p3Image);
		player4Image = (TextView)findViewById(R.id.p4Image);
		player5Image = (TextView)findViewById(R.id.p5Image);
		player6Image = (TextView)findViewById(R.id.p6Image);
	}
	
	public void createPlayer(){
		if(numberPlayer>=1){
			FragmentManager fM = getFragmentManager();
			FragmentTransaction fT = fM.beginTransaction();
			PlayerFragment newFrag = new PlayerFragment();
			
			fT.add(R.id.myLay1, newFrag);
			
			fT.commit();
			
			//fM.beginTransaction();
			//newFrag.setName("John Pham");
			//fT.commit();
		}
		if(numberPlayer>=2){	
			FragmentManager fM2 = getFragmentManager();
			FragmentTransaction fT2 = fM2.beginTransaction();
			PlayerFragment2 newFrag2 = new PlayerFragment2();
			fT2.add(R.id.myLay2, newFrag2);
			fT2.commit();
			
			
		}
		if(numberPlayer>=3){	
			FragmentManager fM3 = getFragmentManager();
			FragmentTransaction fT3 = fM3.beginTransaction();
			PlayerFragment3 newFrag3 = new PlayerFragment3();
			fT3.add(R.id.myLay3, newFrag3);
			fT3.commit();
		}
		if(numberPlayer>=4){	
			FragmentManager fM4 = getFragmentManager();
			FragmentTransaction fT4 = fM4.beginTransaction();
			PlayerFragment4 newFrag4 = new PlayerFragment4();
			fT4.add(R.id.myLay4, newFrag4);
			fT4.commit();
		}
		if(numberPlayer>=5){	
			FragmentManager fM5 = getFragmentManager();
			FragmentTransaction fT5 = fM5.beginTransaction();
			PlayerFragment5 newFrag5 = new PlayerFragment5();
			fT5.add(R.id.myLay5, newFrag5);
			fT5.commit();
		}
		if(numberPlayer>=6){	
			FragmentManager fM6 = getFragmentManager();
			FragmentTransaction fT6 = fM6.beginTransaction();
			PlayerFragment6 newFrag6 = new PlayerFragment6();
			fT6.add(R.id.myLay6, newFrag6);
			fT6.commit();
		}
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.timer, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.playerpage, container,
					false);
			return rootView;
		}
	}

}
