package llc.locallasertag;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;

/*
 * Player Class
 * 
 * Used to create a player, which holds attributes for individual players such as long term stats
 * avatar, current score, user name, player id, IGN, and so forth
 */

public class player extends Activity {

   int avatarNum = 1; // for avatar integers 1-35 correspond to a preloaded image, integer 0 corresponds the user had uploaded his/her own image
   //Image avatar = new IconImage();
   private String IGN;
   private String id; //used to identify player server side
   private int health = 100; //is reset to 100 when game begins
   private int wins, loses; //total wins and loses of the player
   String FILENAME = "player_data";
   int NUMBER_OF_AVATARS = 35;
   int MILLI_FOR_DAMAGE = 250; //number of milliseconds needed of light above MINIMUM_LIGHT to decrease health by 1% 
   int MINIMUM_LIGHT = 400; //amount of light needed to register a hit

   public player() { //default player

      //id = random string
      IGN = "NEWBIE";
      avatarNum = (int) (Math.random() * (NUMBER_OF_AVATARS - 1)) + 1; //randomizes player an avatar from the preloaded ones
      wins = 0;
      loses = 0;
      savePlayerData();
   }

   public player(String IGN, int avatarNum) { //parameters should be IGN, icon, id?
      this.avatarNum = avatarNum;
      this.IGN = IGN;
      //used to create a player from EDIT menu

      //if ()

      savePlayerData();
   }

   private boolean loadPlayer() {
      //loads player information from file if stored previously 
      //returns true if data was loaded from file into local variables
      return true;
   }

   public boolean savePlayerData() {
      //returns true if save was successful

      FileOutputStream fos;
      String str = "" + id + " " + IGN + " " + wins + " " + loses;
      try {
         fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
         fos.write(str.getBytes());
         fos.close();
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      //http://developer.android.com/guide/topics/data/data-storage.html#filesInternal

      return true;
   }

   public boolean setHealth(int h) {
      //returns true if setHealth worked
      if (h > 100 || h < 0) //health to set must be 0<h<100
         return false;

      health = h;

      return true;
   }

   public void loseHealth(int toLose) {
      if (toLose > 0) //health to lose must be positive
         health -= toLose;

      if (health < 0) {
         health = 0;
         //call death function?
      }
   }

   private boolean avatarExists() {
      //returns true if avatar file exists in file system

      if (avatarNum >= 1 && avatarNum <= NUMBER_OF_AVATARS) // 
         return true;
      else {
         //return true if uploaded avatar file exists
      }

      return true;
   }

   private boolean usingPreLoadedAvatar() { //returns true if player is using preloaded avatar
      return !(avatarNum == 0);
   }

   /*
   public image/drawable getAvatar(){
   	if (usingPreLoadedAvatar()){ //returns preploaded image
   		return 
   	} else //returns user uplaoded image
   	 return 
   		
   }
   */

   public boolean status() {
      return health > 0;
   }

   public String getId() {
      return id;
   }

   public int getHealth() {
      return health;
   }

   public int getWins() {
      return wins;
   }

   public int getLoses() {
      return loses;
   }

   public String getWinsOverTotal() {
      int total = wins + loses;
      return wins + "/" + total;
   }

   public int getWinPercentage() {
      return (int) ((double) wins / (wins + loses)) * 100;
   }
}
