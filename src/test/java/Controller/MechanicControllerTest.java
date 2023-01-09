package Controller;

import Model.Car;
import Model.Customer;
import Model.Mechanic;
import Model.Rating;
import Model.Repository.InMemoCars;
import Model.Repository.InMemoRatings;
import View.CustomerView;
import View.MechanicView;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MechanicControllerTest {
    InMemoRatings ratings= new InMemoRatings();
    Customer newcustomer;
    InMemoCars repo = new InMemoCars();

    Customer customer = new Customer("David" , "Coldea" , repo, ratings);

    Mechanic mechanic = new Mechanic("Ion" , "Radu" , 5478, repo, ratings);

    MechanicView mechanicView;

    CustomerView customerView;

    CustomerController customerController = new CustomerController(customer , customerView);
    MechanicController mechanicController = new MechanicController(mechanic , mechanicView);


    @Test
    void getCars() {
        Car car1 = new Car(1 , "Audi" , "A3", 2000 , "VDYUA3", true , newcustomer);
        Car car2 = new Car(2 , "BMW" , "I8", 2020 , "JKDOAI4", true , newcustomer);
        Car car3 = new Car(2 , "Volkswagen" , "Passat", 1990 , "VFUEAB6", true , newcustomer);

        customerController.addCar(car1); //this.carList.add(car1)
        customerController.addCar(car2);
        customerController.addCar(car3);

        List<Car> returnedCars;
        returnedCars = customerController.getCars();

        assert (returnedCars.contains(car1));
        assert (returnedCars.contains(car2));
        assert (returnedCars.contains(car3));
    }

    @Test
    void getEarnings() {
        Mechanic mechanic1 = new Mechanic("Radu" , "Teaci" , 6543, repo, ratings);

        assert (mechanicController.getEarnings() == 6543);
    }

    @Test
    void getRating() {
        Rating rating = new Rating(customer , mechanic , 3);
        ratings.addRating(rating);

        assert (mechanicController.getRating() == 3);
    }

    @Test
    void getCarList() {
        Car car1 = new Car(1 , "Audi" , "A3", 2000 , "VDYUA3", true , newcustomer);
        Car car2 = new Car(2 , "BMW" , "I8", 2020 , "JKDOAI4", true , newcustomer);
        Car car3 = new Car(2 , "Volkswagen" , "Passat", 1990 , "VFUEAB6", true , newcustomer);

        customerController.addCar(car1); //this.carList.add(car1)
        customerController.addCar(car2);
        customerController.addCar(car3);

    }

    @Test
    void updateCar() {
        Car car1 = new Car(1 , "Audi" , "A3", 2000 , "VDYUA3", true , newcustomer);
        Car car2 = new Car(2 , "BMW" , "I8", 2020 , "JKDOAI4", true , newcustomer);
        Car car3 = new Car(1 , "Volkswagen" , "Passat", 1990 , "VFUEAB6", true , newcustomer);
        customerController.addCar(car1);
        customerController.addCar(car2);

        mechanicController.updateCar(car3);

        assert (car3.isRepaired());
    }

    @Test
    void filterByYear() {
        Car car1 = new Car(1 , "Audi" , "A3", 2000 , "VDYUA3", true , newcustomer);
        Car car2 = new Car(2 , "BMW" , "I8", 2020 , "JKDOAI4", true , newcustomer);
        Car car3 = new Car(2 , "Volkswagen" , "Passat", 1990 , "VFUEAB6", true , newcustomer);

        customerController.addCar(car1); //this.carList.add(car1)
        customerController.addCar(car2);
        customerController.addCar(car3);

        assert (mechanicController.filterByYear(2001).contains(car3));
    }
}