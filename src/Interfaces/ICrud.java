package Interfaces;
import Model.Car;

public interface ICrud<C> {
    void addCar(C c);
    void deleteCar(C c);
    void updateCar(C c);
}
