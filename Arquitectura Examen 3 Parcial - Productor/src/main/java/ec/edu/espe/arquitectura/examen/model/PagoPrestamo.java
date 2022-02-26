/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.examen.model;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author Windows Boo
 */
@Data
@Entity
@Table(name = "pago_prestamo")
public class PagoPrestamo {

    private static final long serialVersionUID = 123456L;
    @Id
    private String codigoPrestamo;
    @Column(name = "valor_pago", nullable = false, length = 50)
    private BigDecimal valorPago;
    @Column(name = "fecha_pago", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Column(name = "hora_pago", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaPago;
    @Column(name = "numero_cuota", nullable = false, length = 50)
    private Integer numeroCuota;
}
