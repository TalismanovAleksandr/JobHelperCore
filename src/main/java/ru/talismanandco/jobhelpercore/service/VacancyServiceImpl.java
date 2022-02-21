package ru.talismanandco.jobhelpercore.service;

import org.springframework.stereotype.Service;
import ru.talismanandco.jobhelpercore.entity.VacancyEntity;
import ru.talismanandco.jobhelpercore.repository.VacancyRepository;

import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService {
    private final VacancyRepository vacancyRepository;

    public VacancyServiceImpl(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @Override
    public VacancyEntity save(VacancyEntity vacancy) {
        return vacancyRepository.save(vacancy);
    }

    @Override
    public void delete(VacancyEntity vacancy) {
        vacancyRepository.delete(vacancy);
    }

    @Override
    public void delete(Long id) {
        vacancyRepository.deleteById(id);
    }

    @Override
    public List<VacancyEntity> getAll() {
        return vacancyRepository.findAll();
    }

    @Override
    public List<VacancyEntity> getWithFilters() {
        //Specification??
        return null;
    }
}
