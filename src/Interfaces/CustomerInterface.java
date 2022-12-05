package Interfaces;

import Exceptions.CustomIncorrectArgument;

public interface CustomerInterface<C> extends ICrud<C>{
    void addCar(C c) throws Exception;
    void deleteCar(C c) throws Exception;
    void updateCar(C c);
}