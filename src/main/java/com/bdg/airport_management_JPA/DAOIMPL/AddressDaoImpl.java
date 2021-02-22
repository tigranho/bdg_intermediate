package com.bdg.airport_management_JPA.DAOIMPL;



import com.bdg.airport_management_JPA.DAO1.AddressDao;
import com.bdg.airport_management_JPA.Model.Address;
import com.bdg.airport_management_JPA.util.ReadFile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

import static com.bdg.airport_management_JPA.util.ReadFile.fromFileToList;


public class AddressDaoImpl implements AddressDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Hibernate_JPA");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    static Address address = null;

    @Override
    public Address getById(long id) {
        entityManager.getTransaction().begin();
        try {
            address = entityManager.find(Address.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return address;
    }

    @Override
    public Address save(Address address) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(address);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return address;
    }

    @Override
    public void update(Address address, long id) {
        entityManager.getTransaction().begin();
        try {
            AddressDaoImpl.address = entityManager.find(Address.class, id);
            AddressDaoImpl.address.setCountry(address.getCountry());
            AddressDaoImpl.address.setCity(address.getCity());
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }

    @Override
    public void delete(long id) {
        entityManager.getTransaction().begin();
        try {
            address = entityManager.find(Address.class, id);
            entityManager.remove(address);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public List<Address> getAll() {
        List<Address> addressList = new LinkedList<>();

        entityManager.getTransaction().begin();
        try {
            Query query = entityManager.createQuery("Select e from Address e");
            addressList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return addressList;
    }

    @Override
    public void writeAddressFromFileIntoDB() {
        entityManager.getTransaction().begin();
        List<String> addressList = fromFileToList(ReadFile.COMPANIES_PATH);;


        try {
            for (int i = 1; i < addressList.size(); i++) {
                Address address = new Address();
                String[] temp = addressList.get(i).split(",");
                address.setCountry(temp[2]);
                address.setCity(temp[3]);


                entityManager.persist(address);


            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();

        }

    }
}