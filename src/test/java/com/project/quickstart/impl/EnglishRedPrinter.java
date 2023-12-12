package com.project.quickstart.impl;

import com.project.quickstart.RedPrinter;
import org.springframework.stereotype.Component;

@Component
public class EnglishRedPrinter implements RedPrinter {

    @Override
    public String print() {
        return "red";
    }
}
