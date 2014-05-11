package llc.locallasertag;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GamePage extends Activity{
	private Button conGame1, conGame2, conGame3, conGame4;
	private int numGame, numplayerGame1, numplayerGame2, numplayerGame3, numplayerGame4;
	private int totalPlayerGame1, totalPlayerGame2, totalPlayerGame3, totalPlayerGame4;
	private String game1Name, game2Name, game3Name, game4Name;
	
	public void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.gamepage);
		  conGame1 =(Button)findViewById(R.id.game1);
		  conGame2 =(Button)findViewById(R.id.game2);
		  conGame3 =(Button)findViewById(R.id.game3);
		  conGame4 =(Button)findViewById(R.id.game4);
		  
		  
	}

	public void addGame(String name, Button game, int numPlayer, int total){
		game.setVisibility(View.VISIBLE);
		game.setText(name + "  " + numPlayer + "/" + total);
	}
	
	public void addPlayer(String name, Button game, int numPlayer, int total){
		game.setText(name + "  " + numPlayer + "/" + total);
	}
}
