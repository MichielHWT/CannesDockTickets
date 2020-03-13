package nl.workingtalent.cannes;

public class Boat{

	private String boatName;
	private long ticketID;
	private int storedPosition;
	
	public Boat(){
		
	}
	
	public void setTicketID(long ticketID){
		this.ticketID = ticketID;
	}
	
	public long getTicketID(){
		return ticketID;
	}
	
	public void setBoatname(String boatName){
		this.boatName = boatName;
	}
	
	public String getBoatName(){
		return boatName;
	}
	
	public int getStoredPosition(){
		return storedPosition;
	}
	
	public void setStoredPosition(int storedPosition){
		this.storedPosition = storedPosition;
	}
	
	public String toString(){ 
		return ("Storedposition: " + storedPosition + " Boatname: " + boatName + " TicketID: " + ticketID);
	}
}