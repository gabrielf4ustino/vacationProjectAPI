package com.vacation.project.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "basic", schema = "public", catalog = "vacation_project")
public class BasicInfoModel {

    @Id
    private Integer id;

    private String titleType;

    private String primaryTitle;

    private String originalTitle;

    private Boolean isAdult;

    private String startYear;

    private String endYear;

    private String runtimeMinutes;

    private String genres;

    @OneToOne(targetEntity = RatingModel.class)
    private RatingModel rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BasicInfoModel basicInfoModel = (BasicInfoModel) o;
        return id != null && Objects.equals(id, basicInfoModel.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
