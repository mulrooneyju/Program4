

public class Philosopher extends Thread 
{ 
// each Philosopher is assigned an integer ID and two forks 
private int ID = 0;



Philosopher()
{
   this.ID = ;
}
   
public void run()  
{ 
   boolean timeToGO = false;
while (!timeToGO) 
{ 
System.out.println (ID+ "THINKING"); 
// TODO: think for random number of milliseconds <=1 sec 
// TODO: obtain the fork on the left 
// TODO: obtain the fork on the right 
System.out.println (ID + "EATING"); 
// TODO: eat for random number of milliseconds <= 1sec 
// TODO: release the fork on the left  
// TODO: release the fork on the right
timeToGO = !timeToGO;
} 

System.out.println(ID+ "DONE");
} 

public static void main(String[] args)
{
   Philosopher tom = new Philosopher();
   tom.run();
}
}