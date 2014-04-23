package llc.locallasertag;

public class game {
   int type = 0; //type 0 = tdm, 1 = ffa
   boolean started = false;
   int lengthInSec = 600; // game ends if time runs out

   public game() {
      lengthInSec = 600;
      type = 0;
   }

   public game(int t, int minutes) {
      type = t;
      lengthInSec = minutes * 60;
   }

   public void setType(int n) {
      type = n;
   }

   public String type() {
      switch (type) {
         case 0:
            return "Team Death Match";
         case 1:
            return "Free For All";
      }

      return "ERROR";
   }

   public void start() {
      //send signal to other phones and server that match has begun

      started = true;
   }

   public void endGame() {
      //goes to match setup area for all players
      //send signal to other phones and server that match has begun

   }

   public boolean started() {
      return started;
   }

}
