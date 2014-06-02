package llt.locallasertag.nongame;

import llt.locallasertag.R;
import llt.locallasertag.game.MainActivity;
import llt.locallasertag.game.Room;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class RedWins extends Activity {

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.r_win);
      
		Handler handler = new Handler();
		Runnable delayRunnable = new Runnable() {

		     @Override
		     public void run() {
		     //TODO Auto-generated method stub  

					Intent intent = new Intent(getBaseContext(), MainActivity.class);
					startActivity(intent);
		    }
		};      
		handler.postDelayed(delayRunnable, 3000);
   }
}
