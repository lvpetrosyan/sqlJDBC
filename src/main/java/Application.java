import DAO.*;
import POJO.City;
import POJO.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        EmployeeDAOHibernate employeeDAOHibernate = new EmployeeDAOHibernate();
        Employee employee = new Employee("Lilo", "lank", "f", 31, 1);
        Employee employee11 = new Employee(50, "lo", "plov", "m", 2);
        // System.out.println(employeeDAOHibernate.findBuId(28));
        // System.out.println(employeeDAOHibernate.getAllObjectInEmployee());
        // employeeDAOHibernate.save(employee);
        // System.out.println(employeeDAOHibernate.getAllObjectInEmployee());
        // employeeDAOHibernate.deleteById(43);
        // employeeDAOHibernate.updateByIdEmployee(50,employee11);
        CityDaoImpl cityDao= new CityDaoImpl();
        City city= new City(5,"СПБ");
        // System.out.println(cityDao.findByIdCity(1));
        // System.out.println(cityDao.getAllObjectInCity());
        // cityDao.saveCity(city);
        // cityDao.updateByIdCity(5,city);
         cityDao.deleteByIdCity(11);



//        /*ДЗ1 с JDBC
//        EmployeeDAO employeeDAO = new EmployeeDaoJDBC();
//        //Задание 2.1 добавление элемента
//        Employee person = new Employee(35, "karl", "Nani", "m", 2);
//        employeeDAO.save(person);
//        System.out.println("В базу данных добавлен: " + person);
//
//        //2.2 поиск по ид
//        Employee employee = employeeDAO.findBuId(31).get();
//        System.out.println(employee);
//
//        //2.3 получение списка всех объектов
//        List<Employee> employeeList = new ArrayList<>(employeeDAO.getAllObjectInEmployee());
//        for (Employee employee1 : employeeList) {
//            System.out.println(employee1);
//        }
//
//        //2.4 обновление данных+ Задание 1. Получить и вывести в консоль полные данные
//        // об одном из работников без конструкции ДАО. Выводит обновленные данные по ид
//        // employeeDAO.updateById(32,"Bonnie","Clyde");
//        String qeary = "select* from employes Left join city On employes.city_id=city.city_id where id=?";
//        try (Connection connection = getConnection();
//             PreparedStatement statement = connection.prepareStatement(qeary)) {
//            statement.setInt(1, 30);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                String firstName = resultSet.getString(2);
//                String lastName = resultSet.getString("last_name");
//                String gender = resultSet.getString("gender");
//                String cityName = resultSet.getString("city_name");
//                int city = resultSet.getInt("city_id");
//                System.out.println(firstName + " " + lastName + " " + gender + " " + city + " " + cityName);
//            }
//
//            //2.5 удаление сотрудника
//            employeeDAO.deleteById(32);
//            System.out.println(employeeDAO.findBuId(32).get() + " удален из БД");
//        }
//    }
//
//    private static Connection getConnection() throws SQLException {
//        final String user = "postgres";
//        final String password = "Dovaziyliil1551.";
//        final String url = "jdbc:postgresql://localhost:5432/skypro";
//        return DriverManager.getConnection(url, user, password);*/

    }
}
