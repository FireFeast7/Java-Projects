package com.project.quickstart.impl;

import com.project.quickstart.GreenPrinter;
import org.springframework.stereotype.Component;


public class EnglishGreenPrinter implements GreenPrinter {

    @Override
    public String print() {
        return "green";
    }
}
