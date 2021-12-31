package br.com.sicredi.etl.pocetl.service;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.time.LocalDateTime;

@Slf4j
public class SchedulerService {
    Logger LOG;

    public void run() {
        LOG.debug("start run at: ", LocalDateTime.now());



        LOG.debug("end run at: ", LocalDateTime.now());
    }
}
