/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.examen.service;

import ec.edu.espe.arquitectura.examen.dao.PagoPrestamoRepository;
import ec.edu.espe.arquitectura.examen.model.PagoPrestamo;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author Windows Boo
 */
@Service
public class PagoPrestamoService {
    private final PagoPrestamoRepository pagoPrestamoRepository;

    public PagoPrestamoService(PagoPrestamoRepository pagoPrestamoRepository) {
        this.pagoPrestamoRepository = pagoPrestamoRepository;
    }
    
    
    public void guardarPago(PagoPrestamo pagoPrestamo) {
        this.pagoPrestamoRepository.save(pagoPrestamo);
    }
    
}
