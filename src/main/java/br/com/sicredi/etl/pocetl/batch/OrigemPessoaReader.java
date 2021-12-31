package br.com.sicredi.etl.pocetl.batch;

import br.com.sicredi.etl.pocetl.entity.Pessoa;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

@Component
public class OrigemPessoaReader extends JpaPagingItemReader<Pessoa> {

    @Autowired
    public OrigemPessoaReader(
            @Qualifier(value = "origemEntityManagerFactory")
                    EntityManagerFactory entityManagerFactory)
            throws Exception {
        setQueryString("SELECT P FROM Pessoa P");
        setEntityManagerFactory(entityManagerFactory);
        setPageSize(1000);
        afterPropertiesSet();
        setSaveState(true);
    }
}