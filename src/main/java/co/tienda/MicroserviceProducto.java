package co.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "co.tienda", "co.tienda.api" })
public class MicroserviceProducto {

    public static void main(String[] args) throws Exception {
        new SpringApplication(MicroserviceProducto.class).run(args);
    }

}
