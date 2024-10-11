package com.web_project.school.service;

import com.web_project.school.model.StudentModel;

import java.util.List;

public interface StudentService {
    public List<StudentModel> findAllStudents();

    public StudentModel findStudentById(int id);

    public StudentModel addStudent(StudentModel student);

    public StudentModel updateStudent(StudentModel student);

    void deleteStudent(int id);

    void hardDeleteStudent(int id);

    List<StudentModel> findByLastName(String lastName);

    List<StudentModel> findByFirstName(String firstName);

    List<StudentModel> findByCorpEmail(String corpEmail);

    List<StudentModel> findByFirstNameAndLastNameAndCorpEmail(String firstName, String lastName, String corpEmail);
}

