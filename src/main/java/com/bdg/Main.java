package com.bdg;


import com.bdg.jpa.Author;
import com.bdg.jpa.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Tigran
 */
public class Main {




    public static void main(String[] args) {

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Hibernate_JPA");

        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        try {

            //Transient
            Book  book = entitymanager.find(Book.class, 1L);

            System.out.println(book.getAuthors());


            //Persistent
            entitymanager.getTransaction().commit();
            //Detached

            entitymanager.close();

            System.out.println(book.getAuthors());


        } catch (Exception e) {
            entitymanager.getTransaction().rollback();
        }


    }

}
