package com.bdg.di;

/**
 * @author Tigran
 */
public class Report {

    ReportGenerator reportGenerator;

    public void setReportGenerator(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    void generate() {
        reportGenerator.generate();
    }

}
