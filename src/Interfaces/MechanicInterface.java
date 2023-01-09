package Interfaces;

public interface MechanicInterface<C> extends ICrud<C>{
    void addCar(C c) throws Exception;
    void deleteCar(C c) throws Exception;
    void updateCar(C c) throws Exception;

}
