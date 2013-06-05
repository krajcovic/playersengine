<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="cz.krajcovic.playersengine.server.dao.Dao"%>
<%@ page import="cz.krajcovic.playersengine.server.model.Todo"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Todos</title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<meta charset="utf-8">
</head>
<body>
	<%
		Dao dao = Dao.INSTANCE;

		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();

		String url = userService.createLoginURL(request.getRequestURI());
		String urlLinkText = "Login";
		List<Todo> todos = new ArrayList<Todo>();

		if (user != null) {
			url = userService.createLogoutURL(request.getRequestURI());
			urlLinkText = "Logout";
			todos = dao.getTodos(user.getUserId());
		}
	%>
	<div style="width: 100%;">
		<div class="line"></div>
		<div class="topLine">
			<div style="float: left;">
				<img src="images/todo.png" />
			</div>
			<div style="float: left;" class="headline">Todos</div>
			<div style="float: right;">
				<a href="<%=url%>"><%=urlLinkText%></a>
				<%=(user == null ? "" : user.getNickname())%></div>
		</div>
	</div>

	<div style="clear: both;" />
	You have a total number of
	<%=todos.size()%>
	Todos.

	<table>
		<tr>
			<th>Short description</th>
			<th>Long Description</th>
			<th>URL</th>
			<th>Done</th>
		</tr>

		<%
			for (Todo todo : todos) {
		%>
		<tr>
			<td><%=todo.getSummary()%></td>
			<td><%=todo.getDescription()%></td>
			<td><%=todo.getUrl()%></td>
			<td><a class="done" href="/done?id=<%=todo.getId()%>">Done</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>


	<hr />

	<div class="main">

		<div class="headline">New todo</div>

		<%
			if (user != null) {
		%>

		<form action="/new" method="post" accept-charset="utf-8">
			<table>
				<tr>
					<td><label for="summary">Summary</label></td>
					<td><input type="text" name="summary" id="summary" size="65" /></td>
				</tr>
				<tr>
					<td valign="description"><label for="description">Description</label></td>
					<td><textarea rows="4" cols="50" name="description"
							id="description"></textarea></td>
				</tr>
				<tr>
					<td valign="top"><label for="url">URL</label></td>
					<td><input type="url" name="url" id="url" size="65" /></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						value="Create" /></td>
				</tr>
			</table>
		</form>

		<%
			} else {
		%>

		Please login with your Google account

		<%
			}
		%>
	</div>
</body>
</html>