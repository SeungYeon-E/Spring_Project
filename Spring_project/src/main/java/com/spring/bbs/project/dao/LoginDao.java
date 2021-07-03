package com.spring.bbs.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LoginDao {

	DataSource dataSource;
	
	public LoginDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_project");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String loginEmail(String strEmail, String strPwd) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		String result ="";
				
			try {
				connection = dataSource.getConnection();
				
				String query = "SELECT email FROM user WHERE email=? and pwd=?";
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, strEmail);
				preparedStatement.setString(2, strPwd);
					
				resultset = preparedStatement.executeQuery();
				
		      if(resultset.next()) {
		    	  String email = resultset.getString("email");
		    	  result = email;
		      } 
		    } catch (Exception e) {
		      e.printStackTrace();
			}finally {
				try {
					//정리 다시 거꾸로 정리해주는것
					if(resultset != null) resultset.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return result;
		}
	public String loginAdmin(String strEmail, String strPwd) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		String result ="";
				
			try {
				connection = dataSource.getConnection();
				
				String query = "SELECT admin FROM user WHERE email=? and pwd=?";
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, strEmail);
				preparedStatement.setString(2, strPwd);
					
				resultset = preparedStatement.executeQuery();
				
		      if(resultset.next()) {
		    	  String admin = resultset.getString("admin");
		    	  result = admin;
		      } 
		    } catch (Exception e) {
		      e.printStackTrace();
			}finally {
				try {
					//정리 다시 거꾸로 정리해주는것
					if(resultset != null) resultset.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return result;
		}		
	
	public String loginDeletedate(String strEmail, String strPwd) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		String result ="";
				
			try {
				connection = dataSource.getConnection();
				
				String query = "SELECT deletedate FROM user WHERE email=? and pwd=?";
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, strEmail);
				preparedStatement.setString(2, strPwd);
					
				resultset = preparedStatement.executeQuery();
				
		      if(resultset.next()) {
		    	  String deletedate = resultset.getString("deletedate");
		    	  result = deletedate;
		      } 
		    } catch (Exception e) {
		      e.printStackTrace();
			}finally {
				try {
					//정리 다시 거꾸로 정리해주는것
					if(resultset != null) resultset.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			return result;
		}		
	
	
}//--------------
