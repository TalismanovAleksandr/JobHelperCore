package ru.talismanandco.jobhelpercore.service;

import ru.talismanandco.jobhelpercore.dto.Course;

import java.util.List;

public interface LearnEpamParserService {
    List<Course> execute();
}
