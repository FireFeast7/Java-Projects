package com.project.quickstart.impl;

import com.project.quickstart.BluePrinter;
import org.springframework.stereotype.Service;

@Service
public class SpanishBlue implements BluePrinter {
    @Override
    public String print() {
        return "Verde";
    }
}
