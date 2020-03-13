package nl.workingtalent.cannes;

import java.util.Scanner;

public class Application{

	public static void main(String[] args){
		
		boolean quit = false;
		String boatName;
		long ticketID;
		int storedBoatPosition;
		String choiceInput;
		
		
		//Input numberOfPositions
		Scanner inputText = new Scanner(System.in);
		System.out.println("Thanks for using Michiels CannesDockTickets software for your dock.");
		System.out.println("Please insert the maximum number of boats your dock can store.");
		String numberOfPositionsString = inputText.nextLine();
		int numberOfPositions = Integer.parseInt(numberOfPositionsString);
		System.out.println("The maximum number of boats for the dock is set to: " + numberOfPositions);
		Dock cannesDock = new Dock(numberOfPositions);
		System.out.println("The system is now ready to print tickets for new boats stored in the dock. To enter menu type '-menu' as boat name.");
		
		while (quit == false){
			
			//New boat enters dock
			System.out.println("Welcome to the city docks!");
			System.out.println("Would you like to store your boat? Choose: 1");
			System.out.println("Would you like to take your boat from the dock? Choose: 2" );
			choiceInput = inputText.nextLine();
			if (choiceInput.equals("1")){
				System.out.println("To store your boat, please enter the name of your boat.");
				boatName = inputText.nextLine();
				if(boatName.equals("-menu" ) == true){
					System.out.println("Menu: ");
					System.out.println("-numberBoats : returns the number of boats in the dock.");
					System.out.println("-printBoats : prints the information of all boats in the dock.");
					System.out.println("-quit : close CannesDockTickets software.");
					choiceInput = inputText.nextLine();
					if(choiceInput.equals("-numberBoats") == true){
						System.out.println("Number of boats in the dock: " + cannesDock.getNumberOfBoatsStored() + ".");
						continue;
					}
					else if(choiceInput.equals("-printBoats") == true){
						System.out.println(cannesDock.printBoats());
					}
					else if(choiceInput.equals("-quit") == true){
						quit = true;
						System.out.println("CannesDockTickets software will close itself."); 
						continue;
					}
					else{
						System.out.println("Input not recognized as menu command.");
						continue;
					}
				}
				else{
					System.out.println("A ticket will be printed for the boat " + boatName + ". Please keep the ticket, since the ticketID is needed to get back your boat.");
					ticketID = cannesDock.createNewTicket(boatName);
					if(ticketID > 0){
						System.out.println("***Boat: " + boatName + ". TicketID: " + ticketID + "***");
						System.out.println("Thank you for using the city docks. Have a nice day!");
					}
					else{
						System.out.println("Sorry, there are no positions left for more boats in the city docks at the moment. Please try again later");
					}
				}
			}
			else if (choiceInput.equals("2")){
				System.out.println("To get your boat from the docks, please insert the ticket with the ticketID");
				ticketID = Long.parseLong(inputText.nextLine());
				storedBoatPosition = cannesDock.removeBoatFromDock(ticketID);
				boatName = cannesDock.dockArray[storedBoatPosition].getBoatName();
				System.out.println(boatName + " is ready to leave and can be found on dock number " + storedBoatPosition);
				System.out.println("Thank you for storing your boat " + boatName + " in the city docks. Have a nice day!");	
			}
			else{
				System.out.println("Please enter one of the following: 1, 2");
				continue;
			}
		}
		
		
		
		
		
		
	}
}