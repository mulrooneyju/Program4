
public class Fork 
{
   private boolean beingHeld;
   private static int numForks = 0;
   
   public Fork()
   {
      numForks++;
      beingHeld = false;
   }
   
   public boolean isHeld()
   {
      return beingHeld;
   }

   public void setDown()
   {
      beingHeld = false;
   }
   
   public void pickUp()
   {
      beingHeld = true;
   }
}
