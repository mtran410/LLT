package com.example.something;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerFragment2 extends Fragment {
	TextView name2;
	TextView Msg, msgDeath;
	TextView numDeath;
	   public View onCreateView(LayoutInflater inflater,
	      ViewGroup container, Bundle savedInstanceState) {
	      
	      View v= inflater.inflate(R.layout.playerfragment2, container, false);
	      
	     name2 = (TextView)v.findViewById(R.id.txtPlayerName2);
	     TextView Msg = (TextView)getActivity().findViewById(R.id.msg2);
	     String MSG = Msg.getText().toString();
	     name2.setText(MSG);
	     
	     //code to change the number of death
	     TextView  numDeath, msgDeath;
	     numDeath = (TextView)v.findViewById(R.id.death2);
	     msgDeath = (TextView)getActivity().findViewById(R.id.d2);
	     String MSG2 = msgDeath.getText().toString();
	     numDeath.setText(MSG2);
	     
	   //code to change the image from activity
	     TextView playImage, msgImage;
	     playImage = (TextView)v.findViewById(R.id.avatar2);
	     msgImage = (TextView)getActivity().findViewById(R.id.p2Image);
	     playImage.setBackground(msgImage.getBackground());
	     

	     //code to change health bar
	     Button healthButton;
	     TextView healthCount;
	     healthButton = (Button)v.findViewById(R.id.healthBar2);
	     healthCount = (TextView)getActivity().findViewById(R.id.h2);
	     String healthSubtract =healthCount.getText().toString();
	     healthButton.setPivotX(1);
	     healthButton.setScaleX(Float.parseFloat(healthSubtract));
	     
	     //put an x if player is dead
	     if(Float.parseFloat(healthSubtract)==0){
	    	playImage.setText(" X");
	     }
	   
	      return v;
	     
	   }
	
}
