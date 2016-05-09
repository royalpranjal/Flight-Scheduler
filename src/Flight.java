import java.lang.Thread;

public class Flight extends Thread implements Runnable{
	private int flight_id;
	private String flight_name;
	
	Flight(int id, String name){
		flight_id = id;
		flight_name = name;
		System.out.println("Flight " + flight_name + " with id : " + flight_id + " CREATED.");
		System.out.println("");
	}
	
	@Override
	public void run(){
		try{
			FlightLock.getInstance().getRunwayWait();
			System.out.println("Flight " + this.flight_name + " with id : " + this.flight_id + " is WAITING in a queue.");
			System.out.println("Flight " + this.flight_name + " with id : " + this.flight_id + " TRYING to access the runway.");
			FlightLock.getInstance().getRunwayUse();
			System.out.println("Flight " + this.flight_name + " with id : " + this.flight_id + " has ACQUIRED the runway.");
			System.out.println("Flight " + this.flight_name + " with id : " + this.flight_id + " is USING the runway.");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		finally{
			FlightLock.getInstance().releaseRunwayUse();
			System.out.println("Flight " + this.flight_name + " with id : " + this.flight_id + " EXITED the runway.");
		}
		
	}
}
