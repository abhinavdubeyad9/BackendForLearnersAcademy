package Controllers.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controllers.DataController;

import Models.Student;
import Models.Teacher;
import Models.Subject;
import Models.MasterClass;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection;

	private DataController dataController;

	@Override
	public void init(ServletConfig sc) throws ServletException {

		super.init();
		ServletContext context = sc.getServletContext();
		// this will create a conneciton object which will help in controlling the data
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"),
					context.getInitParameter("dbUser"), context.getInitParameter("dbPassword"));

			dataController = new DataController(connection);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			// read the "command" parameter
			String command = request.getParameter("command");

			if (command == null) {
				command = "CLASSES";
			}

			// if no cookies
			if (!getCookies(request, response) && (!command.equals("LOGIN"))) {

				response.sendRedirect("/backend_For_learners_Academy/login.jsp");
			}

			else {

				// route the data to the appropriate method
				switch (command) {

				case "STUDENTS":
					studentsList(request, response);
					break;

				case "TEACHERS":
					teachersList(request, response);
					break;

				case "SUBJECTS":
					subjectList(request, response);
					break;

				case "CLASSES":
					classestList(request, response);
					break;

				case "CLASS_REPORT":
					classReport(request, response);
					break;

				default:
					response.sendRedirect("/backend_For_learners_Academy/login.jsp");

				}
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void studentsList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get students from db util
		List<Student> students = dataController.getStudents();

		// add students to the request
		request.setAttribute("STUDENT_LIST", students);

		// send it to the jsp view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/MasterStudent.jsp");
		dispatcher.forward(request, response);

	}

	private void teachersList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get students from db util
		List<Teacher> teachers = dataController.getTeachers();

		// add students to the request
		request.setAttribute("TEACHERS_LIST", teachers);

		// send it to the jSP view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/MasterTeacher.jsp");
		dispatcher.forward(request, response);

	}

	private void subjectList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get subjects from db util
		List<Subject> subjects = dataController.getSubjects();

		// add subjects to the request
		request.setAttribute("SUBJECTS_LIST", subjects);

		// send it to the jSP view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/MasterSubject.jsp");
		dispatcher.forward(request, response);

	}

	private void classestList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get subjects from db util
		List<MasterClass> classes = dataController.getClasses();

		// add subjects to the request
		request.setAttribute("CLASS_LIST", classes);

		// send it to the jSP view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ClassList.jsp");
		dispatcher.forward(request, response);

	}

	private void classReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get students from db util
		int classID = Integer.parseInt(request.getParameter("classId"));
		String name = request.getParameter("name");
		String time = request.getParameter("time");
		String subject = request.getParameter("subject");
		String teacher = request.getParameter("teacher");

		List<Student> students = dataController.getStudentsById(classID);

		// add students to the request
		request.setAttribute("STUDENTS_LIST", students);
		request.setAttribute("CLASSNAME", name);
		request.setAttribute("CLASSTIME", time);
		request.setAttribute("CLASSTEACHER", teacher);
		request.setAttribute("SUBJECT", subject);

		// send it to the jsp view page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ClassReport.jsp");
		dispatcher.forward(request, response);

	}

	private boolean getCookies(HttpServletRequest request, HttpServletResponse response) throws Exception {

		boolean flag = false;
		Cookie[] cookies = request.getCookies();
		// Find the cookie of interest in arrays of cookies
		for (Cookie cookie : cookies) {

			if (cookie.getName().equals("admin")) {
				flag = true;
				break;
			}

		}

		return flag;

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
