package cz.krajcovic.playersengine.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;

import cz.krajcovic.playersengine.base.Player;

public class JsonPlayer extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4814046561244258327L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String playerId = req.getParameter("id");
		Entity player = new Entity("Player", playerId);

		super.doGet(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String playerId = req.getParameter("id");
		if (playerId.isEmpty()) {
			// create
			Entity player = new Entity("Player");
		} else {
			// update
			Entity player = new Entity("Player", playerId);
		}

		super.doPut(req, resp);
	}

}
