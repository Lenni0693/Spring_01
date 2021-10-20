package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    private List<Car> listCar = new ArrayList<Car>();

    {
        listCar.add(new Car("Mercedes", "black", 350));
        listCar.add(new Car("BMW", "white", 6));
        listCar.add(new Car("VAZ", "white", 2101));
        listCar.add(new Car("Audi", "red", 3));
        listCar.add(new Car("chevrolet", "yellow", 6245));
    }

    @Override
    public List<Car>getListCar(int count){
        return listCar.stream().limit(count).collect(Collectors.toList());
    }
}
