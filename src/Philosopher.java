
import java.util.Random;

public class Philosopher extends Thread 
{ 
   // each Philosopher is assigned an integer ID and two forks 
   private int ID = 0;
   private static int IDCounter = 0;
   public enum States{THINKING, EATING,WAIT_LEFT_FORK, WAIT_RIGHT_FORK};
   private static int numberOfPhilosophers = 5;
   private static Fork[] forks = new Fork[numberOfPhilosophers];
   private int thinking = 0;
   private int eating = 0;
   

   Philosopher()
   {
       System.out.println ("Created");
      forks[ID] = new Fork();
      ID = IDCounter++;
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
            int wait = rn.nextInt() % 1000;
            thinking += wait;
            Thread.sleep(wait);
        } catch(InterruptedException e) {}
        
        if(forks[ID].isHeld() == false){
            forks[ID].pickUp();
            if (ID == numberOfPhilosophers){
                if (forks[0].isHeld() == false) {
                    forks[0].pickUp();            
                }
                else { forks[ID].setDown(); }
            }
            else if( forks[ID + 1].isHeld() == false) {
                forks[ID + 1].pickUp();
            }
            else { forks[ID].setDown(); }
        }

        System.out.println (ID + "EATING"); 
        // TODO: eat for random number of milliseconds <= 1sec 
        try{
            int wait = rn.nextInt() % 1000;
            eating += wait;
            Thread.sleep(wait);
        } catch(InterruptedException e) {}
        // TODO: release the fork on the left  
        forks[ID].setDown();
        // TODO: release the fork on the right
        if(ID == numberOfPhilosophers){
            forks[0].setDown();
        } else { forks[ID + 1].setDown();}
        if(thinking >= 1000){
            timeToGO = !timeToGO;
        }
   } 

   System.out.println(ID+ "DONE");
   } 

   public static void main(String[] args)
   {
       System.out.println ("THINKING");
       Thread[] philosophers = new Thread[numberOfPhilosophers];
       System.out.println ("THINKING");
       for (int i = 0; i < numberOfPhilosophers; i++){
           System.out.println ("start");
           philosophers[i] = new Thread(new Philosopher());
           philosophers[i].start();
       }
   }
}