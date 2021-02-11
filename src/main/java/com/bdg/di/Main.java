package com.bdg.di;

/**
 * @author Tigran
 */
public class Main {

    public static void main(String[] args) {
        PdfGenerator pdfGenerator = new PdfGenerator();
        Report report  = new Report();
        report.setReportGenerator(pdfGenerator);
        report.generate();

        ExelGenerator exelGenerator = new ExelGenerator();
        report  = new Report();
        report.setReportGenerator(exelGenerator);

        report.generate();
    }

}
