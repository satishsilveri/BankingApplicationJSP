package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CashTransactionDAO;
import model.CashTransactionBean;

/**
 * Servlet implementation class CashTransaction
 */
@WebServlet("/cashtransaction")
public class CashTransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CashTransactionController() {
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

		String accountNumber = request.getParameter("accountnumber");
		String operation = request.getParameter("operation");
		String amount = request.getParameter("amount");
		String description = request.getParameter("description");

		CashTransactionBean cashBean = new CashTransactionBean();
		cashBean.setAccountNumber(Integer.parseInt(accountNumber));
		cashBean.setAmount(Integer.parseInt(amount));
		cashBean.setTransactionType(operation);
		cashBean.setDescription(description);

		boolean isTransactionSuccessful = CashTransactionDAO.performTransactions(request,cashBean);

		String page = "";
		if (isTransactionSuccessful) {
			page = "/transactionsuccess.jsp";
		} else {
			page = "/transactionfailed.jsp";
		}

		this.getServletContext().getRequestDispatcher(page).forward(request, response);
	}

}
