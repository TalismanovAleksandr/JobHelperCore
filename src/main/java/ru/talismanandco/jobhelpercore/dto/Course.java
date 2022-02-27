package ru.talismanandco.jobhelpercore.dto;

import lombok.Data;

@Data
public class Course {
    private String name;
    //TODO для EPAM не получилось заполнить может быть надо будет удалить
    private String description;
    private CourseSource courseSource;
    private String url;
    private String difficultyLevel;
    private String hashTags;
}
