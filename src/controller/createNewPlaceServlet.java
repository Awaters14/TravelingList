package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TravelList;
import model.Traveler;
import model.TravelerListDetails;

/**
 * Servlet implementation class createNewPlaceServlet
 */
@WebServlet("/createNewPlaceServlet")
public class createNewPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewPlaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TravelingListHelper tlh = new TravelingListHelper();
		String TripsName = request.getParameter("tripsName");
		System.out.println("Trips Name: "+ TripsName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String travelersName = request.getParameter("travelersName");
		
		LocalDate ld;
		try{
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			} catch(NumberFormatException ex) {
				ld = LocalDate.now();
			}
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<TravelList> selectedItemsInList = new ArrayList<TravelList>();
		//make sure something was selected –otherwise we get a null pointer exception
		if (selectedItems != null && selectedItems.length > 0) {
			for(int i = 0; i<selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				TravelList c = tlh.searchForPlaceById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
		}
		
		Traveler traveler = new Traveler(travelersName);
		TravelerListDetails sld = new TravelerListDetails(TripsName, ld, traveler);
		sld.setListOfPlaces(selectedItemsInList);
		TravelListDetailHelper slh = new TravelListDetailHelper();
		slh.insertNewListDetails(sld);
		
		System.out.println("Success!");
		System.out.println(sld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
