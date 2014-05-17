package llt.locallasertag.game;

import llt.locallasertag.R;
import llt.locallasertag.nongame.HowToPlay;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class Room extends Activity {

	ListView blueTeam;
	ListView redTeam;
	
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.room);
      
      blueTeam = (ListView) findViewById(R.id.blueTeam);
      redTeam = (ListView) findViewById(R.id.redTeam);
      // TODO link players to the list for red and blue team
   }
   
   public void StartGame(View v)
   {
      Intent intent = new Intent(this, TimerActivity.class);
      startActivity(intent);
   }
}
