package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ComplaintDAO;
import model.ComplaintBean;

/**
 * Servlet implementation class Complaint
 */
@WebServlet("/complaint")
public class ComplaintController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ComplaintController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");

		ComplaintBean complaint = new ComplaintBean();
		complaint.setEmail(email);
		complaint.setName(name);
		complaint.setMessage(message);

		System.out.println(email);
		System.out.println(name);
		System.out.println(message);

		boolean isComplaintLogded = ComplaintDAO.addComplaint(complaint);
		String page = "";

		if (isComplaintLogded) {
			page = "/complaintreceived.jsp";
		} else {
			page = "#";
		}

		this.getServletContext().getRequestDispatcher(page).forward(request, response);
	}

}
