package br.com.moser.repository;

import br.com.moser.model.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Juliano Moser
 */
public interface CambioRepository extends JpaRepository<Cambio, Long> {

    Cambio findByFromAndTo(String from, String to);
}
