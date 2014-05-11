package llc.locallasertag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

   //private static MyPlayer user;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      //user = new MyPlayer();
      //user.loadPlayer(); //loads the users data into the shared MyPlayer user variable for access throught app

      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {

      // Inflate the menu; this adds items to the action bar if it is present.
      //TODO getMenuInflater().inflate(R.menu.main, menu);
      return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      // Handle action bar item clicks here. The action bar will
      // automatically handle clicks on the Home/Up button, so long
      // as you specify a parent activity in AndroidManifest.xml.
      int id = item.getItemId();
      //TODO if (id == R.id.action_settings) {
      //TODO   return true;
      //TODO }
      return super.onOptionsItemSelected(item);
   }

   public void gameStart(View v) {
      Intent intent = new Intent(this, Lobby.class);
      startActivity(intent);
   }

   public void gameSettings(View v) {
      Intent intent = new Intent(this, App_Settings.class);
      startActivity(intent);
   }
}
