package com.example.something;



import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerFragment extends Fragment {
	TextView Msg, name;
	
	
	//ImageView pic;
	//ImageView actImag;
	   public View onCreateView(LayoutInflater inflater,
	      ViewGroup container, Bundle savedInstanceState) {
	      /**
	       * Inflate the layout for this fragment
	       */
	     View v= inflater.inflate(R.layout.playerfragment, container, false);
	     
	     //code to change the player name
	     name = (TextView)v.findViewById(R.id.txtPlayerName);
	     Msg = (TextView)getActivity().findViewById(R.id.msg);
	     String MSG = Msg.getText().toString();
	     name.setText(MSG);
	     
	     //code to change the death count from activity
	     TextView  numDeath, msgDeath;
	     numDeath = (TextView)v.findViewById(R.id.death);
	     msgDeath = (TextView)getActivity().findViewById(R.id.d1);
	     String MSG2 = msgDeath.getText().toString();
	     numDeath.setText(MSG2);
	   
	     //code to change the image from activity
	     TextView playImage, msgImage;
	     playImage = (TextView)v.findViewById(R.id.avatar);
	     msgImage = (TextView)getActivity().findViewById(R.id.p1Image);
	     playImage.setBackground(msgImage.getBackground());
	     
	     //code to change health bar
	     Button healthButton;
	     TextView healthCount;
	    
	     healthButton = (Button)v.findViewById(R.id.healthBar);
	     healthCount = (TextView)getActivity().findViewById(R.id.h1);
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
