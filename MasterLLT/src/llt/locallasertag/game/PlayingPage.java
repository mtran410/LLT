package llt.locallasertag.game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import llt.locallasertag.R;
import llt.locallasertag.background.DownloadInfo;
import llt.locallasertag.background.DownloadInfoArrayAdapter;
import llt.locallasertag.background.Player;
import llt.locallasertag.util.JSONfunctions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PlayingPage extends Activity {

	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Player> AllPlayers = new ArrayList<Player>();
	private JSONObject jObject;
	Timer timer;
	MyTimerTask myTimerTask;
	boolean firstTime = true;
	DownloadInfo currentInfo;
	List<DownloadInfo> downloadInfo;
	List<DownloadInfo> downloadInfo2;
	DownloadInfoArrayAdapter firstArrayAdapter;
	DownloadInfoArrayAdapter secondArrayAdapter;
	Uri notification;
	Ringtone r;
	float lightAmount = 300f;
	Double subHealth = 1.0;
	Player myplayer;
	int player_id;
	String player_team;
	int red_score=0, blue_score=0;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playingpage);

		SensorManager mySensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		Sensor LightSensor = mySensorManager
				.getDefaultSensor(Sensor.TYPE_LIGHT);
		if (LightSensor != null) {
			mySensorManager.registerListener(LightSensorListener, LightSensor,
					SensorManager.SENSOR_DELAY_NORMAL);
		}
		try {
			notification = RingtoneManager
					.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
			r = RingtoneManager.getRingtone(getApplicationContext(),
					notification);
		} catch (Exception e) {
			e.printStackTrace();
		}
		myplayer = new Player();

		currentInfo = new DownloadInfo("ME", 100);
		ListView listView = (ListView) findViewById(R.id.downloadListView);

		downloadInfo = new ArrayList<DownloadInfo>();
		downloadInfo.add(currentInfo);
		
		SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
		player_id = (int)settings.getInt("pid", 0); 
		player_team =settings.getString("team", "n/a"); 
		
		if(player_team.equals("RED")){
			RelativeLayout rl = (RelativeLayout) findViewById(R.id.teamPlayer);
			rl.setBackgroundColor(Color.parseColor("#800000"));
			TextView top = (TextView) findViewById(R.id.Player);
			top.setBackgroundColor(Color.parseColor("#800000"));
			TextView middle = (TextView) findViewById(R.id.Team);
			middle.setBackgroundColor(Color.parseColor("#800000"));
			TextView bottom = (TextView) findViewById(R.id.Score);
			bottom.setBackgroundColor(Color.parseColor("#800000"));
		}
		/*
		 * 
		 * for(int i = 0; i < 1; ++i) { downloadInfo.add(currentInfo); }
		 */

		firstArrayAdapter = new DownloadInfoArrayAdapter(
				getApplicationContext(), R.id.downloadListView, downloadInfo);
		listView.setAdapter(firstArrayAdapter);

		ListView listView2 = (ListView) findViewById(R.id.downloadListView2);

		downloadInfo2 = new ArrayList<DownloadInfo>();
		/*
		 * for(int i = 0; i < 4; ++i) { downloadInfo2.add(new
		 * DownloadInfo("File " + i, 100)); }
		 */

		secondArrayAdapter = new DownloadInfoArrayAdapter(
				getApplicationContext(), R.id.downloadListView, downloadInfo2);
		listView2.setAdapter(secondArrayAdapter);

		timer = new Timer();
		myTimerTask = new MyTimerTask();

		timer.schedule(myTimerTask, 0, 100);
	}

	private class MyTimerTask extends TimerTask {

		@Override
		public void run() {

			runOnUiThread(new Runnable() {

				@Override
				public void run() {
					
				

					new LongOperation().execute("");
				}
			});
		}

	}

	// TALK TO SERVER START
	private class LongOperation extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			String temp;
			//temp = "http://www.jonquybao.com/LLT/feedurls/all_players.php?pid=1&health=100";

			if (firstTime) {
				temp = "http://www.jonquybao.com/LLT/feedurls/all_players.php?pid="+player_id+"&health=100";
				
			} else
				temp = "http://www.jonquybao.com/LLT/feedurls/all_players.php?pid="+player_id+"&health="+ myplayer.getHealth();
			// +Integer.parseInt((playerHealth.get(0)*100)+"")

		//	Log.d("LOOK", temp);
			jObject = JSONfunctions.getJSONfromURL(temp);

			return "Executed";
		}

		@Override
		protected void onPostExecute(String result) {

		//	Log.d("JSON", jObject.toString());
			try {
			//	Log.d("JSON", jObject.toString());
				JSONArray jArray;

				jArray = jObject.getJSONArray("players");

				for (int i = 0; i < jArray.length(); i++) {
					JSONObject object = jArray.getJSONObject(i);
					Player p = new Player();

					if (object.has("pid")) {
						p.setID(Integer.parseInt(object.getString("pid")));

					}

					if (object.has("display_name")) {
						p.setIGN(object.getString("display_name"));

					}
					if (object.has("health")) {
						p.setHealth(Double.parseDouble(object
								.getString("health")));

					}
					if (object.has("team")) {
						p.setTeam(object
								.getString("team"));

					}

					if (firstTime) {
						AllPlayers.add(p);
						
						if (object.getString("username").equals(getUsername())) {
							Log.d("EPIC", object.getString("username"));
							myplayer.setID(p.getId());
							myplayer.setIGN(p.getIGN());

						} else {
							if( player_team.equals(object.getString("team")))
							players.add(p);
						}
						
					} else {
						AllPlayers.get(i).setHealth(p.getHealth());
						if (!object.getString("username").equals(getUsername()) && i < players.size() ) {
							players.get(getIndexofPID(p.getId())).setHealth(p.getHealth());
						}
					}

				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if(firstTime){
				Log.d("NAME", "NAME");
				downloadInfo.get(0).setFilename(myplayer.getIGN());
				firstArrayAdapter.notifyDataSetChanged();
			}
			


		
			if(firstTime){
				//("FIRST TIME", "FIRSTTIME");
				for (int i = 0; i < players.size(); i++) {
					DownloadInfo currentInfo = new DownloadInfo(players.get(i)
							.getIGN(), 100);
					currentInfo.setProgress((int) players.get(i).getHealth());
					downloadInfo2.add(currentInfo);
				}
				secondArrayAdapter.notifyDataSetChanged();
			}else{


				//Log.d("NOT", players.size()+"");
				for (int i = 0; i < players.size(); i++) {
					downloadInfo2.get(i).setProgress((int)players.get(i).getHealth());
					
					secondArrayAdapter.notifyDataSetChanged();
					
				}
			}
			firstTime = false;
			updateScore();
			

		}
		private void updateScore(){
			red_score=0;
			blue_score=0;
			for (int i = 0; i < AllPlayers.size(); i++) {
				Log.d("HEALTH", ((int)AllPlayers.get(i).getHealth())+"");
			
				if( AllPlayers.get(i).getTeam().equals("RED") && ((int)AllPlayers.get(i).getHealth())==0 ){
					blue_score=blue_score+1;
				}else if(AllPlayers.get(i).getTeam().equals("BLUE") && ((int)AllPlayers.get(i).getHealth())==0){
					red_score= red_score+1;
				}
			}
			Log.d("------", "---");
			TextView red = (TextView) findViewById(R.id.redscore);
			red.setText(red_score+"");
			TextView blue = (TextView) findViewById(R.id.bluescore);
			blue.setText(blue_score+"");
			
		}
		private int getIndexofPID(int pid){
			int val=0;
				for(int i =0; i<players.size(); i++){
					if(players.get(i).getId()==pid){
						val =i;
					}
				}
			
			return val;
		}
		
		@Override
		protected void onPreExecute() {
		}

		@Override
		protected void onProgressUpdate(Void... values) {
		}
	}

	// TALK TO SERVER END

	public String getUsername() {
		AccountManager manager = AccountManager.get(this);
		Account[] accounts = manager.getAccountsByType("com.google");
		List<String> possibleEmails = new LinkedList<String>();

		for (Account account : accounts) {
			// TODO: Check possibleEmail against an email regex or treat
			// account.name as an email address only for certain account.type
			// values.
			possibleEmails.add(account.name);
		}

		if (!possibleEmails.isEmpty() && possibleEmails.get(0) != null) {
			String email = possibleEmails.get(0);
			String[] parts = email.split("@");
			if (parts.length > 0 && parts[0] != null)
				return parts[0];
			else
				return null;
		} else
			return null;
	}

	// light sensor listener
	private final SensorEventListener LightSensorListener = new SensorEventListener() {

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub

		}

		@SuppressWarnings("deprecation")
		@Override
		public void onSensorChanged(SensorEvent event) {
			if (event.sensor.getType() == Sensor.TYPE_LIGHT) {

				if (event.values[0] > lightAmount && myplayer.getHealth()>0) {
					
					myplayer.setHealth(myplayer.getHealth() - subHealth);

					downloadInfo.get(0).setProgress((int) myplayer.getHealth());

					firstArrayAdapter.notifyDataSetChanged();

				}

			}

		}

	};

}
