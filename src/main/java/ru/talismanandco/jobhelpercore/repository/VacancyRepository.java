package ru.talismanandco.jobhelpercore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.talismanandco.jobhelpercore.entity.VacancyEntity;

@Repository
public interface VacancyRepository extends JpaRepository<VacancyEntity,Long> {

}
