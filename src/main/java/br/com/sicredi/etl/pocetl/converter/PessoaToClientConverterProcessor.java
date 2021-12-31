package br.com.sicredi.etl.pocetl.converter;

import br.com.sicredi.etl.pocetl.entity.Cliente;
import br.com.sicredi.etl.pocetl.entity.Pessoa;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component(value = "converterProcessor")
class PessoaToClienteConverterProcessor implements ItemProcessor<Pessoa, Cliente> {
    public Cliente process(Pessoa pessoa) throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(pessoa.getId());
        cliente.setNome(pessoa.getNome());
        return cliente;
    }
}