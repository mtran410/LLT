package llc.locallasertag;

import android.app.Activity;

/*
 * Player Class
 * 
 * Used to create a player, which holds attributes for individual players such as long term stats
 * avatar, current score, user name, player id, IGN, and so forth
 */

public class Player extends Activity {// implements ActionListener{

   int avatarNum = 1; // for avatar integers 1-35 correspond to a preloaded image, integer 0 corresponds the user had uploaded his/her own image
   //Image avatar = new IconImage();
   private String IGN;
   private String id; //used to identify player server side
   private int health = 100; //is reset to 100 when game begins
   private int wins, loses; //total wins and loses of the player
   int NUMBER_OF_AVATARS = 35;

   public Player() { // creates player from saved file OR a default player if file not found

      //cannot create player in default constructor 
   }

   public Player(String id, String IGN, int avatarNum, int health) { // a player, created for each person in lobby when MyPlayer joins a lobby or game
      this.health = health;
      this.avatarNum = avatarNum;
      this.IGN = IGN;
      //used to create a player from EDIT menu

      //if ()

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
         // TODO return true if uploaded avatar file exists
      }

      return true;
   }

   private boolean usingPreLoadedAvatar() { //returns true if player is using preloaded avatar
      return !(avatarNum == 0);
   }

   /* TODO
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

   public String getIGN() {
      return IGN;
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
