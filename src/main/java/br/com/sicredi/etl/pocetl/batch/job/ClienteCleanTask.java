package br.com.sicredi.etl.pocetl.batch.job;

import br.com.sicredi.etl.pocetl.repository.ClienteRepository;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteCleanTask implements Tasklet {

    @Autowired
    private ClienteRepository repositorio;

    public RepeatStatus execute(StepContribution contribution,
                                ChunkContext chunkContext) throws Exception {
        repositorio.deleteAll();
        return RepeatStatus.FINISHED;
    }
}
