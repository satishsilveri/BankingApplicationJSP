package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.ComplaintBean;
import utility.ConnectionManager;

public class ComplaintDAO {

	static Connection currentCon = null;
	static ResultSet rs = null;

	public static boolean addComplaint(ComplaintBean complaint) {
		Statement stmt = null;

		try {

			String addComplaintStmt = "Insert into Complaints value('" + complaint.getName() + "','"
					+ complaint.getEmail() + "','" + complaint.getMessage() + "');";

			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(addComplaintStmt);

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
