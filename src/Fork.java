
public class Fork 
{
   private boolean beingHeld;
   public Fork()
   {
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
