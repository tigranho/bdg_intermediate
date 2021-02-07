package com.bdg.ams.repo.dao.daoimpl;

public class AsmConst {

    final static String GET_COMPANY_BY_ID = "select * from company where id=?";
    final static String GET_ALL_COMPANIES = "select * from company";
    final static String SAVE_COMPANY = "insert  into company(name,found_date) values (?,?)";
    final static String UPDATE_COMPANY = "update company set name=?,found_date=?  where id=?";
    final static String DELETE_COMPANY = "delete from company where  id=?";
    final static String GET_ADDRESS_BY_ID = "select * from address where id=?";
    final static String SAVE_ADDRESS = "insert  into address(country,city) values (?,?)";
    final static String GET_PASSENGER_BY_ID = "select * from passenger where id=?";
    final static String GET_ALL_PASSENGERS = "select * from passenger";
    final static String SAVE_PASSENGER = "insert  into passenger(name,phone,address_id) values (?,?,?)";
    final static String UPDATE_PASSENGER = "update passenger set name=?,phone=?,address_id=?  where id=?";
    final static String DELETE_PASSENGER = "delete from passenger where  id=?";
    final static String GET_TRIP_BY_ID = "select * from trip where trip_number=?";
    final static String GET_ALL_TRIPS = "select * from trip";
    final static String SAVE_TRIP = "insert  into trip(company_id,time_in,time_out,town_to,town_from) values (?,?,?,?,?)";
}
