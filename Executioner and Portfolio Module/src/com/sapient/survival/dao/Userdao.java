package com.sapient.survival.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sapient.survival.pojo.User;
import com.sapient.util.ConnectionUtil;

public class Userdao {

	public User FetchUser(String username) throws SQLException {

		Connection conn = ConnectionUtil.getConnection();

		// Execute SQL query

		String sql;
		sql = "SELECT * FROM user where username=?";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, username);

		ResultSet rs = stmt.executeQuery();
		if (rs.next())
			try {
				{
					String UserNameFetched = rs.getString("username");
					String NameFetched = rs.getString("name");
					System.out.println(username);
					BigDecimal userId = rs.getBigDecimal("user_id");
					System.out.println(userId);
					String role = rs.getString("role");
					String password = rs.getString("password");
					User fetchedUser = new User();
					fetchedUser.setPassword(password);
					fetchedUser.setRole(role);
					fetchedUser.setUsername(UserNameFetched);
					fetchedUser.setUserId(userId);
					fetchedUser.setName(NameFetched);
					return fetchedUser;

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;

	}

}
