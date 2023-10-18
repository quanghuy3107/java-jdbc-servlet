package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import com.laptrinhjavaweb.dao.GenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;

public class AbstracDao<T> implements GenericDAO<T> {
	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	public Connection getConnetion() {
		Connection c = null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/servlet";
//			String user = "root";
//			String password = "31072004";
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			c =  DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
		
		return c;
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		try {
			connection = getConnetion();
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			resultset = statement.executeQuery();
			while (resultset.next()) {
				
				results.add(rowMapper.mapRow(resultset));
			}
			System.out.println("da hoan thanh query");
			return results;
		} catch(SQLException e){
			return null;
		} finally {
			try {
				if( connection != null) {
					connection.close();
				}
				if( statement != null) {
					statement.close();
				}if( resultset != null) {
					resultset.close();
				}
			} catch (SQLException e){
				return null;
			}
		}
	}

	private void setParameters(PreparedStatement statement, Object... parameters) {
		try {
			for(int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if(parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				}else if(parameter instanceof String) {
					statement.setString(index, (String) parameter);
				}else if(parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				}else if(parameter instanceof Double) {
					statement.setDouble(index, (Double) parameter);
				}else if(parameter instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameter);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnetion();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameters(statement, parameters);
			statement.executeUpdate();
			connection.commit();
			
		} catch(SQLException e){
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				if( connection != null) {
					connection.close();
				}
				if( statement != null) {
					statement.close();
				}
			} catch (SQLException e){
				
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Long id = null;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = getConnetion();
			con.setAutoCommit(false);
			
			st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			System.out.println("thanhcong");
			setParameters(st, parameters);
			st.executeUpdate();
			
			rs = st.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getLong(1);
			}

			con.commit();
			System.out.println(id);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("khongthanhcong");
		}finally {
			try {
				if( con != null) {
					con.close();
				}
				if( st != null) {
					st.close();
				}if( rs != null) {
					rs.close();
				}
			} catch (SQLException e){
				return null;
			}
		}
		return null;
	}

	@Override
	public int getTotalItem(String sql, Object... parameters) {
		int id = 0;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = getConnetion();
			con.setAutoCommit(false);
			
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			
			if(rs.next()) {
				 id =  rs.getInt(1);
			}

			System.out.println(id);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("khongthanhcong");
		}finally {
			try {
				if( con != null) {
					con.close();
				}
				if( st != null) {
					st.close();
				}if( rs != null) {
					rs.close();
				}
			} catch (SQLException e){
				return 0;
			}
		}
		return 0;
	}
}
