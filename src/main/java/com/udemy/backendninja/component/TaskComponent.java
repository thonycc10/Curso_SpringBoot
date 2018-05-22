package com.udemy.backendninja.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("taskComponent")
public class TaskComponent {

    private static final Log LOG = LogFactory.getLog(TaskComponent.class);

    @Scheduled(fixedDelay = 5000) // 5 segundos, para log repetitivos - falta aplicacion en la clase principal @EnableScheduling
    public void doTask(){
        LOG.info("Time is : " + new Date());
        // ayudan a envio de correos automaticos, eliminar algunos datos de tablas base de datos. etc
    }

//    para saber mas de spring bach  https://spring.io/guides/gs/batch-processing/
}
