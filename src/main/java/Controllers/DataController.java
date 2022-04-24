package Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;

import Models.Student;
import Models.Teacher;
import Models.Subject;
import Models.MasterClass;

public class DataController {

	private Connection connection;

	public DataController(Connection connection) {
		this.connection = connection;
	}

	public List<Student> getStudents() {

		List<Student> students = new ArrayList<>();
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// create sql statement
			String sql = "SELECT * FROM student";
			myStmt = connection.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("SRollNo");
				String name = myRs.getString("Name");

				// create new student object
				Student tempStudent = new Student(id, name);

				// add it to the list of students
				students.add(tempStudent);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myStmt, myRs);
		}
		return students;

	}

	public List<Teacher> getTeachers() {

		List<Teacher> teachers = new ArrayList<>();
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			// create sql statement
			String sql = "SELECT * FROM teacher";
			myStmt = connection.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("Tid");
				String name = myRs.getString("Name");
				int experience = myRs.getInt("Experience");
				String expertise = myRs.getString("Expertise");

				// create new student object
				Teacher temp = new Teacher(id, name, experience, expertise);

				// add it to the list of students
				teachers.add(temp);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myStmt, myRs);
		}
		return teachers;

	}

	public List<Subject> getSubjects() {

		List<Subject> subjects = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// create sql statement
			String sql = "SELECT * FROM subject";
			myStmt = connection.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("SubId");
				String name = myRs.getString("Name");
				String level = myRs.getString("Level");

				// create new student object
				Subject temp = new Subject(id, name, level);

				// add it to the list of students
				subjects.add(temp);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myStmt, myRs);
		}
		return subjects;

	}

	public List<MasterClass> getClasses() {

		List<MasterClass> classes = new ArrayList<>();
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			// create sql statement
			String sql = "SELECT * FROM class";
			myStmt = connection.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("Cid");
				String name = myRs.getString("name");
				String time = myRs.getString("time");
				int subjectId = myRs.getInt("SubId");
				int teacherId = myRs.getInt("Tid");

				String teacherName = getTeacherById(teacherId);
				String subjectName = getSubjectById(subjectId);

				// create new student object
				MasterClass temp = new MasterClass(id, name, time, subjectName, teacherName);

				// add it to the list of students
				classes.add(temp);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myStmt, myRs);
		}

		return classes;

	}

	public String getTeacherById(int teacherId) {
		String teacher = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			// create sql statement
			String sql = "SELECT * FROM teacher WHERE Tid = " + teacherId;
			myStmt = connection.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {
				// get the name
				String name = myRs.getString("Name");
				// assign the name to teacher string;
				teacher = name;
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myStmt, myRs);
		}
		return teacher;

	}

	public String getSubjectById(int subjectId) {
		String subject = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			// create sql statement
			String sql = "SELECT * FROM subject WHERE SubId = " + subjectId;
			myStmt = connection.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {
				// get the name
				String name = myRs.getString("Name");
				// assign the name to teacher string;
				subject = name;
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myStmt, myRs);
		}
		return subject;

	}

	public List<Student> getStudentsById(int id) {

		List<Student> students = new ArrayList<>();
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// create sql statement
			String sql = "SELECT * FROM student where classID = " + id;
			myStmt = connection.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result
			while (myRs.next()) {

				// retrieve data from result set row
				int studentId = myRs.getInt("SRollNo");
				String name = myRs.getString("Name");

				// create new student object
				Student tempStudent = new Student(studentId, name);

				// add it to the list of students
				students.add(tempStudent);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(myStmt, myRs);
		}
		return students;

	}

	private void close(Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
