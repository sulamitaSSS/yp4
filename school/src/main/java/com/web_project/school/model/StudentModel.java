package com.web_project.school.model;

import jakarta.annotation.Nullable;

public class StudentModel {
    private int Id;
    private String Name;
    private String FirstName;
    @Nullable
    private String LastName;
    @Nullable
    private String CorpEmail;
    private boolean isDeleted; // Флаг для логического удаления

    public StudentModel(int id, String name, String firstName, @Nullable String lastName, @Nullable String corpEmail) {
        Id = id;
        Name = name;
        FirstName = firstName;
        LastName = lastName;
        CorpEmail = corpEmail;
        this.isDeleted = false; // По умолчанию студент не удален
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    @Nullable
    public String getLastName() {
        return LastName;
    }

    public void setLastName(@Nullable String lastName) {
        LastName = lastName;
    }

    @Nullable
    public String getCorpEmail() {
        return CorpEmail;
    }

    public void setCorpEmail(@Nullable String corpEmail) {
        CorpEmail = corpEmail;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

}
