package Interfaces;

public interface CustomerInterface<C> extends ICrud<C>{
    void addCar(C c);
    void deleteCar(C c);
    void updateCar(C c);

}