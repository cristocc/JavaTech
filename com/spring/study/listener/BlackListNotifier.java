package com.spring.study.listener;

import org.springframework.context.ApplicationListener;

/**
 * Created by crist on 2021/6/16
 *
 * @author cc
 */
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    public void onApplicationEvent(BlackListEvent event) {
        System.out.println("BlackListEvent="+event);
        // notify appropriate parties via notificationAddress...
    }


/*
    @EventListener
    public void processBlackListEvent(BlackListEvent event) {
        // notify appropriate parties via notificationAddress...
    }

    @EventListener({ContextStartedEvent.class, ContextRefreshedEvent.class})
public void handleContextStart() {
    ...
}
*/

}
