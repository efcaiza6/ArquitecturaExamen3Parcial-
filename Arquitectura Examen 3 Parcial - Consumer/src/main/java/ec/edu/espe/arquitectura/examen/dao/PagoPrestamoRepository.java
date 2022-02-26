/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.examen.dao;

import ec.edu.espe.arquitectura.examen.model.PagoPrestamo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Windows Boo
 */
public interface PagoPrestamoRepository extends JpaRepository<PagoPrestamo, Integer> {
    
}
