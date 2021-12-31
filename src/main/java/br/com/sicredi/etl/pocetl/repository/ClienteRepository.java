package br.com.sicredi.etl.pocetl.repository;

import br.com.sicredi.etl.pocetl.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}