package llc.locallasertag;

import java.util.LinkedList;
import java.util.List;

import llc.locallasertag.util.JSONfunctions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button startButton, how;
	private JSONObject jObject;
	private String name;
	private Activity mainActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startButton = (Button) findViewById(R.id.startButton);
		how = (Button) findViewById(R.id.butHow);

		how.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, HowToPlay.class));
			}
		});
		startButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, GamePage.class));
			}
		});
		mainActivity=this;

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		name = getUsername();
		Log.d("NAME", name);
		// Player myplayer = new Player(name);
		new LongOperation().execute("");

	}

	// TALK TO SERVER START
	private class LongOperation extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {

			String temp;

			temp = "http://www.jonquybao.com/LLT/feedurls/v_login.php?username="
					+ name;
			// +Integer.parseInt((playerHealth.get(0)*100)+"")
			Log.d("LOOK", temp);
			jObject = JSONfunctions.getJSONfromURL(temp);
			return "Executed";
		}

		@Override
		protected void onPostExecute(String result) {

			Log.d("JSON", jObject.toString());
			try {

				JSONArray jArray;

				jArray = jObject.getJSONArray("player");

				for (int i = 0; i < jArray.length(); i++) {
					JSONObject object = jArray.getJSONObject(i);


					if (object.has("pid")) {
						SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(mainActivity);
						Editor edit = settings.edit();
						edit.putInt("pid", Integer.parseInt(object.getString("pid")));
						edit.putString("team", object.getString("team"));
						edit.apply(); 


					}
				
					//Log.d("PID", Integer.parseInt(object.getString("team"))+"");
				
				
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		// TODO getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		// TODO if (id == R.id.action_settings) {
		// TODO return true;
		// TODO }
		return super.onOptionsItemSelected(item);
	}

	public void gameStart(View v) {
		Intent intent = new Intent(this, TimerActivity.class);
		startActivity(intent);
	}

	public void gameSettings(View v) {
		Intent intent = new Intent(this, App_Settings.class);
		startActivity(intent);
	}
}
