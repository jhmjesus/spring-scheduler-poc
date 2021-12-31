package br.com.sicredi.etl.pocetl.batch;

import br.com.sicredi.etl.pocetl.entity.Cliente;
import br.com.sicredi.etl.pocetl.service.ClienteService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DestinoClienteWriter implements ItemWriter<Cliente> {

    @Autowired
    private ClienteService service;

    @Override
    public void write(List<? extends Cliente> clientes) throws Exception {
        service.salvar((List<Cliente>) clientes);
    }
}