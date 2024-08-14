package com.flipkart.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author JEDI-03
 * Class to store Professor information, inheriting from User
 * 
 */
public class Professor extends User{

    private String dept;
    private String qualification;
    private String name;
    private String password;
    private String contact;
    private String email;
    private String id;
    //private Map<Course, Set<Student>> courseStudentMap; // Map of courses to enrolled students
    private List<String> courses;
    /**
     * Parameterized constructor
     * @param ID: the professor ID
     * @param name: the professor's name
     * @param contact: the professor's contact information
     * @param email: the professor's email
     * @param dept: department of the professor
     * @param qualification: qualification of the professor
     */
    public Professor(@JsonProperty("ID") String ID, @JsonProperty("name") String name, @JsonProperty("contact") String contact,
                     @JsonProperty("email") String email, @JsonProperty("dept") String dept,
                     @JsonProperty("qualification") String qualification,
                     @JsonProperty("password") String password) {
        super(ID, name, "Professor", contact, email, password);
        this.dept = dept;
        this.qualification = qualification;
        this.courses= new ArrayList<String>(100);
    }

    // Getters and Setters for dept and qualification
//    @JsonProperty("dept")
    public String getDept() {
        return dept;
    }

//    @JsonProperty("dept")
    public void setDept(String dept) {
        this.dept = dept;
    }

//    @JsonProperty("id")
    public void setID(String id){
        this.id = id;
    }
//    @JsonProperty("id")
    public String getID(){
        return this.id;
    }

//    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
//    @JsonProperty("name")
    public String getame() {
        return name;
    }


//    @JsonProperty("contact")
    public void setContact(String contact) {
        this.contact = contact;
    }
//    @JsonProperty("contact")
    public String getContact() {
        return contact;
    }

//    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }
//    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

//    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }
//    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

//    @JsonProperty("qualification")
    public String getQualification() {
        return qualification;
    }

//    @JsonProperty("qualification")
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    
    public List<String> getCourses() {
    	return this.courses;
    }
    
    //@Override
    public void update() {
        // Code to update professor information
    }

    //@Override
    public void changePassword(String password) {
        // Code to change professor password
    	super.setPassword(password);
    }
    
    public void addCourse(String courseID) {
    	this.courses.add(courseID);
    }
}
