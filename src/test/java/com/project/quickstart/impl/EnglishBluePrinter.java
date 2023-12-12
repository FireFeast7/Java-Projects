package com.project.quickstart.impl;

import com.project.quickstart.BluePrinter;
import org.springframework.stereotype.Component;


public class EnglishBluePrinter implements BluePrinter {

    @Override
    public String print() {
        return "blue";
    }
}
