package by.tr.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import by.tr.library.bean.Book;
import by.tr.library.dao.AdminDao;
import by.tr.library.dao.connection.ConnectionPool;
import by.tr.library.dao.connection.ConnectionPoolException;
import by.tr.library.dao.exception.DAOException;

public class SQLAdminDao implements AdminDao {
	
	@Override
	public boolean addNewBook(Book book) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean res = false;
		try{
			con = ConnectionPool.getInstance().takeConnection();
			String sql = "INSERT INTO books (title, author, price) VALUES(?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setInt(3, book.getPrice());
			ps.executeUpdate();
			res = true;
		}
		catch(ConnectionPoolException e){
			throw new DAOException("Book adding failed", e);
		}
		catch(SQLException e){
			throw new DAOException("Book adding failed", e);
		}
		finally{
			if (ps != null){
				ConnectionPool.close(ps);
			}
			if (con != null){
				ConnectionPool.getInstance().closeConnection(con);
			}
		}
		return res;
	}

	@Override
	public boolean deleteBook(String title, String author) throws DAOException {
		Connection con = null;
		PreparedStatement ps = null;
		boolean res = false;
		try{
			con = ConnectionPool.getInstance().takeConnection();
			String sql = "DELETE FROM books WHERE title=? AND author=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, author);
			if (ps.executeUpdate() != 0){
				res = true;
			}
		}
		catch(ConnectionPoolException e){
			throw new DAOException("Book deleting failed", e);
		}
		catch(SQLException e){
			throw new DAOException("Book deleting failed", e);
		}
		finally{
			if (ps != null){
				ConnectionPool.close(ps);
			}
			if (con != null){
				ConnectionPool.getInstance().closeConnection(con);
			}
		}
		return res;
	}

}