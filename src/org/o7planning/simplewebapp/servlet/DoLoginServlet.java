package org.o7planning.simplewebapp.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.o7planning.simplewebapp.beans.UserAccount;
import org.o7planning.simplewebapp.utils.DBUtils;
import org.o7planning.simplewebapp.utils.MyUtils;

/**
 * Servlet implementation class DoLoginServlet
 */
@WebServlet(urlPatterns = {"/doLogin"})
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String rememberMeStr = request.getParameter("remeberMe");
		boolean remeber = "Y".equals(rememberMeStr);
		
		UserAccount userAccount = null;
		boolean hasError = false;
		String errorString = null;
		
		if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
			hasError = true;
			errorString = "requied enter userName and password!";
		} else {
			Connection conn = MyUtils.getStoredConnection(request);
			try {
				//tìm trong DB
				userAccount = DBUtils.findUser(conn, userName, password);
				if (userAccount == null) {
					hasError = true;
					errorString = "userName or password invalid";
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}		
		
		//If error, forward to /WEB_INF/views/loginView.jsp
		if (hasError) {
			userAccount = new UserAccount();
			userAccount.setUserName(userName);
			userAccount.setPassword(password);
			
			//stored information to Attribute before forward /WEB_INF/views/loginView.jsp
			request.setAttribute("error", errorString);
			request.setAttribute("user", userAccount);
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB_INF/views/loginView.jsp");
			dispatcher.forward(request, response);
		}
		//[IN CASE] not error
		//stored information in session
		//redirect to user info page
		else {
			HttpSession session = request.getSession();
			MyUtils.storeLoginedUser(session, userAccount);
			
			//If user check remember
			if (remeber) {
				MyUtils.storeUserCookie(response, userAccount);
			} else {
				MyUtils.deleteUserCookie(response);
			}
			
			//redirected to User Info Page
			response.sendRedirect(request.getContextPath() + "userInfo");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
