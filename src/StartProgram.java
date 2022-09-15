
/**  
* @author Alex Waters - Awaters6
* CIS175 - Fall 2021
* Sep 14, 2022  
*/

import java.util.List;
import java.util.Scanner;

import controller.TravelingListHelper;
import model.TravelList;

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static TravelingListHelper tlh = new TravelingListHelper();

	private static void addAPlace() {

		System.out.print("Enter a Country: ");
		String country = in.nextLine();
		System.out.print("Enter a state: ");
		String state = in.nextLine();
		System.out.print("Enter an city: ");
		String city = in.nextLine();

		TravelList toAdd = new TravelList(country, state, city);
		tlh.insertPlace(toAdd);

	}

	private static void deleteAPlace() {

		System.out.print("Enter the Country to delete: ");
		String country = in.nextLine();
		System.out.print("Enter the state to delete: ");
		String state = in.nextLine();
		System.out.print("Enter the city to delete: ");
		String city = in.nextLine();
		TravelList toDelete = new TravelList(country, state, city);
		tlh.deletePlace(toDelete);

	}

	private static void editAPlace() {

		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Country");
		System.out.println("2 : Search by State");
		System.out.println("3 : Search by City");
		int searchBy = in.nextInt();
		in.nextLine();
		List<TravelList> foundPlaces;
		if (searchBy == 1) {
			System.out.print("Enter the Country name: ");
			String countryName = in.nextLine();
			foundPlaces = tlh.searchForPlaceByCountry(countryName);
		} else if (searchBy == 2) {
			System.out.print("Enter the State name: ");
			String stateName = in.nextLine();
			foundPlaces = tlh.searchForPlaceByState(stateName);
		} else {
			System.out.print("Enter the City name: ");
			String cityName = in.nextLine();
			foundPlaces = tlh.searchForPlaceByState(cityName);
		}

		if (!foundPlaces.isEmpty()) {
			System.out.println("Found Results.");
			for (TravelList l : foundPlaces) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			TravelList toEdit = tlh.searchForPlaceById(idToEdit);
			System.out.println(
					"Retrieved " + toEdit.getCity() + " from " + toEdit.getState() + ", " + toEdit.getCountry());
			System.out.println("1 : Update Country");
			System.out.println("2 : Update State");
			System.out.println("3 : Update City");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Country: ");
				String newCountry = in.nextLine();
				toEdit.setState(newCountry);
			} else if (update == 2) {
				System.out.print("New State: ");
				String newState = in.nextLine();
				toEdit.setState(newState);
			} else if (update == 3) {
				System.out.print("New City: ");
				String newCity = in.nextLine();
				toEdit.setCity(newCity);
			}

			tlh.updatePlace(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Travel List ---");
		while (goAgain) {
			System.out.println("*  Select an option:");
			System.out.println("*  1 -- Add a Place");
			System.out.println("*  2 -- Edit a Place");
			System.out.println("*  3 -- Delete a Location");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAPlace();
			} else if (selection == 2) {
				editAPlace();
			} else if (selection == 3) {
				deleteAPlace();
			} else if (selection == 4) {
				viewTheList();
			} else {
				tlh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub

		List<TravelList> allItems = tlh.showAllPlaces();

		for (TravelList singleItem : allItems) {
			System.out.println(singleItem.returnTravelDetails());
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

}
