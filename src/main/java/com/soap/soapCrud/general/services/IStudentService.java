package com.soap.soapCrud.general.services;

import com.soap.soapCrud.general.bean.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudent();
    Student getStudentById(Integer studentId);
    boolean addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);
}
