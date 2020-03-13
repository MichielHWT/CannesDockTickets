package nl.workingtalent.cannes;

public class Dock{

	private int numberOfPositions;
	private int numberOfBoatsStored = 0;
	private long ticketIDCounter = 1;
	Boat[] dockArray;

	public Dock(int numberOfPositions){
		this.numberOfPositions = numberOfPositions;
		
		dockArray = new Boat[numberOfPositions];
	
		for (int i = 0; i < numberOfPositions; ++i){
			dockArray[i] = new Boat();
		}
	}
	
	public long createNewTicket(String boatName){
		long returnTicketID = -1;
		long ticketID;
		//Check if there is a free position
		for (int i = 0; i < numberOfPositions; ++i){
			ticketID = dockArray[i].getTicketID();
			if(ticketID == 0){
				//Create new ticket for boat
				ticketID = ticketIDCounter;
				returnTicketID = ticketID;
				dockArray[i].setTicketID(ticketID);
				dockArray[i].setBoatname(boatName);
				dockArray[i].setStoredPosition(i + 1);
				++ticketIDCounter;
				++numberOfBoatsStored;
				break;
			}
		}
		return returnTicketID;
	}

	public int removeBoatFromDock(long ticketID){
		int boatStoredPosition = getBoatStoredPosition(ticketID);
		dockArray[boatStoredPosition].setTicketID(0);
		//dockArray[boatStoredPosition].boatName = "";
		//dockArray[boatStoredPosition].storedPosition = 0;
		--numberOfBoatsStored;
		return boatStoredPosition;
	}
	
	public int getBoatStoredPosition(long ticketID){
		int boatStoredPosition = 0;
		for (int i = 0; i < numberOfPositions; ++i){
			if(dockArray[i].getTicketID() == ticketID){
				boatStoredPosition = dockArray[i].getStoredPosition();
			}
		}
		return boatStoredPosition;
	}
	
	public int getNumberOfBoatsStored(){
		return numberOfBoatsStored;
	}
	
	public String printBoats(){
		String totalPrint = "";
		for (int i = 0; i < numberOfPositions; ++i){
			if(dockArray[i].getTicketID() == 0){
				totalPrint = totalPrint + "";
			}
			else{
				totalPrint = totalPrint + dockArray[i].toString() + "\n";
			}
		}
		if(totalPrint == ""){
			totalPrint = "There are no boats in the dock.";
		}
		return totalPrint;
	}
}