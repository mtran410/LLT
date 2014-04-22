package com.example.something;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PlayerPage extends FragmentActivity {
	private int numberPlayer=4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playerpage);
		
		if(numberPlayer>=1){
			FragmentManager fM = getFragmentManager();
			FragmentTransaction fT = fM.beginTransaction();
			PlayerFragment newFrag = new PlayerFragment();
			fT.add(R.id.myLay1, newFrag);
			fT.commit();
		}
		if(numberPlayer>=2){	
			FragmentManager fM2 = getFragmentManager();
			FragmentTransaction fT2 = fM2.beginTransaction();
			PlayerFragment newFrag2 = new PlayerFragment();
			fT2.add(R.id.myLay2, newFrag2);
			fT2.commit();
		}
		if(numberPlayer>=3){	
			FragmentManager fM3 = getFragmentManager();
			FragmentTransaction fT3 = fM3.beginTransaction();
			PlayerFragment newFrag3 = new PlayerFragment();
			fT3.add(R.id.myLay3, newFrag3);
			fT3.commit();
		}
		if(numberPlayer>=4){	
			FragmentManager fM4 = getFragmentManager();
			FragmentTransaction fT4 = fM4.beginTransaction();
			PlayerFragment newFrag4 = new PlayerFragment();
			fT4.add(R.id.myLay4, newFrag4);
			fT4.commit();
		}
		if(numberPlayer>=5){	
			FragmentManager fM5 = getFragmentManager();
			FragmentTransaction fT5 = fM5.beginTransaction();
			PlayerFragment newFrag5 = new PlayerFragment();
			fT5.add(R.id.myLay5, newFrag5);
			fT5.commit();
		}
		if(numberPlayer>=6){	
			FragmentManager fM6 = getFragmentManager();
			FragmentTransaction fT6 = fM6.beginTransaction();
			PlayerFragment newFrag6 = new PlayerFragment();
			fT6.add(R.id.myLay6, newFrag6);
			fT6.commit();
		}
		
		
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.timer, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.playerpage, container,
					false);
			return rootView;
		}
	}

}
