package ru.talismanandco.jobhelpercore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.talismanandco.jobhelpercore.entity.SkillEntity;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity,Long> {

}
