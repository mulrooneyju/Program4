
import java.util.Random;
import java.util.Scanner;

public class Philosopher extends Thread 
{ 
   // each Philosopher is assigned an integer ID and two forks 
   private int ID = 0;
   private static int IDCounter = 0;
   private static int numberOfPhilosophers = 5;
   private static Fork[] forks = new Fork[numberOfPhilosophers];
   private int thinkingTime = 0;
   private int eatingTime = 0;
   private int eatingAmount = 0;
   private int thinkingAmount = 0;
   

    public void run()  
    {
        ID = IDCounter++;
    boolean timeToGO = false;
    while (!timeToGO) 
    { 
        System.out.println (ID + " THINKING"); 
        // TODO: think for random number of milliseconds <=1 sec 
        Random rand = new Random();
        try{
            int wait = rand.nextInt(999) + 1;
            thinkingTime += wait;
            thinkingAmount++;
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
            eatingTime += wait;
            eatingAmount++;
            Thread.sleep(wait);
        } catch(InterruptedException e) {}
        // TODO: release the fork on the left  
        forks[ID].setDown();
        // TODO: release the fork on the right
        System.out.println (ID + " EATING");
        if(ID == numberOfPhilosophers - 1){
            forks[0].setDown();
        } else { forks[ID + 1].setDown();}
        if(thinkingTime >= 1000){
            timeToGO = !timeToGO;
        }
   } 

   System.out.println(ID+ " DONE");
   System.out.println("Philosopher " + (ID + 1) + " ate " + eatingAmount + " times for " + eatingTime + "ms");
   System.out.println("They thought " + thinkingAmount + " times for " + thinkingTime + "ms");
   } 

   public static void main(String[] args)
   {
       System.out.println(numberOfPhilosophers);
       for (int i = 0; i < numberOfPhilosophers; i++){
           forks[i] = new Fork();
       }
       Thread[] philosophers = new Thread[numberOfPhilosophers];
       for (int i = 0; i < numberOfPhilosophers; i++){
           
           philosophers[i] = new Thread(new Philosopher());
           philosophers[i].start();
       }
   }
}