package llt.locallasertag.game;

import llt.locallasertag.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class BulletAnimation extends Activity {
	
	private ImageView bulletScreen;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bulletanimation);
		
		bulletScreen = (ImageView)findViewById(R.id.imageView1);
		bulletScreen.setBackgroundResource(R.drawable.animation);
		AnimationDrawable bulletAnimation =(AnimationDrawable) bulletScreen.getBackground();
		bulletScreen.setAlpha(1f);
		bulletAnimation.start();
		//bulletAnimation.stop();
		 //startActivity(new Intent(TimerActivity.this, PlayingPage.class));//go to next page when 10 second left
	}
}
