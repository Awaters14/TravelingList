package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TravelList;

/**
 * Servlet implementation class editPlaceServlet
 */
@WebServlet("/editPlaceServlet")
public class editPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPlaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TravelingListHelper tlh = new TravelingListHelper();
		
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		TravelList placeToUpdate = tlh.searchForPlaceById(tempId);
		placeToUpdate.setCountry(country);
		placeToUpdate.setState(state);
		placeToUpdate.setCity(city);
		
		tlh.updatePlace(placeToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllPlacesServlet").forward(request, response);
	}

}
