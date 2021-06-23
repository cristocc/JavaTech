package com.spring.study.service;

/**
 * Created by crist on 2021/6/8
 *
 * @author cc
 */
public class ClientService {

    private static ClientService clientService = new ClientService();
    private ClientService() {}

    public static ClientService createInstance() {
        System.out.println("createInstance");
        return clientService;
    }
}
