package ru.talismanandco.jobhelpercore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.talismanandco.jobhelpercore.entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

}
