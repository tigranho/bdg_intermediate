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
            Book book = new Book("OCP", 600, LocalDate.now());
            Book book1 = new Book("OCA", 500, LocalDate.now());

            Set<Book> books = new HashSet<>();
            books.add(book);
            books.add(book1);

            Author author  = new Author("Jhon", LocalDate.of(2020,10,10), books );
            entitymanager.persist(author);
//
            entitymanager.getTransaction().commit();
        } catch (Exception e) {
            entitymanager.getTransaction().rollback();
        }

        entitymanager.close();
        emfactory.close();
    }

}
