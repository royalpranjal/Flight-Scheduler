import java.util.Scanner;
import java.util.ArrayList;

class Threading implements Runnable{ 
	private Thread t;
	private String threadname;
	
	Threading (String x){
		threadname = x;
		System.out.println("Flight " + threadname + " created");
	}
	
	@Override
	public void run(){
		System.out.println("Flight " + threadname + " running");
		try{
			Thread.sleep(400);
			// waits for this time & does some work 
			//& also lets other thread finish their tasks 
		}
		catch (InterruptedException e){
			System.out.println("Flight " + threadname + " interrupted");
		}
		System.out.println("Flight " + threadname + " exiting the runway");
	}
	 
	public void start(){
		// start() calls run() implicitly 
		System.out.println("Flight " + threadname + " starting");
		if(t == null){
			t = new Thread (this, threadname);
			//Thread(Runnable threadObj, String threadName);
			//threadObj is an instance of a class that implements 
			//the Runnable interface and threadName is the name given to the new thread
			t.start();
		}
	}
}

class Multithreading{
	public static void main (String args[]){
		int number, i;;
		String flight_name;
		
		Scanner numb = new Scanner(System.in);
		Scanner str = new Scanner(System.in);
		
		System.out.println("Enter the number of flights : ");
		number = numb.nextInt();
		
		ArrayList<Threading> flight_list = new ArrayList<Threading>();
		
		for(i = 0; i < number; i ++){
			System.out.println("Enter the name of the flight: ");
			flight_name = str.nextLine();
			Threading t = new Threading(flight_name);
			//adding the flight to the ArrayList for future access
			flight_list.add(t);
		}
		
		for(i = 0; i < number; i ++){
			//starting the flight which will automatically run
			flight_list.get(i).start();
		}
		//closing the Scanner
		numb.close();
		str.close();
	}
}