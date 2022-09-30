package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TravelList;

/**
 * Servlet implementation class addPlaceServlet
 */
@WebServlet("/addPlaceServlet")
public class addPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPlaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		
		TravelList tl = new TravelList(country, state, city);
		TravelingListHelper tlh = new TravelingListHelper();
		tlh.insertPlace(tl);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
