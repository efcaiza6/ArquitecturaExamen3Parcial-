package ec.edu.espe.arquitectura.examen;

import com.github.javafaker.Faker;
import ec.edu.espe.arquitectura.examen.model.PagoPrestamo;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

@SpringBootApplication
@Slf4j
public class ArquitecturaExamen3ParcialApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArquitecturaExamen3ParcialApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Object> kafkaTemplate) {
        return args -> {
            Faker faker = new Faker();
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            PagoPrestamo pagoPrestamo = new PagoPrestamo();

            for (int i = 0; i < 10; i++) {
                pagoPrestamo.setCodigoPrestamo(faker.number().digits(7));
                pagoPrestamo.setValorPago(BigDecimal.valueOf(faker.number().numberBetween(20, 100)));
                pagoPrestamo.setFechaPago(date);
                pagoPrestamo.setHoraPago(dateFormat.parse(date.toString()));
                pagoPrestamo.setNumeroCuota(faker.number().numberBetween(1, 12));
                log.info("Pago-Prestamo: {}", pagoPrestamo);
                ListenableFuture<SendResult<String, Object>> send = kafkaTemplate.send("pago-prestamo", pagoPrestamo);
                send.addCallback(new KafkaSendCallback<String, Object>() {
                    @Override
                    public void onSuccess(SendResult<String, Object> result) {
                        log.info("Mensaje enviado: {}", result.getRecordMetadata());
                    }

                    @Override
                    public void onFailure(KafkaProducerException ex) {
                        log.info("Ocurrio un error: {}", ex);
                    }

                });
            }
        };
    }

}
