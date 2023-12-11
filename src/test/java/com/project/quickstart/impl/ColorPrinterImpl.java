package com.project.quickstart.impl;

import com.project.quickstart.*;

public class ColorPrinterImpl implements ColorPrinter {
    private RedPrinter redPrinter;
    private BluePrinter bluePrinter;
    private GreenPrinter greenPrinter;

    public ColorPrinterImpl(RedPrinter redPrinter,BluePrinter bluePrinter,GreenPrinter greenPrinter) {
        this.redPrinter = redPrinter;
        this.bluePrinter = bluePrinter;
        this.greenPrinter = greenPrinter;
    }

    @Override
    public String print() {
        return String.join(" ,",redPrinter.print(),bluePrinter.print(),greenPrinter.print());
    }
}
