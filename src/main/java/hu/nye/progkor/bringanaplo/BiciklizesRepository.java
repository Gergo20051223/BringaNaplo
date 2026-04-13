package hu.nye.progkor.bringanaplo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiciklizesRepository extends JpaRepository<Biciklizes, Long> {
}