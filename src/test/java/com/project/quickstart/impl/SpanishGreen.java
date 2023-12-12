package com.project.quickstart.impl;

import com.project.quickstart.GreenPrinter;
import org.springframework.stereotype.Service;

@Service
public class SpanishGreen implements GreenPrinter {
    @Override
    public String print() {
        return "Azul";
    }
}
