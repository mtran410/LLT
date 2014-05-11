package llt.locallasertag.game;

import llt.locallasertag.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;


public class CreateGame extends Activity {
	private Spinner gameType, numPlayer;
	private Integer numberPlayer;
	private String gameChoice, gameName;
	public void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.creategame);
		  gameType = (Spinner)findViewById(R.id.chooseGame);
		  numPlayer = (Spinner)findViewById(R.id.spinNumberPlayer);
		  
		  gameChoice = gameType.getSelectedItem().toString();
		  
		
		
			  gameType.setVisibility(View.VISIBLE);
			  numberPlayer = Integer.parseInt(numPlayer.getSelectedItem().toString());
		
			  if(gameChoice == "Free For All")
				  numberPlayer = 1;
		 
		 
	}

}
