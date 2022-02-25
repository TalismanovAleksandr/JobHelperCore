package ru.talismanandco.jobhelpercore.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "skill")
public class SkillEntity {
    //toString вызывает lazy load
    @ToString.Exclude
    @ManyToMany(mappedBy = "skillEntities")
    Set<CourseEntity> courseEntities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
}
