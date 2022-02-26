package ru.talismanandco.jobhelpercore.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseEntity)) return false;
        CourseEntity that = (CourseEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(title, that.title)
                && Objects.equals(link, that.link)
                && Objects.equals(description, that.description)
                && Objects.equals(free, that.free)
                && Objects.equals(courseSource, that.courseSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, link, description, free, courseSource);
    }
}
