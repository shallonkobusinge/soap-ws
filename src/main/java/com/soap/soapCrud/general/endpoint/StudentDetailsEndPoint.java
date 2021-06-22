package com.soap.soapCrud.general.endpoint;

import com.soap.soapCrud.general.bean.Student;
import com.soap.soapCrud.general.repository.IStudentRepository;
import com.soap.soapCrud.serviceImple.StudentServiceImpl;
import com.soap.soapCrud.soap.students.StudentDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import output.*;

import java.util.ArrayList;
import java.util.List;


@Endpoint
public class StudentDetailsEndPoint {

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private StudentServiceImpl studentService;

    @PayloadRoot(namespace = "http://example.ac.rw/soap/students", localPart = "GetStudentRequest")
    @ResponsePayload
    public GetStudentResponse getStudent(@RequestPayload GetStudentRequest request) {
        GetStudentResponse response = new GetStudentResponse();
        StudentInfo studentInfo = new StudentInfo();
        BeanUtils.copyProperties(studentService.getStudentById(request.getId()), studentInfo);
        response.setStudentInfos(studentInfo);
        return response;
    }

    @PayloadRoot(namespace = "http://example.ac.rw/soap/students", localPart = "GetAllStudentsRequest")
    @ResponsePayload
    public GetAllStudentsResponse getAllStudents() {
        GetAllStudentsResponse allStudentsResponse = new GetAllStudentsResponse();

        List<Student> students = studentService.getAllStudent();
        for(Student student: students){
            GetStudentResponse studentResponse = mapStudentInfo(student);
            allStudentsResponse.getStudentInfo().add(studentResponse.getStudentInfos());
        }
        return allStudentsResponse;
    }

    private GetStudentResponse mapStudentInfo(Student student) {
        StudentInfo studentInfo = mapStudent(student);

        GetStudentResponse studentResponse = new GetStudentResponse();

        studentResponse.setStudentInfos(studentInfo);
        return studentResponse;
    }

    private StudentInfo mapStudent(Student student) {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setStudentId(student.getId());
        studentInfo.setFname(student.getFname());
        studentInfo.setLname(student.getLname());
        studentInfo.setAge(student.getAge());
        return studentInfo;
    }

    @PayloadRoot(namespace = "http://example.ac.rw/soap/students", localPart = "addStudentRequest")
    @ResponsePayload
    public AddStudentResponse addStudent(@RequestPayload AddStudentRequest request) {
        AddStudentResponse response = new AddStudentResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        Student student = new Student();
        student.setFname(request.getFname());
        student.setLname(request.getLname());
        student.setAge(request.getAge());
        boolean flag = studentService.addStudent(student);
        if (flag == false) {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Content Already Available");
            response.setServiceStatus(serviceStatus);
        } else {
            StudentInfo studentInfo = new StudentInfo();
            BeanUtils.copyProperties(student, studentInfo);
            response.setStudentInfo(studentInfo);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Added Successfully");
            response.setServiceStatus(serviceStatus);
        }
        return response;
    }

    @PayloadRoot(namespace = "http://example.ac.rw/soap/students", localPart = "updateStudentRequest")
    @ResponsePayload
    public UpdateStudentResponse updateStudent(@RequestPayload UpdateStudentRequest request) {
        Student student = new Student();
        BeanUtils.copyProperties(request.getStudentInfo(), student);
        studentService.updateStudent(student);
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatusCode("SUCCESS");
        serviceStatus.setMessage("Content Updated Successfully");
        UpdateStudentResponse response = new UpdateStudentResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }
    @PayloadRoot(namespace = "http://example.ac.rw/soap/students", localPart = "deleteStudentRequest")
    @ResponsePayload
    public DeleteStudentResponse deleteStudent(@RequestPayload DeleteStudentRequest request) {
        Student student = studentService.getStudentById(request.getStudentId());
        ServiceStatus serviceStatus = new ServiceStatus();
        if (student == null ) {
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Content Not Available");
        } else {
            studentService.deleteStudent(student);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Deleted Successfully");
        }
        DeleteStudentResponse response = new DeleteStudentResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }
}
