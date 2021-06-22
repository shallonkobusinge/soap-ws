package com.soap.soapCrud.general.repository;

import com.soap.soapCrud.general.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer>{
    Student findStudentById(Integer studentId);
    List<Student> findStudentByFnameOrLnameOrAge(String fname, String lname, Integer age);

}
