/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.examen.controller;

import ec.edu.espe.arquitectura.examen.model.PagoPrestamo;
import ec.edu.espe.arquitectura.examen.service.PagoPrestamoService;
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
    private final PagoPrestamoService pagoPrestamoService;

    public PagoPrestamoController(KafkaTemplate<String, Object> kafkaTemplate, PagoPrestamoService pagoPrestamoService) {
        this.kafkaTemplate = kafkaTemplate;
        this.pagoPrestamoService = pagoPrestamoService;
    }

    @PostMapping("pago")
    public void guardarPago(@RequestBody PagoPrestamo p) {
        this.pagoPrestamoService.guardarPago(p);
    }
}
