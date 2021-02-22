package com.bdg.airport_management_JPA;


import com.bdg.airport_management_JPA.DAO1.AddressDao;
import com.bdg.airport_management_JPA.DAOIMPL.AddressDaoImpl;

public class Main {

    public static void main(String[] args) {


        AddressDao address = new AddressDaoImpl();
        address.writeAddressFromFileIntoDB();}}