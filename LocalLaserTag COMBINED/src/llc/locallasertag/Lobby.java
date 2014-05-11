package llc.locallasertag;

import java.util.ArrayList;
import java.util.List;

import llc.locallasertag.util.JSONfunctions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Lobby extends Activity {

	private ListView lv;
	private JSONObject jObject;
	ArrayAdapter<String> arrayAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lobby);

		lv = (ListView) findViewById(R.id.gameList);

		// Instanciating an array list (you don't need to do this,
		// you already have yours).
		List<String> your_array_list = new ArrayList<String>();


		// This is the array adapter, it takes the context of the activity as a
		// first parameter, the type of list view as a second parameter and your
		// array as a third parameter.
		arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				your_array_list);

		new LongOperation().execute("");

		lv.setAdapter(arrayAdapter);

		// getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == android.R.id.home) {
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

	public void joinGame(View v) {
		Intent intent = new Intent(this, TimerActivity.class);
		startActivity(intent);
	}

	private class LongOperation extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			jObject = JSONfunctions
					.getJSONfromURL("http://www.jonquybao.com/LLT/feedurls/view_games.php");
			return "Executed";
		}

		@Override
		protected void onPostExecute(String result) {
			try {
				Log.d("JSON", jObject.toString());
				JSONArray jArray;

				jArray = jObject.getJSONArray("games");

				for (int i = 0; i < jArray.length(); i++) {
					JSONObject object = jArray.getJSONObject(i);
					if (object.has("name")) {
						arrayAdapter.add(object.getString("name"));

					}

				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			arrayAdapter.notifyDataSetChanged();
			    System.out.println("onpostexecute");
		}

		@Override
		protected void onPreExecute() {
		}

		@Override
		protected void onProgressUpdate(Void... values) {
		}
	}

}
