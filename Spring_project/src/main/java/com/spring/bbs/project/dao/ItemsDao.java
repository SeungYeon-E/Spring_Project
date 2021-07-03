package com.spring.bbs.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.spring.bbs.project.dto.PostDto;


public class ItemsDao {

	DataSource dataSource;
	
	public ItemsDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_project");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	}
	
	public ArrayList<PostDto> list(int start, int pageCnt) {
		ArrayList<PostDto> dtos = new ArrayList<PostDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
	
		try {
			connection = dataSource.getConnection();

			String query = "select * from item where i_num in (select item_i_num from write_item where iw_delete is null) LIMIT ?, ?";
			preparedStatement = connection.prepareStatement(query);
		
			int offset = start - 1;
		
			preparedStatement.setInt(1, offset);
			
			preparedStatement.setInt(2, pageCnt);
			
			resultset = preparedStatement.executeQuery();
			
			while(resultset.next()) {
				int num = resultset.getInt("I_NUM");
				String title = resultset.getString("I_TITLE");
				String content = resultset.getString("I_CONTENT");
				String imgSrc = resultset.getString("I_IMAGE");
				String category = resultset.getString("I_CATEGORY");
				int views = resultset.getInt("I_HITS");
				
				PostDto dto = new PostDto(num, title, content, imgSrc, category, views);
				dtos.add(dto);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultset != null) resultset.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return dtos;
	}
	
	public ArrayList<PostDto> listCom(int start, int pageCnt) {
		ArrayList<PostDto> dtos = new ArrayList<PostDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
	
		try {
			connection = dataSource.getConnection();

			String query = "SELECT * FROM item where i_CATEGORY = '컴퓨터' and i_num in (select item_i_num from write_item where iw_delete is null) LIMIT ?, ?";
			preparedStatement = connection.prepareStatement(query);
		
			int offset = start - 1;
		
			preparedStatement.setInt(1, offset);
			
			preparedStatement.setInt(2, pageCnt);
			
			resultset = preparedStatement.executeQuery();
			
			while(resultset.next()) {
				int num = resultset.getInt("I_NUM");
				String title = resultset.getString("I_TITLE");
				String content = resultset.getString("I_CONTENT");
				String imgSrc = resultset.getString("I_IMAGE");
				String category = resultset.getString("I_CATEGORY");
				int views = resultset.getInt("I_HITS");
				
				PostDto dto = new PostDto(num, title, content, imgSrc, category, views);
				dtos.add(dto);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultset != null) resultset.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return dtos;
	}
	
	public ArrayList<PostDto> listAcc(int start, int pageCnt) {
		ArrayList<PostDto> dtos = new ArrayList<PostDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
	
		try {
			connection = dataSource.getConnection();

			String query = "SELECT * FROM item where i_CATEGORY = '악세사리' and i_num in (select item_i_num from write_item where iw_delete is null) LIMIT ?, ?";
			preparedStatement = connection.prepareStatement(query);
		
			int offset = start - 1;
		
			preparedStatement.setInt(1, offset);
			
			preparedStatement.setInt(2, pageCnt);
			
			resultset = preparedStatement.executeQuery();
			
			while(resultset.next()) {
				int num = resultset.getInt("I_NUM");
				String title = resultset.getString("I_TITLE");
				String content = resultset.getString("I_CONTENT");
				String imgSrc = resultset.getString("I_IMAGE");
				String category = resultset.getString("I_CATEGORY");
				int views = resultset.getInt("I_HITS");
				
				PostDto dto = new PostDto(num, title, content, imgSrc, category, views);
				dtos.add(dto);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultset != null) resultset.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return dtos;
	}
	
	public ArrayList<PostDto> listDesk(int start, int pageCnt) {
		ArrayList<PostDto> dtos = new ArrayList<PostDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
	
		try {
			connection = dataSource.getConnection();

			String query = "SELECT * FROM item where i_CATEGORY = '책상' and i_num in (select item_i_num from write_item where iw_delete is null) LIMIT ?, ?";
			preparedStatement = connection.prepareStatement(query);
		
			int offset = start - 1;
		
			preparedStatement.setInt(1, offset);
			
			preparedStatement.setInt(2, pageCnt);
			
			resultset = preparedStatement.executeQuery();
			
			while(resultset.next()) {
				int num = resultset.getInt("I_NUM");
				String title = resultset.getString("I_TITLE");
				String content = resultset.getString("I_CONTENT");
				String imgSrc = resultset.getString("I_IMAGE");
				String category = resultset.getString("I_CATEGORY");
				int views = resultset.getInt("I_HITS");
				
				PostDto dto = new PostDto(num, title, content, imgSrc, category, views);
				dtos.add(dto);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultset != null) resultset.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return dtos;
	}
	
	public ArrayList<PostDto> listOthers(int start, int pageCnt) {
		ArrayList<PostDto> dtos = new ArrayList<PostDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
	
		try {
			connection = dataSource.getConnection();

			String query = "SELECT * FROM item where i_CATEGORY = '기타' and i_num in (select item_i_num from write_item where iw_delete is null) LIMIT ?, ?";
			preparedStatement = connection.prepareStatement(query);
		
			int offset = start - 1;
		
			preparedStatement.setInt(1, offset);
			
			preparedStatement.setInt(2, pageCnt);
			
			resultset = preparedStatement.executeQuery();
			
			while(resultset.next()) {
				int num = resultset.getInt("I_NUM");
				String title = resultset.getString("I_TITLE");
				String content = resultset.getString("I_CONTENT");
				String imgSrc = resultset.getString("I_IMAGE");
				String category = resultset.getString("I_CATEGORY");
				int views = resultset.getInt("I_HITS");
				
				PostDto dto = new PostDto(num, title, content, imgSrc, category, views);
				dtos.add(dto);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultset != null) resultset.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return dtos;
	}
	
	public int selectItem(){
		int count=0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "SELECT COUNT(*) FROM ITEM";
			preparedStatement = connection.prepareStatement(query);
			
			resultset = preparedStatement.executeQuery();
			
			while(resultset.next()) {
				count += resultset.getInt(1);
			}
			System.out.println(count);
		}catch(Exception e) {
			System.out.println("list-count fail");
			e.printStackTrace();
		}finally {
			try {
				if(resultset != null) resultset.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return count;
		}
	
	


}
