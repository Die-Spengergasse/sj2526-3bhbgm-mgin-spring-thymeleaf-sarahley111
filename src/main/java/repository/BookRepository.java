package at.spengergasse.spring_thymeleaf.repository;

import at.spengergasse.spring_thymeleaf.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}