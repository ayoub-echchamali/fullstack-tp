package fr.polytech.backend.repository;

import fr.polytech.backend.entity.RestoEntity;
import fr.polytech.backend.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
    List<ReviewEntity> findAllByResto(RestoEntity resto);
}
