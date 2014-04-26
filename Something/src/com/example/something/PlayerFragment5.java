package com.example.something;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerFragment5 extends Fragment {
	TextView Msg;
	TextView name;
	//ImageView pic;
	//ImageView actImag;
	   public View onCreateView(LayoutInflater inflater,
	      ViewGroup container, Bundle savedInstanceState) {
	      /**
	       * Inflate the layout for this fragment
	       */
	      View v= inflater.inflate(R.layout.playerfragment5, container, false);
	      name = (TextView)v.findViewById(R.id.txtPlayerName5);
	     Msg = (TextView)getActivity().findViewById(R.id.msg5);
	     String MSG = Msg.getText().toString();
	     name.setText(MSG);
	     
	     TextView  numDeath, msgDeath;
	     numDeath = (TextView)v.findViewById(R.id.death5);
	     msgDeath = (TextView)getActivity().findViewById(R.id.d5);
	     String MSG2 = msgDeath.getText().toString();
	     numDeath.setText(MSG2);
	     
	     //code to change the image from activity
	     TextView playImage, msgImage;
	     playImage = (TextView)v.findViewById(R.id.avatar5);
	     msgImage = (TextView)getActivity().findViewById(R.id.p5Image);
	     playImage.setBackground(msgImage.getBackground());
	     
	     //code to change health bar
	     Button healthButton;
	     TextView healthCount;
	     healthButton = (Button)v.findViewById(R.id.healthBar5);
	     healthCount = (TextView)getActivity().findViewById(R.id.h5);
	     String healthSubtract =healthCount.getText().toString();
	     healthButton.setPivotX(1);
	     healthButton.setScaleX(Float.parseFloat(healthSubtract));
	     
	     //put an x if player is dead
	     if(Float.parseFloat(healthSubtract)==0){
	    	playImage.setText(" X");
	     }
	     
	      return v;
	     
	   }
	public void setName(String playerName){
		name.setText(playerName);
	}

}
