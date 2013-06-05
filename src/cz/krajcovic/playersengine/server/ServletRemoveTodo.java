/**
 * 
 */
package cz.krajcovic.playersengine.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.krajcovic.playersengine.server.dao.Dao;

/**
 * @author krajcovic
 *
 */
public class ServletRemoveTodo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3171813346125708773L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		Dao.INSTANCE.remove(Long.parseLong(id));
		resp.sendRedirect("/TodoApplication.jsp");
	}
	
	

}
