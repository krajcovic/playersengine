/**
 * 
 */
package cz.krajcovic.playersengine.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import cz.krajcovic.playersengine.server.dao.Dao;

/**
 * @author krajcovic
 * 
 */
public class ServletCreateTodo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1770669540113073789L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Creating new todo ");
		User user = (User) req.getAttribute("user");
		if (user == null) {
			UserService userService = UserServiceFactory.getUserService();
			user = userService.getCurrentUser();
		}

		String summary = checkNull(req.getParameter("summary"));
		String description = checkNull(req.getParameter("description"));
		String url = checkNull(req.getParameter("url"));

		Dao.INSTANCE.add(user.getUserId(), summary, description, url);

		resp.sendRedirect("/TodoApplication.jsp");
	}

	private String checkNull(String parameter) {
		if (parameter == null) {
			return "";
		} else {
			return parameter;
		}
	}

}
