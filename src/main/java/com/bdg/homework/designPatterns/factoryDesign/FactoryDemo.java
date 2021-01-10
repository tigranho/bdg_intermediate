package com.bdg.homework.designPatterns.factoryDesign;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class FactoryDemo {

    public static void main(String[] args) {
        Website website = WebsiteFactory.getWebsite("blog");
        System.out.println(website.getPageList());

        website = WebsiteFactory.getWebsite("shop");
        System.out.println(website.getPageList());

    }
}
