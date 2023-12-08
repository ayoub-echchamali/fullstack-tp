package fr.polytech.backend.repository;

import fr.polytech.backend.entity.LivreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends JpaRepository<LivreEntity, Integer> {
}
