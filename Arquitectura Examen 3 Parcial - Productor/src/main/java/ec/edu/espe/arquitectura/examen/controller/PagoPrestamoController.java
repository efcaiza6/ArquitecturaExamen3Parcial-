/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.examen.controller;

import ec.edu.espe.arquitectura.examen.model.PagoPrestamo;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Windows Boo
 */
@RestController
@RequestMapping("api/v1/")
public class PagoPrestamoController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PagoPrestamoController(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@RequestBody PagoPrestamo p) {
        kafkaTemplate.send("pago-prestamo", p);
    }

}
