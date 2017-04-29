//
//Names: Garrett Luskey and Justin Mulrooney
//
//Program 4
//CAOS



//This is the fork class. It represents the fork
public class Fork 
{
   private boolean beingHeld;
   //This is the default constructor
   public Fork()
   {
      beingHeld = false;
   }
   //Tells if the fork is being held
   public boolean isHeld()
   {
      return beingHeld;
   }
   //Tells the fork to be set down
   public void setDown()
   {
      beingHeld = false;
   }
   //Tells the fork to be set down
   public void pickUp()
   {
      beingHeld = true;
   }
}
