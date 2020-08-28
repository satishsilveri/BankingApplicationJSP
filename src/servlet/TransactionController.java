package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FetchTransactionDAO;
import model.TransactionBean;

/**
 * Servlet implementation class TransactionController
 */
@WebServlet("/filter_transactions")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransactionController() {
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

		String start_date = request.getParameter("start_date");
		String end_date = request.getParameter("end_date");

		ArrayList<TransactionBean> transactions = FetchTransactionDAO.getTransactions(request, start_date, end_date);

		request.setAttribute("transactions", transactions);

		RequestDispatcher view = request.getRequestDispatcher("viewtransactions.jsp");
		view.forward(request, response);

	}

}
