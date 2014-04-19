package llc.locallasertag;

import java.io.FileOutputStream;

import android.content.Context;

/*
 * Player Class
 * 
 * Used to create a player, which holds attributes for individual players such as long term stats
 * avatar, current score, user name, player id, IGN, and so forth
 */



public class player {

	int avatarNum = 1; // for avatar integers 1-35 correspond to a preloaded image, integer 0 corresponds the user had uploaded his/her own image
	
	private String IGN;
	private String id; //used to identify player server side
	private int health = 0; //is reset to 100 when game begins
	private int wins, loses; //total wins and loses of the player
	String FILENAME = "player_data";
	int NUMBER_OF_AVATARS = 35;

	
	
	public player(){ //default player
		
		//id = random string
		IGN = "NEWBIE";
		avatar = (int)(Math.random() * (NUMBER_OF_AVATARS - 1)) + 1; //randomizes player an avatar from the preloaded ones
		wins = 0;
		loses = 0;
		savePlayerData();
	}
	
	public player(String IGN){ //parameters should be IGN, icon, id
		//used to create a player from EDIT menu
		
		//if ()
		
		savePlayerData();
	}
	
	private boolean loadPlayer(){
		//loads player information from file if stored previously 
		//returns true if data was loaded from file into local variables
		return true;
	}
	
	public boolean savePlayerData(){
		//returns true if save was successful
		
		FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
		
		//http://developer.android.com/guide/topics/data/data-storage.html#filesInternal
		
		String str = "" + id + " " + IGN + " " + wins + " " + loses;
		
		fos.write(str.getBytes());
		fos.close();
		
		return true;
	}

	public boolean setHealth(int h){
		//returns true if setHealth worked
		if (h > 100 || h < 0) //health to set must be 0<h<100
			return false;
		
		health = h;
		
		return true;
	}
	
	public void loseHealth(int toLose){
		if (toLose > 0) //health to lose must be positive
			health -= toLose;
		
		if (health < 0){
			health = 0;
			//call death function?
		}
	}
	
	private boolean avatarExists(){
		//returns true if avatar file exists in file system
		
		if (avatar >= 1 && avatar <= NUMBER_OF_AVATARS) // 
			return true;
		else{
			//return true if uploaded avatar file exists
		}
		
		return true;
	}
	
	private boolean usingPreLoadedAvatar(){ //returns true if player is using preloaded avatar
		return !(avatar == 0);
	}
	
	public image/drawable getAvatar(){
		if (usingPreLoadedAvatar()){
			return 
		}
			
	
	}
	
}

