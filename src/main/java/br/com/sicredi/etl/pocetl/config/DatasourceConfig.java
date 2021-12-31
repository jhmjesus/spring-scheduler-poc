package br.com.sicredi.etl.pocetl.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {
    @Bean(name = "origem-datasource")
    @ConfigurationProperties(prefix = "origem.datasource")
    public DataSource criarDatasourceOrigem() {
        return DataSourceBuilder
                .create()
                .build();
    }

    @Bean(name = "destino-datasource")
//    @ConfigurationProperties(prefix = "destino.datasource")
    public DataSource criarDatasourceDestino() {
        return DataSourceBuilder
                .create()
                .url("jdbc:mysql://localhost:3306/db_pessoa")
                .username("duser")
                .password("ouser")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();
    }

    @Primary
    @Bean(name = "batch-datasource")
    @ConfigurationProperties(prefix = "batch.datasource")
    public DataSource criarDatasourceBatch() {
        return DataSourceBuilder.create().build();
    }
}
