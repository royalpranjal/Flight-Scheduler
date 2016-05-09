import java.util.ArrayList;
import java.util.Scanner;

public class FlightScheduler {
	public static void main(String args[]) throws InterruptedException{
		int number, i;
		String name;
		
		Scanner no = new Scanner(System.in);
		Scanner na = new Scanner(System.in); 
		Scanner pri = new Scanner(System.in);
		
		System.out.println("Enter the total number of flights");
		number = no.nextInt();
		
		int[] prior = new int[number];
		
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		
		i = 0;
		while(i != number){
			System.out.println("Enter the name of the flight");
			name = na.nextLine();
			
			System.out.println("Enter the priority of the flight (1-5 for take-off & 6-10 for landing)");
			prior[i] = pri.nextInt();
			
			Flight f = new Flight(i+1, name);
			f.setPriority(prior[i]);
			
			flightList.add(f); 
			
			i++;
		}
		
		i = 0;
		
		while(i != number){
			flightList.get(i).start();
			i++;
		}
		
		no.close();
		na.close();
		pri.close();
	}
}
