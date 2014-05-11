package llc.locallasertag;

public class Team {

   Player[] players;
   int MAX_TEAM_SIZE = 8;
   String color;

   public Team(String c) {
      color = c;
      players = new Player[MAX_TEAM_SIZE];
   }

   public String getColor() {
      return color;
   }

   public boolean addPlayer(Player p) { //adds a player to players array
      //returns true if addplayer is successful
      if (isFull())
         return false;

      for (int i = 0; i <= MAX_TEAM_SIZE - 1; i++) {
         if (players[i] == null) {
            players[i] = p;
            break;
         }
      }

      return true;
   }

   public Player getPlayer(int i) { //gets a player by index
      return players[i];
   }

   public boolean isFull() {
      if (players[MAX_TEAM_SIZE - 1] == null)
         return false;

      return true;
   }

   public boolean removePlayer(Player p) { //removes a player from the team 

      int index = findIndex(p);

      if (index == -1)
         return false;

      return removePlayer(index);
   }

   private int findIndex(Player p) { //finds the index of a player on the team
      for (int i = 0; i <= MAX_TEAM_SIZE - 1; i++) {
         if (players[i].getId().equalsIgnoreCase(p.getId())) {
            return i;
         }
      }

      return -1;
   }

   public boolean removePlayer(int index) { //removes a player on the team by index
      for (int i = index; i <= MAX_TEAM_SIZE - 2; i++) {
         players[i] = players[i + 1];
      }

      players[7] = null;
      return true;
   }

   public int maxTeamSize() { //returns the maximum team size
      return MAX_TEAM_SIZE;
   }

}
