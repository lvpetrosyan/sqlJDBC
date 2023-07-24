package DAO;

import POJO.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    public Employee findBuId(int id) throws SQLException;
    public List<Employee> getAllObjectInEmployee () throws SQLException;
    public void save(Employee employee) throws SQLException;
    public void updateById(int id, String firstName, String lastName) throws SQLException;
    public void updateByIdEmployee(int id, Employee employee) throws SQLException;
    public void deleteById(int id) throws SQLException;
}
