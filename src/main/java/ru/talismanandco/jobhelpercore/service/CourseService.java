package ru.talismanandco.jobhelpercore.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.talismanandco.jobhelpercore.entity.CourseEntity;
import ru.talismanandco.jobhelpercore.entity.SkillEntity;
import ru.talismanandco.jobhelpercore.repository.SkillRepository;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {
    private final SkillRepository skillRepository;

    /**
     * Найти курсы по скиллу
     *
     * @param skillTitle название скилла
     * @return список курсов. Если не удастся найти, вернется пустое множество
     */
    public Set<CourseEntity> getCoursesBySkill(@Nullable String skillTitle) {
        Optional<SkillEntity> maybeSkillEntity = Optional.ofNullable(skillTitle)
                .filter(s -> !s.isEmpty())
                .map(String::toLowerCase)
                .flatMap(skillRepository::findByTitle);

        if (maybeSkillEntity.isPresent()) {
            Set<CourseEntity> courses = maybeSkillEntity.get().getCourseEntities();
            log.info("Found {} courses with skill '{}'", courses.size(), skillTitle);
            return courses;
        } else {
            log.info("Courses for skill '{}' was not found", skillTitle);
            return Collections.emptySet();
        }
    }
}
