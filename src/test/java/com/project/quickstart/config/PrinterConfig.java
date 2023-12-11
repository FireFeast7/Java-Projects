package com.project.quickstart.config;

import com.project.quickstart.BluePrinter;
import com.project.quickstart.ColorPrinter;
import com.project.quickstart.GreenPrinter;
import com.project.quickstart.RedPrinter;
import com.project.quickstart.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrinterConfig {
    @Bean
    public BluePrinter bluePrinter(){
        return new SpanishBlue();
    }
    @Bean
    public RedPrinter redPrinter(){
        return new SpanishRed();
    }
    @Bean
    public GreenPrinter greenPrinter(){
        return new SpanishGreen();
    }
    @Bean
    public ColorPrinter colorPrinter(RedPrinter redPrinter,BluePrinter bluePrinter,GreenPrinter greenPrinter){
        return new ColorPrinterImpl(redPrinter,bluePrinter,greenPrinter);
    }
}
