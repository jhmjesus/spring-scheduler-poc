package br.com.sicredi.etl.pocetl.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Scheduled(cron = "0 0/1 * * * *")
    public void executar() {
        System.out.println("Executou o Scheduled com cron");
    }

}