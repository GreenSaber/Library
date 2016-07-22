package by.tr.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import by.tr.library.bean.Book;
import by.tr.library.dao.UserDao;
import by.tr.library.dao.connection.ConnectionPool;
import by.tr.library.dao.connection.ConnectionPoolException;
import by.tr.library.dao.exception.DAOException;

public class SQLUserDao implements UserDao{
		
	@Override
	public ArrayList<Book> getCatalog() throws DAOException{
		ArrayList<Book> catalog = new ArrayList<Book>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try{
			con = ConnectionPool.getInstance().takeConnection();
			String sql = "SELECT * FROM books";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				catalog.add(new Book(rs.getString("title"),rs.getString("author"), rs.getInt("price")));
			}
		}
		catch(ConnectionPoolException e){
			throw new DAOException("Getting catalog fail", e);
		}
		catch(SQLException e){
			throw new DAOException("Getting catalog fail", e);
		}
		finally{
			if (ps != null){
				ConnectionPool.close(ps);
			}
			if (rs != null){
				ConnectionPool.close(rs);
			}
			if (con != null){
				ConnectionPool.getInstance().closeConnection(con);
			}
		}
		return catalog;
	}
	
	@Override
	public Book getBookByTitle(String title) throws DAOException{
		Book book = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = ConnectionPool.getInstance().takeConnection();
			String sql = "SELECT * FROM books WHERE title=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			rs = ps.executeQuery();
			if (rs.next()){
				book = new Book(rs.getString(1), rs.getString(2), rs.getInt(3));
			}
		}
		catch(ConnectionPoolException e){
			throw new DAOException("<Get book by title> operation failed", e);
		}
		catch(SQLException e){
			throw new DAOException("<Get book by title> operation failed", e);
		}
		finally{
			if (ps != null){
				ConnectionPool.close(ps);
			}
			if (rs != null){
				ConnectionPool.close(rs);
			}
			if (con != null){
				ConnectionPool.getInstance().closeConnection(con);
			}
		}
		return book;
	}

	
}