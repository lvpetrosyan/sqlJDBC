package DAO;

import POJO.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAOHibernate implements EmployeeDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public Employee findBuId(int id) throws SQLException {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.close();
        entityManagerFactory.close();
        return employee;
    }

    @Override
    public List<Employee> getAllObjectInEmployee() throws SQLException {
        final String jpqlQuery = "FROM Employee";
        TypedQuery<Employee> query = entityManager.createQuery(jpqlQuery, Employee.class);
        List<Employee> employeeList = query.getResultList();
        return employeeList;
    }

    @Override
    public void save(Employee employee) throws SQLException {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void updateByIdEmployee(int id, Employee employee) throws SQLException {
        entityManager.getTransaction().begin();
        Employee nowEmployee= entityManager.find(Employee.class, id);
        nowEmployee= entityManager.merge(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        entityManager.getTransaction().begin();
        Employee employee= entityManager.find(Employee.class, id);
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void updateById(int id, String firstName, String lastName) throws SQLException {

    }
}
