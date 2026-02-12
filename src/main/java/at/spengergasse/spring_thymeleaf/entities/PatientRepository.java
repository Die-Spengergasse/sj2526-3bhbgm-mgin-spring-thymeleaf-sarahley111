package at.spengergasse.spring_thymeleaf.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
// interface, damit Spring automatisch die Methoden für die Datenbankzugriffe generieren kann
// JpaRepository<Patient,Integer> -> generische Typen, damit Spring weiß, welche Ent