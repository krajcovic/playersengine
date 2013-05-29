package cz.krajcovic.playersengine.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class JsonPlayerDetail extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -916515515181949644L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		String[] playerIds = req.getParameter("id").split(" ");
		for (String playerId : playerIds) {
			// TODO: tady dodelat vracena data.
			JSONObject data = new JSONObject();
			try {
				data.put("playerId", Integer.valueOf(playerId));
				data.put("created", new Date());
				data.put("weight", (new Random()).nextInt(100) + 50);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			out.print(data.toString());
		}

		// // TODO Auto-generated method stub
		// super.doGet(req, resp);
	}

}
