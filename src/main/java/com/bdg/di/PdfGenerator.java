package com.bdg.di;

/**
 * @author Tigran
 */
public class PdfGenerator implements ReportGenerator {
    @Override
    public void generate() {
        System.out.println("Pdf Report");
    }
}
