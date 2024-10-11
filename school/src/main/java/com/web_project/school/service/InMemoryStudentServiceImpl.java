package com.web_project.school.service;


import com.web_project.school.model.StudentModel;
import com.web_project.school.repository.InMemoryStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryStudentServiceImpl implements StudentService{
    private final InMemoryStudentRepository studentRepository;

    public InMemoryStudentServiceImpl(InMemoryStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> findAllStudents(){
        return studentRepository.findAllStudents();
    }

    @Override
    public StudentModel findStudentById(int id) {
        return studentRepository.findStudentById(id);
    }

    @Override
    public StudentModel addStudent(StudentModel student){
        return studentRepository.addStudent(student);
    }

    @Override
    public StudentModel updateStudent(StudentModel student){
        return studentRepository.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id){
        studentRepository.deleteStudent(id);
    }

    @Override
    public void hardDeleteStudent(int id) {
        studentRepository.hardDeleteStudent(id);
    }

    @Override
    public List<StudentModel> findByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    @Override
    public List<StudentModel> findByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public List<StudentModel> findByCorpEmail(String corpEmail) {
        return studentRepository.findByCorpEmail(corpEmail);
    }

    @Override
    public List<StudentModel> findByFirstNameAndLastNameAndCorpEmail(String firstName, String lastName, String corpEmail) {
        return studentRepository.findByFirstNameAndLastNameAndCorpEmail(firstName, lastName, corpEmail);
    }

}
