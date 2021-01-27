package jaxb_example;

import com.google.gson.Gson;

public class JavaToJson {
    public static void main(String[] args) {
        Customer c1=new Customer();
        c1.setName("John");
        c1.setCstId("2");
        c1.setOverdue(45.6f);
          Gson  json=new Gson();
          String response=json.toJson(c1);
        System.out.println(response);
    }
}
