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
@Entity(name = "course")
public class CourseEntity {
    //toString вызывает lazy load
    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "course_skill",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    Set<SkillEntity> skillEntities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean free;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_source_id")
    private CourseSourceEntity courseSource;
}
