package DAO;

import POJO.City;
import POJO.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CityDaoImpl implements CityDao{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @Override
    public City findByIdCity(int id) {
        City city= entityManager.find(City.class, id);
        entityManager.close();
        entityManagerFactory.close();
        return city;
    }

    @Override
    public List<City> getAllObjectInCity() {
       final String jbqlQuery= "from City";
       TypedQuery<City> query= entityManager.createQuery(jbqlQuery, City.class);
       List<City> cityList=query.getResultList();
       return cityList;
    }

    @Override
    public void saveCity(City city) {
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

    @Override
    public void updateByIdCity(int id, City city) {
        entityManager.getTransaction().begin();
        City nowCity= entityManager.find(City.class, id);
        nowCity= entityManager.merge(city);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }

    @Override
    public void deleteByIdCity(int id) {
        entityManager.getTransaction().begin();
        City nowCity= entityManager.find(City.class, id);
        entityManager.remove(nowCity);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
