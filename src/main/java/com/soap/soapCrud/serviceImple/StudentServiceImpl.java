package com.soap.soapCrud.serviceImple;

import com.soap.soapCrud.general.bean.Student;
import com.soap.soapCrud.general.repository.IStudentRepository;
import com.soap.soapCrud.general.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService{
@Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        List<Student> list = new ArrayList<>();
        studentRepository.findAll().forEach(e->list.add(e));
        return list;
    }


    @Override
    public Student getStudentById(Integer studentId) {
        Student student = studentRepository.findStudentById(studentId);
        return student;
    }

    @Override
    public boolean addStudent(Student student) {
        List<Student> checkStudentExists = studentRepository.findStudentByFnameOrLnameOrAge(student.getFname(),student.getLname(),student.getAge());
        if(checkStudentExists.size() > 0){
            return false;
        }else{
          studentRepository.save(student);
            return true;
        }
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }
}
