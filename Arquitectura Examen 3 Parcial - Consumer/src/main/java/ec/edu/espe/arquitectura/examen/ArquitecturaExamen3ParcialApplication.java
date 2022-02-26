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

}
