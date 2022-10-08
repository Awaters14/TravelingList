import java.time.LocalDate;
import java.util.List;

import controller.TravelListDetailHelper;
import controller.TravelerHelper;
import model.Traveler;
import model.TravelerListDetails;



/**  
* @author Alex Waters - Awaters6
* CIS175 - Fall 2021
* Oct 3, 2022  
*/
public class TravelListDetailTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Traveler bob = new Traveler("Bob");
		
		TravelerHelper th = new TravelerHelper();
		
		th.insertTraveler(bob);
		
		TravelListDetailHelper tldh = new TravelListDetailHelper();
		
		TravelerListDetails BobList= new TravelerListDetails("Bob's List", LocalDate.now(), bob);
		
		tldh.insertNewListDetails(BobList);
		
		List<TravelerListDetails> allLists = tldh.getLists();
		
		for(TravelerListDetails a : allLists) {
			System.out.println(a.toString());
		}
	}

}
