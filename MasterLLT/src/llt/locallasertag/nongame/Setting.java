package llt.locallasertag.nongame;

import llt.locallasertag.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.NumberPicker;

public class Setting extends Activity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.app_settings);

      //getActionBar().setDisplayHomeAsUpEnabled(true);
      NumberPicker NP = (NumberPicker) findViewById(R.id.numberPicker1);
      NP.setMaxValue(35);
      NP.setMinValue(1);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      // TODO Auto-generated method stub
      if (item.getItemId() == android.R.id.home) {
         finish();
      }
      return super.onOptionsItemSelected(item);
   }
}
