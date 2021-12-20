package br.com.moser.repository;

import br.com.moser.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Juliano Moser
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
