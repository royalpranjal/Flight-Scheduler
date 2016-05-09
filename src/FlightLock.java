import java.util.concurrent.Semaphore;

public class FlightLock {
	//Making the class singleton
	private FlightLock(){
		
	}
	
	//Instance of the class
	private static class SingletonHolder{
		private static final FlightLock INSTANCE = new FlightLock();
	}
	
	//getting the reference of the instantiated class
	public static FlightLock getInstance(){
		return SingletonHolder.INSTANCE;
	}
	
	// one which can use the run-way at any point of time
	private Semaphore runwayUse = new Semaphore(1);
	
	//5 flights which will wait on the airstrip
	private Semaphore runwayWait = new Semaphore(5);
	
	public void getRunwayUse() throws InterruptedException{		
		runwayUse.acquire();
	}
	
	public void releaseRunwayUse(){
		runwayUse.release();
	}
	
	public void getRunwayWait() throws InterruptedException{
		runwayWait.acquire();
	}
	
	public void releaseRunwayWait(){
		runwayWait.release();
	}
	
}
