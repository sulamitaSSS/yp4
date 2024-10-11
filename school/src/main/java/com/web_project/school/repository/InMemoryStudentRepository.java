package com.web_project.school.repository;

import com.web_project.school.model.StudentModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryStudentRepository {
    private List<StudentModel> students = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public List<StudentModel> findAllStudents() {
        return students.stream()
                .filter(student -> !student.isDeleted())
                .collect(Collectors.toList());
    }

    public StudentModel addStudent(StudentModel student) {
        student.setId(idCounter.getAndIncrement());
        students.add(student);
        return student;
    }

    public StudentModel updateStudent(StudentModel student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()){
                students.set(i, student);
                return student;
            }
        }
        return null;
    }

    public void deleteStudent(int id) {
        for (StudentModel student : students) {
            if (student.getId() == id) {
                student.setDeleted(true); // Логическое удаление
                break;
            }
        }
    }

    public void hardDeleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public StudentModel findStudentById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id && !student.isDeleted())
                .findFirst()
                .orElse(null);
    }

    public List<StudentModel> findByLastName(String lastName) {
        return students.stream()
                .filter(student -> !student.isDeleted() && lastName.equals(student.getLastName()))
                .collect(Collectors.toList());
    }

    public List<StudentModel> findByFirstName(String firstName) {
        return students.stream()
                .filter(student -> !student.isDeleted() && firstName.equals(student.getFirstName()))
                .collect(Collectors.toList());
    }

    public List<StudentModel> findByCorpEmail(String corpEmail) {
        return students.stream()
                .filter(student -> !student.isDeleted() && corpEmail.equals(student.getCorpEmail()))
                .collect(Collectors.toList());
    }
    public List<StudentModel> findByFirstNameAndLastNameAndCorpEmail(String firstName, String lastName, String corpEmail) {
        return students.stream()
                .filter(student -> !student.isDeleted() &&
                        (firstName == null || firstName.equals(student.getFirstName())) &&
                        (lastName == null || lastName.equals(student.getLastName())) &&
                        (corpEmail == null || corpEmail.equals(student.getCorpEmail())))
                .collect(Collectors.toList());
    }
}
