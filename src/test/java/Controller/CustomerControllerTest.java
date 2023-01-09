package Controller;

import Model.Repository.InMemoCars;
import Model.Repository.InMemoRatings;
import org.junit.jupiter.api.Test;
import Controller.CustomerController;
import Model.*;
import View.CustomerView;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerTest {
    InMemoRatings ratings = new InMemoRatings();
    InMemoCars repo = new InMemoCars();
    Mechanic mechanic = new Mechanic("Ion" , "Radu" , 8790, repo, ratings);
    Customer customer = new Customer("David" , "Coldea" , repo, ratings);
    CustomerView view;
    CustomerController customerController = new CustomerController(customer , view);
    Customer newcustomer;

    @Test
    void getCars() {
        Car car1 = new Car(1 , "Audi" , "A3", 2000 , "VDYUA3", true , newcustomer);
        Car car2 = new Car(2 , "BMW" , "I8", 2020 , "JKDOAI4", true , newcustomer);
        Car car3 = new Car(2 , "Volkswagen" , "Passat", 1990 , "VFUEAB6", true , newcustomer);
        customerController.addCar(car1);
        customerController.addCar(car2);
        customerController.addCar(car3);

        List<Car> returnedCars;
        returnedCars = customerController.getCars();

        assert (returnedCars.contains(car1));
        assert (returnedCars.contains(car2));
        assert (returnedCars.contains(car3));

    }

    @Test
    void getOwnedCars() {
        Car car1 = new Car(1 , "Audi" , "A3", 2000 , "VDYUA3", true , newcustomer);
        Car car2 = new Car(2 , "BMW" , "I8", 2020 , "JKDOAI4", true , newcustomer);
        Car car3 = new Car(2 , "Volkswagen" , "Passat", 1990 , "VFUEAB6", true , newcustomer);

        customerController.addCar(car1);
        customerController.addCar(car2);
        customerController.addCar(car3);

        List<Car> returnedOwnedCars;
        returnedOwnedCars = customerController.getOwnedCars();

        assert (returnedOwnedCars.contains(car1));
        assert (returnedOwnedCars.contains(car2));
        assert (returnedOwnedCars.contains(car3));

    }

    @Test
    void giveRating() {

        Rating rating = new Rating(customer , mechanic , 4);
        customerController.giveRating(rating);

        assert (ratings.getRatings().contains(rating));

    }

    @Test
    void addCar() {
        Car car1 = new Car(1 , "Audi" , "A3", 2000 , "VDYUA3", true , newcustomer);
        customerController.addCar(car1);

        assert (customerController.getCars().contains(car1));
    }

    @Test
    void deleteCar() {
        Car car1 = new Car(1 , "Audi" , "A3", 2000 , "VDYUA3", true , newcustomer);
        Car car2 = new Car(2 , "BMW" , "I8", 2020 , "JKDOAI4", true , newcustomer);
        customerController.addCar(car1);
        customerController.addCar(car2);
        customerController.deleteCar(car2);

        assert (customerController.getCars().contains(car1));
    }

    @Test
    void findOldestCar() {
        Car car1 = new Car(1 , "Audi" , "A3", 2000 , "VDYUA3", true , newcustomer);
        Car car2 = new Car(2 , "BMW" , "I8", 2020 , "JKDOAI4", true , newcustomer);
        customerController.addCar(car1);
        customerController.addCar(car2);

        assert (customerController.findOldestCar().getManufactureYear() == car1.getManufactureYear());

    }
}