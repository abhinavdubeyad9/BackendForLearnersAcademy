package Models;

public class Teacher {
     private int id;
     private String name;
     private int experience;
     private String expertise;
     
     public Teacher(int id, String name, int experience, String expertise) {
    	 this.setId(id);
    	 this.setName(name);
    	 this.setExperience(experience);
    	 this.setExpertise(expertise);
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

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
     
  
}
