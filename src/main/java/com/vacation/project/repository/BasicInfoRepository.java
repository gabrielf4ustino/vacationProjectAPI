package com.vacation.project.repository;

import com.vacation.project.model.BasicInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BasicInfoRepository extends JpaRepository<BasicInfoModel, Integer> {

    @Query("SELECT b FROM BasicInfoModel b INNER JOIN RatingModel r ON b.rating.id = r.id WHERE b.startYear >= ?1 AND b.titleType = 'movie' AND r.id - 10000 < ?2 AND r.id + 10000 > ?2 ORDER BY r.averageRating DESC, r.numVotes desc LIMIT 10")
    Optional<List<BasicInfoModel>> findByStartYear(String year, Integer randomNumber);
}
