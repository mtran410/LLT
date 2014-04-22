package com.example.something;

import java.io.IOException;

import android.support.v7.app.ActionBarActivity;
import android.content.*;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.os.Build;

public class TimerActivity extends Activity implements OnClickListener {	 	 
	 private CountDownTimer countDownTimer;
	 private boolean timerHasStarted = false;//start or not
	 private Button startB;//button 
	 public TextView text;//text box
	 private final long seconds = 15;//second to count down from
	 private final long startTime = seconds * 1000;
	 private final long interval = 1 * 1000;
	 public MediaPlayer myMedia;//play sound
	 
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_timer);
	  startB = (Button) this.findViewById(R.id.button);//start button
	  startB.setOnClickListener(this);//listener for start button
	  text = (TextView) this.findViewById(R.id.timer);//timer display
	  countDownTimer = new MyCountDownTimer(startTime, interval);//instance of class 
	  text.setText(text.getText() + String.valueOf(startTime / 1000));//set initial time
	  myMedia = MediaPlayer.create(this, R.raw.count5);//to play sound countdown
	 }
	 
	 public void onClick(View v) {//do on click
	  if (!timerHasStarted) {//initial start button value
	   countDownTimer.start();//start the timer
	   timerHasStarted = true;
	   startB.setText("STOP");//change the button to stop
	  // if(startB.getText().toString() == "STOP")//sound file right now not sinc
		   //myMedia.pause();
	  } else {
	   countDownTimer.cancel();//if count down started then do if push again
	   timerHasStarted = false;//
	   startB.setText("RESTART");//button display restart
	  // if(startB.getText().toString() == "RESTART")
		  // myMedia.stop();
	  }
	 }
	 
	 public class MyCountDownTimer extends CountDownTimer {
	  public MyCountDownTimer(long startTime, long interval) {//constructor
	   super(startTime, interval);
	  }
	 
	  @Override
	  public void onFinish() {//when finish display
	   text.setText("Battle On!");
	   startActivity(new Intent(TimerActivity.this, PlayerPage.class));//go to next page when 10 second left
	    
	  }
	 
	  @Override
	  public void onTick(long millisUntilFinished) {//for each tick of second
		  if( millisUntilFinished / 1000 < 11){//when reach ten start sound
			  text.setTextSize(100);
			  text.setText("Get Ready");
			  myMedia.start();//start sound
			  
		  }
		  else{
			  text.setText("" + millisUntilFinished / 1000);//display the countdown
		  }
	  }
	 }
	 
	}