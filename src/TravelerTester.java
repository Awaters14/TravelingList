import java.util.List;

import controller.TravelerHelper;
import model.Traveler;

/**  
* @author Alex Waters - Awaters6
* CIS175 - Fall 2021
* Oct 3, 2022  
*/
public class TravelerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Traveler bob = new Traveler("Bob");
		Traveler builder = new Traveler("Builder");
		
		TravelerHelper th = new TravelerHelper();
		th.insertTraveler(bob);
		th.insertTraveler(builder);
		
		List<Traveler> allTravlers = th.showAllTravelers();
		
		for(Traveler a: allTravlers) {
			System.out.println(a.toString());
		}
		
	}

}
