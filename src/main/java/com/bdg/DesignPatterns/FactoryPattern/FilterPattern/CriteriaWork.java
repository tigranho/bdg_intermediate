package com.bdg.DesignPatterns.FactoryPattern.FilterPattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaWork implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> workPersons = new ArrayList<Person>();

        for (Person person : persons) {
            if(person.getWork().equalsIgnoreCase("IT")){
                workPersons.add(person);
            }
        }
        return workPersons;
    }
}