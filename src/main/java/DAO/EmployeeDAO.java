package DAO;

import POJO.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    public Optional<Employee> findBuId(int id) throws SQLException;
    public List<Employee> getAllObjectInEmployee () throws SQLException;
    public void save(Employee employee) throws SQLException;
    public void updateById(int id, String first_name, String last_name) throws SQLException;
    public void deleteById(int id) throws SQLException;
}
