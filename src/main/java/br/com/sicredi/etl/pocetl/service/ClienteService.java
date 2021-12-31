package br.com.sicredi.etl.pocetl.service;

import br.com.sicredi.etl.pocetl.entity.Cliente;
import br.com.sicredi.etl.pocetl.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional(transactionManager = "destinoTransactionManager")
    public void salvar(List<Cliente> clientes) {
        repository.saveAll(clientes);
    }
}