package com.bdg.homework.designPatterns.factoryDesign;

public class Shop extends Website {
    @Override
    protected void createWebsite() {
        pageList.add( new CartPage());
        pageList.add( new PostPage());
        pageList.add( new SearchPage());
    }
}
