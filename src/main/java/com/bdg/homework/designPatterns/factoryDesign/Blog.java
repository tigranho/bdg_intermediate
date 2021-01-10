package com.bdg.homework.designPatterns.factoryDesign;

public class Blog  extends Website{
    @Override
    protected void createWebsite() {
        pageList.add(new PostPage());
        pageList.add(new AboutPage());
        pageList.add(new CommentPage());
        pageList.add(new ContactPage());
    }
}
