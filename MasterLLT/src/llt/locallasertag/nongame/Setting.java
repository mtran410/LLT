package llt.locallasertag.nongame;

import llt.locallasertag.R;
import llt.locallasertag.game.MainActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.NumberPicker;

public class Setting extends Activity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.app_settings);

      //getActionBar().setDisplayHomeAsUpEnabled(true);
      GridView gView = (GridView) findViewById(R.id.avatar);
      
      gView.setAdapter(new ImageAdapter(this));            
 }             
 public class ImageAdapter extends BaseAdapter{
      private Context mContext;
      public int getCount() {
           return mThumbIds.length;
      }                               
      public Object getItem(int position) {
           return mThumbIds[position];
      }                               
      public long getItemId(int position) {
           return 0;
      }                               
      public ImageAdapter(Context c) {
           mContext = c;
      }                         
                            
      public View getView(int position, View convertView, ViewGroup parent) {
           ImageView imageView;
           if (convertView == null){  
              imageView = new ImageView(mContext);
              imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
              imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
              imageView.setPadding(8, 8, 8, 8);
           } 
           else{
               imageView = (ImageView) convertView;
           }
           imageView.setImageResource(mThumbIds[position]);
           return imageView;
      }
                           
      private Integer[] mThumbIds = {
      	    R.drawable.a1, R.drawable.a2, R.drawable.a3,
      	    R.drawable.a4, R.drawable.a5, R.drawable.a6,
      	    R.drawable.a7, R.drawable.a8, R.drawable.a9,
      	    R.drawable.a10, R.drawable.a11, R.drawable.a12,
      	    R.drawable.a13, R.drawable.a14, R.drawable.a15,
      	    R.drawable.a16, R.drawable.a17, R.drawable.a18,
      	    R.drawable.a19, R.drawable.a20, R.drawable.a21,
      	    R.drawable.a22, R.drawable.a23,R.drawable.a24,
      	    R.drawable.a25, R.drawable.a26, R.drawable.a27,
      	    R.drawable.a28, R.drawable.a29, R.drawable.a29,
      	    R.drawable.a30, R.drawable.a31, R.drawable.a32,
      	    R.drawable.a33, R.drawable.a34, R.drawable.a35
       };
      
  }
 	public void settingReturn (View v)
 	{
      Intent intent = new Intent(this, MainActivity.class);
      startActivity(intent);
 	}
 
}
