package dao.model;

public class Course {
	private String id;
	private String name;
	private int nrStudents;
	private int isDeleted;

	public Course(String id, String name, int nrStudents, int isDeleted) {
		this.id = id;
		this.name = name;
		this.nrStudents = nrStudents;
		this.isDeleted = isDeleted;
	}

	public Course() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
		return this.id + " " + this.name + " " + this.nrStudents;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

}
