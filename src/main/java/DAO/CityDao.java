package DAO;

import POJO.City;
import POJO.Employee;

import java.sql.SQLException;
import java.util.List;

public interface CityDao {
    public City findByIdCity(int id);
    public List<City> getAllObjectInCity ();
    public void saveCity(City city);
    public void updateByIdCity(int id, City city);
    public void deleteByIdCity(int id);

}
