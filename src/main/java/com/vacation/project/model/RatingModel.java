package com.vacation.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "ratings", schema = "public", catalog = "vacation_project")
public class RatingModel {

    @Id
    private Integer id;

    private Float averageRating;

    private Integer numVotes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RatingModel ratingModel = (RatingModel) o;
        return id != null && Objects.equals(id, ratingModel.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
