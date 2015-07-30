package model;

public class CourseBO {
	//private int id;
	private String name;
	private int nrStudents;

	

	public CourseBO() {

	}

	public CourseBO(String name, int nrStudents) {
		this.name = name;
		this.nrStudents = nrStudents;
	}

//	public int getId() {
//		return id;
//	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNrStudents() {
		return nrStudents;
	}

	public void setNrStudents(int nrStudents) {
		this.nrStudents = nrStudents;
	}

	public String toString() {
		return this.name + " " + this.nrStudents;
	}

}
