package fr.polytech.backend.repository;

import fr.polytech.backend.entity.BiblioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiblioRepository extends JpaRepository<BiblioEntity, Integer> {
}
