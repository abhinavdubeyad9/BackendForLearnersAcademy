package Models;

public class MasterClass {
	int id;
	String name;
	String time;
	String subjectName;
	String teacherName;

	public MasterClass(int id, String name, String time, String subjectName, String teacherName) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.subjectName = subjectName;
		this.teacherName = teacherName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

}
