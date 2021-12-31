package br.com.sicredi.etl.pocetl.batch.job;

import br.com.sicredi.etl.pocetl.batch.DestinoClienteWriter;
import br.com.sicredi.etl.pocetl.batch.OrigemPessoaReader;
import br.com.sicredi.etl.pocetl.entity.Cliente;
import br.com.sicredi.etl.pocetl.entity.Pessoa;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class BatchJob {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private OrigemPessoaReader origemReader;

    @Autowired
    private DestinoClienteWriter clienteWriter;

    @Autowired
    private ClienteCleanTask cleanTask;

    @Autowired
    @Qualifier(value = "converterProcessor")
    private ItemProcessor<Pessoa, Cliente> converterProcessor;

    @Bean
    public Job jobPessoa() {
        return jobBuilderFactory
                .get("jobPessoa")
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .next(step2())
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory
                .get("step1")
                .tasklet(cleanTask)
                .build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory
                .get("step2")
                .<Pessoa, Cliente>chunk(4)
                .reader(origemReader)
                .processor(converterProcessor)
                .writer(clienteWriter)
                .build();
    }
}
