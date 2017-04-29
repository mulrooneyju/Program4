
import java.util.Random;

public class Philosopher extends Thread 
{ 
   // each Philosopher is assigned an integer ID and two forks 
   private int ID = 0;
   public enum States{THINKING, EATING,WAIT_LEFT_FORK, WAIT_RIGHT_FORK};



   Philosopher()
   {
      
   }

   public void curState(States curState)
   {
      switch(curState)
      {
         case THINKING:
            break;
         case EATING:
            break;
         case WAIT_LEFT_FORK:
            break;
         default://default WAIT_RIGHT_FORK
            break;
      }
   }
   

   public void run()  
   { 
      boolean timeToGO = false;
   while (!timeToGO) 
   { 
   System.out.println (ID + "THINKING"); 
        // TODO: think for random number of milliseconds <=1 sec 
        Random rn = new Random();
        try{
         Thread.sleep(rn.nextInt() % 1000);
        } catch(InterruptedException e) {}

        // TODO: obtain the fork on the left 
        // TODO: obtain the fork on the right 
        System.out.println (ID + "EATING"); 
        // TODO: eat for random number of milliseconds <= 1sec 
        try{
            Thread.sleep(rn.nextInt() % 1000);
        } catch(InterruptedException e) {}
        // TODO: release the fork on the left  
        // TODO: release the fork on the right
        timeToGO = !timeToGO;
   } 

   System.out.println(ID+ "DONE");
   } 

   public static void main(String[] args)
   {
      
   }
}