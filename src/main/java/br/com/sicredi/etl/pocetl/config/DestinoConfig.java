package br.com.sicredi.etl.pocetl.config;

import br.com.sicredi.etl.pocetl.entity.Pessoa;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Collections;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "destinoEntityManagerFactory",
        transactionManagerRef = "destinoTransactionManager",
        basePackageClasses = Pessoa.class)
@EnableAutoConfiguration
@EnableTransactionManagement
public class DestinoConfig {

    @Bean(name = "destinoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean batchEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("destino-datasource") DataSource datasource) {
        return builder
                .dataSource(datasource)
                .packages(Pessoa.class)
                .persistenceUnit("syspca")
                .properties(Collections.singletonMap("hibernate.dialect",
                        "org.hibernate.dialect.MySQL8Dialect"))
                .build();
    }

    @Bean(name = "destinoTransactionManager")
    public PlatformTransactionManager batchTransactionManager(
            @Qualifier("destinoEntityManagerFactory") EntityManagerFactory emFactory) {
        return new JpaTransactionManager(emFactory);
    }
}