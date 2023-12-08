package fr.polytech.backend.repository;

import fr.polytech.backend.entity.RestoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestoRepository extends JpaRepository<RestoEntity, Integer> {
}
