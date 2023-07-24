package DAO;

import POJO.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoJDBC implements EmployeeDAO {
    @Override
    public Employee findBuId(int id) throws SQLException {
        final String qeary = "SELECT * FROM employes where id=? ";
        Employee employee = new Employee();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(qeary)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int city = resultSet.getInt("city_id");
                employee = new Employee(id, firstName, lastName, gender, city);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return employee;
    }

    @Override
    public void save(Employee employee) throws SQLException {
        final String query = " INSERT INTO employes(first_name, last_name, gender, age, city_id) VALUES ((?),(?),(?),(?),(?))";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getGender());
            preparedStatement.setInt(4, employee.getAge());
            preparedStatement.setInt(5, employee.getCityId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllObjectInEmployee() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        final String query = "SELECT * FROM employes";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int city = resultSet.getInt("city_id");
                int age = resultSet.getInt("age");
                int id = resultSet.getInt("id");
                employeeList.add(new Employee(id, firstName, lastName, gender, city));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void updateById(int id, String firstName, String lastName) throws SQLException {
        final String query = "Update employes SET first_name =(?), last_name =(?) WHERE id=?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) throws SQLException {
        final String query = "Delete FROM employes  WHERE id=?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        final String user = "postgres";
        final String password = "Dovaziyliil1551.";
        final String url = "jdbc:postgresql://localhost:5432/skypro";
        return DriverManager.getConnection(url, user, password);

    }

    @Override
    public void updateByIdEmployee(int id, Employee employee) throws SQLException {

    }
}
