package cz.krajcovic.playersengine.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class JsonPlayer extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4814046561244258327L;

	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String playerId = req.getParameter("id");
		Entity player = new Entity("Player", playerId);

		PrintWriter out = resp.getWriter();
		JSONObject data = new JSONObject();
		try {
			data.put("playerId", Integer.valueOf(playerId));
			data.put("secondName", player.getProperty("secondName"));
			data.put("firstName", player.getProperty("firstName"));
			data.put("description", player.getProperty("description"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.print(data.toString());
		// super.doGet(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Entity player;
		String playerId = req.getParameter("id");
		if (playerId == null || playerId.isEmpty()) {
			// create
			player = new Entity("Player");
		} else {
			// update
			player = new Entity("Player", playerId);
		}

		player.setProperty("secondName", req.getParameter("secondName"));
		player.setProperty("firstName", req.getParameter("firstName"));
		player.setProperty("description", req.getParameter("description"));

		// super.doPut(req, resp);
		datastore.put(player);
	}
}
