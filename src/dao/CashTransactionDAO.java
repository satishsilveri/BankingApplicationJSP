package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.CashTransactionBean;
import utility.ConnectionManager;

public class CashTransactionDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;

	public static boolean performTransactions(CashTransactionBean cashBean) {
		Statement stmt = null;

		try {

			// insert transaction
			String insertTransactionStmt = "Insert into Transactions value(" + cashBean.getAccountNumber() + ",'"
					+ cashBean.getTransactionType() + "'," + cashBean.getAmount() + ",'" + cashBean.getDescription()
					+ "',curdate());";

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(insertTransactionStmt);

			// update the amount in balace table
			String getBalance = "select amount from CustomerBalance where accountNumber=" + cashBean.getAccountNumber()
					+ ";";

			rs = stmt.executeQuery(getBalance);

			int currentBalance = 0;
			while (rs.next()) {
				currentBalance = rs.getInt("currrent_balance");

			}

			int updatedBalance = 0;

			if (cashBean.getTransactionType().equalsIgnoreCase("deposit")) {
				updatedBalance = currentBalance + cashBean.getAmount();
			} else if (cashBean.getTransactionType().equalsIgnoreCase("withdraw")) {
				updatedBalance = currentBalance - cashBean.getAmount();
			}

			String updateBalance = "update CustomerBalance set amount=" + updatedBalance + "where accountNumber="
					+ cashBean.getAccountNumber() + ";";

			rs = stmt.executeQuery(updateBalance);

			return true;

		} catch (Exception e) {
			return false;
		} finally {

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
	}

}
