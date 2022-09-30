package controller;

import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TravelList;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
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
		String act = request.getParameter("doThisToItem");
		
		String path = "/viewAllPlacesServlet";
		
		if(act.equals("delete")) {
			
			try {
				
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				TravelList placeToDelete = tlh.searchForPlaceById(tempId);
				tlh.deletePlace(placeToDelete);
				
			} catch(NumberFormatException e) {
				System.out.println("Forgot to select a place");
			}
			
			
		}else if(act.equals("edit")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				TravelList placeToEdit = tlh.searchForPlaceById(tempId);
				request.setAttribute("placeToEdit", placeToEdit);path = "/edit-place.jsp";
				
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a place");
			}
			
			
		}else if(act.equals("add")) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
