package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.TransactionBean;
import model.UserBean;
import utility.ConnectionManager;

public class FetchTransactionDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;

	public static ArrayList<TransactionBean> getTransactions(HttpServletRequest request, String start_date,
			String end_date) {

		ArrayList<TransactionBean> transactions = null;

		Statement stmt = null;

		UserBean currentUser = ((UserBean) (request.getSession().getAttribute("currentSessionUser")));

		String filterTransactionQuery = "select * from Transactions where username='" + currentUser.getUsername()
				+ "' and transactiondt>='" + start_date + "' and transactiondt<='" + end_date + "';";

		System.out.println(filterTransactionQuery);

		try {
			// connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(filterTransactionQuery);

			transactions = new ArrayList<TransactionBean>();

			while (rs.next()) {
				TransactionBean transaction = new TransactionBean();
				transaction.setTransactionID(rs.getString("transaction_id"));
				transaction.setTransactionType(rs.getString("transactiontype"));
				transaction.setToAccount(String.valueOf(rs.getInt("toaccount")));
				transaction.setAmount(String.valueOf(rs.getInt("amount")));
				transaction.setStatus(rs.getString("status"));
				transaction.setDescription(rs.getString("description"));
				transaction.setDateTime(String.valueOf(rs.getDate("transactiondt")));

				transactions.add(transaction);

			}
			;
		} catch (Exception ex) {
			System.out.println("Failed to get the transactions! " + ex);
		}

		// some exception handling
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}

				currentCon = null;
			}
		}

		return transactions;
	}

}
