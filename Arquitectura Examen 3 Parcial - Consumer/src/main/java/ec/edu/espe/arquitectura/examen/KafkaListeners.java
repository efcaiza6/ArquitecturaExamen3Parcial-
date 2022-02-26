/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.examen;

import ec.edu.espe.arquitectura.examen.model.PagoPrestamo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Windows Boo
 */
@Slf4j
@Component
public class KafkaListeners {

    private final RestTemplate restTemplate = new RestTemplate();

    @KafkaListener(
            topics = "pago-prestamo",
            groupId = "groupId"
    )
    public void Listener(PagoPrestamo pagoPrestamo) {
        log.info("Data recibida de Apache Kafka: {}", pagoPrestamo);
        this.restTemplate.postForObject("http://localhost:8080/api/v1/pago", pagoPrestamo, PagoPrestamo.class);
    }
}
