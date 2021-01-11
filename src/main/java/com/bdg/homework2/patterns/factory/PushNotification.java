package com.bdg.homework2.patterns.factory;

public class PushNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending a push notification");
    }
}
