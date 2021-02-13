package com.bdg.homework.traveling.model;

import sun.util.resources.LocaleData;

public class Company {
    private String name;
    private LocaleData localeData;

    public Company() {
    }

    public Company(String name, LocaleData localeData) {
        this.name = name;
        this.localeData = localeData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocaleData getLocaleData() {
        return localeData;
    }

    public void setLocaleData(LocaleData localeData) {
        this.localeData = localeData;
    }
}
