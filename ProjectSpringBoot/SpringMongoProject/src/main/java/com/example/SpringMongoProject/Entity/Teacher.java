package com.example.SpringMongoProject.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teachers") 
public class Teacher {

    @Id
    private String _id;
    private String teacherName;
    private String teacherSubject;
    private String teacherEmail;

    // Constructors
    public Teacher(String _id, String teacherName, String teacherSubject, String teacherEmail) {
        this._id = _id;
        this.teacherName = teacherName;
        this.teacherSubject = teacherSubject;
        this.teacherEmail = teacherEmail;
    }

    public Teacher() {
        // Empty Constructor
    }

    // Getters and Setters
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(String teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    // Methods
    @Override
    public String toString() {
        return "Teacher [_id=" + _id + ", teacherName=" + teacherName + ", teacherSubject=" + teacherSubject
                + ", teacherEmail=" + teacherEmail + ", get_id()=" + get_id() + ", getTeacherName()="
                + getTeacherName() + ", getTeacherSubject()=" + getTeacherSubject() + ", getTeacherEmail()="
                + getTeacherEmail() + "]";
    }
}
