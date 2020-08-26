package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.CashTransactionBean;
import utility.ConnectionManager;
import utility.Utility;

public class CashTransactionDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;

	public static boolean performTransactions(CashTransactionBean cashBean) {
		Statement stmt = null;

		try {

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();

			// update the amount in balance table
			String getBalance = "select amount from CustomerBalance where user_id=" + cashBean.getAccountNumber() + ";";

			rs = stmt.executeQuery(getBalance);

			int currentBalance = 0;
			while (rs.next()) {
				currentBalance = rs.getInt("amount");
			}

			int updatedBalance = 0;

			if (cashBean.getTransactionType().equalsIgnoreCase("deposit")) {
				updatedBalance = currentBalance + cashBean.getAmount();
			} else if (cashBean.getTransactionType().equalsIgnoreCase("withdraw")) {
				updatedBalance = currentBalance - cashBean.getAmount();
			}

			String updateBalance = "update CustomerBalance set amount=" + updatedBalance + " where user_id="
					+ cashBean.getAccountNumber() + ";";
			

			int rs1 = stmt.executeUpdate(updateBalance);

			String insertTransactionStmt = "";

			if (rs1 == 1) {

				// insert transaction
				insertTransactionStmt = "Insert into Transactions value(" + cashBean.getAccountNumber() + ",'"
						+ Utility.getTransctionID() + "','" + cashBean.getTransactionType() + "',"
						+ cashBean.getAmount() + ",'success','" + cashBean.getDescription() + "',curdate());";
			} else {

				insertTransactionStmt = "Insert into Transactions value(" + cashBean.getAccountNumber() + ",'"
						+ Utility.getTransctionID() + "','" + cashBean.getTransactionType() + "',"
						+ cashBean.getAmount() + ",'failed','" + cashBean.getDescription() + "',curdate());";

			}

			int rs2 = stmt.executeUpdate(insertTransactionStmt);

			if (rs2 == 1) {

				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println(e);
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
