package Interfaces;
import Model.Car;

public interface ICrud<C> {
    void addCar(C c) throws Exception;
    void deleteCar(C c) throws Exception;
    void updateCar(C c) throws Exception;
}