package com.project.quickstart;

import com.project.quickstart.impl.ColorPrinterImpl;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class ColorsApplication implements CommandLineRunner {

    private ColorPrinter colorPrinter;
    public ColorsApplication(ColorPrinter colorPrinter1){
        this.colorPrinter = colorPrinter1;
    }
    public static void main(String[] args) {
        SpringApplication.run(ColorsApplication.class,args);
    }


    @Override
    public void run(String... args) throws Exception {
        log.info(colorPrinter.print());
    }
}
