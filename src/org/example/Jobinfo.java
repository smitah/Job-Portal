package org.example;

public class Jobinfo {
	
	private String Title;
	private String Skills;
	private String Category;
	private int Positions;
	private String Job_id;
	private String Manager_id;
	
	public String getJob_id() {
		return Job_id;
	}
	public void setJob_id(String job_id) {
		Job_id = job_id;
	}
	public String getManager_id() {
		return Manager_id;
	}
	public void setManager_id(String manager_id) {
		Manager_id = manager_id;
	}
	public int getPositions() {
		return Positions;
	}
	public void setPositions(int positions) {
		Positions = positions;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getSkills() {
		return Skills;
	}
	public void setSkills(String skills) {
		Skills = skills;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	private String Type;
	private String preference;
	

}
