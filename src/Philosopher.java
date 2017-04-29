
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
        ID = IDCounter++;
    boolean timeToGO = false;
    while (!timeToGO) 
    { 
        System.out.println (ID + "THINKING"); 
        // TODO: think for random number of milliseconds <=1 sec 
        Random rand = new Random();
        try{
            int wait = rand.nextInt(999) + 1;
            thinking += wait;
            Thread.sleep(wait);
        } catch(InterruptedException e) {}
        
        if(forks[ID].isHeld() == false){
            forks[ID].pickUp();
            if (ID == numberOfPhilosophers - 1){
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

        
        // TODO: eat for random number of milliseconds <= 1sec 
        try{
            int wait = rand.nextInt(999) + 1;
            eating += wait;
            Thread.sleep(wait);
        } catch(InterruptedException e) {}
        // TODO: release the fork on the left  
        forks[ID].setDown();
        // TODO: release the fork on the right
        System.out.println (ID + "EATING");
        if(ID == numberOfPhilosophers - 1){
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
       for (int i = 0; i < numberOfPhilosophers; i++){
           forks[i] = new Fork();
       }
       Thread[] philosophers = new Thread[numberOfPhilosophers];
       for (int i = 0; i < numberOfPhilosophers; i++){
           System.out.println ("start");
           philosophers[i] = new Thread(new Philosopher());
           philosophers[i].start();
       }
   }
}