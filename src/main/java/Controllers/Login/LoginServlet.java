package Controllers.Login;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/loginServlet", loadOnStartup = 0)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
    
	public void init(ServletConfig sc) {
		System.out.println("initializing loginServlet...");
		ServletContext context = sc.getServletContext();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"), 
					context.getInitParameter("dbUser"), 
					context.getInitParameter("dbPassword"));
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user where email = '" + email + "' and password='" + password + "'");
			if(rs.next()) {
				//successful login
				Cookie cookie = new Cookie("admin", email);

				// Setting the maximum age to 1 day
				cookie.setMaxAge(86400); // 86400 seconds in a day

				// Send the cookie to the client
				response.addCookie(cookie);
	
				request.setAttribute("email", email);
				RequestDispatcher rd = request.getRequestDispatcher("/homePage.jsp");
				rd.forward(request, response);	
			}else {
				// unsuccessful login - incorrect email or incorrect password
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}	

	public void destroy() {
		try {
			if (connection != null) {
				connection.close();
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
