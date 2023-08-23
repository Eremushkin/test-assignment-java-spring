package dev.rudchenko.testassignment;

import dev.rudchenko.testassignment.service.processor.CalculationProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication
@EnableScheduling
@ConfigurationPropertiesScan
public class TestAssignmentApplication {

    public static void main(String[] args) {

        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("First argument is Required");
        }

        ConfigurableApplicationContext applicationContext = SpringApplication.run(TestAssignmentApplication.class, args);

        applicationContext.getBean(CalculationProcessor.class).processTask(args[0]);
        System.out.println(Arrays.toString(args)); //delete
    }

}
