import Model.Car;
import Model.Customer;
import Model.Repository.*;
import Model.*;
import java.util.*;
import java.util.stream.Collectors;

import Controller.*;
import View.CustomerView;
import View.MechanicView;

import static java.lang.System.exit;

public class Menu {
    private InMemoCars cars=new InMemoCars();
    private CustomerController controller1;
    private MechanicController controller2;
    private Customer newcustomer;
    private Mechanic newmechanic;
    private InMemoCustomers customers = new InMemoCustomers();
    private InMemoMechanics mechanics = new InMemoMechanics();
    private CustomerView view1=new CustomerView();
    private MechanicView view2= new MechanicView();

    private InMemoRatings ratings = new InMemoRatings();

    public void login() {
        populate();
        System.out.println("What role do you want to have?");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter key 1 for customer or enter key 2 for mechanic");
        int choose = scanner.nextInt();

        switch (choose) {
            case 1:
                for (Customer c : this.customers.getCustomers()) {
                        System.out.println(c.getFirstName());
                        System.out.println(c.getLastName());
                }
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("What is your first name?");
                String firstname = scanner1.nextLine();
                System.out.println("What is your last name?");
                String lastname = scanner1.nextLine();

                for (Customer c : this.customers.getCustomers()) {
                    if (Objects.equals(c.getFirstName(), firstname) && Objects.equals(c.getLastName(), lastname)) {
                        newcustomer = c;
                    }
                }
                this.controller1 = new CustomerController(this.newcustomer, view1);
                menucustomer();

            case 2:
                for (Mechanic m : this.mechanics.getMechanics()) {
                        System.out.println(m.getFirstName());
                        System.out.println(m.getLastName());
                }
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("What is your first name?");
                String firstname2 = scanner2.nextLine();
                System.out.println("What is your last name?");
                String lastname2 = scanner2.nextLine();

                for (Mechanic m : this.mechanics.getMechanics()) {
                    if (Objects.equals(m.getFirstName(), firstname2) && Objects.equals(m.getLastName(), lastname2)) {
                        newmechanic = m;
                    }
                }
                this.controller2 = new MechanicController(this.newmechanic, view2);
                menumechanic();
        }

    }

    public void populate() {
        Customer customer1 = new Customer("Emil", "Pop", cars);
        Customer customer2 = new Customer("Cristian", "Popescu", cars);
        Customer customer3 = new Customer("Andrei", "Serban", cars);
        customers.addCustomer(customer1);
        customers.addCustomer(customer2);
        customers.addCustomer(customer3);
        Car car1=new Car(224,"Audi","A3",2017,"WAUZZZ4327",false,customer1);
        Car car2=new Car(336,"Audi","Q3",2014,"WAUZZZ6903",false,customer2);
        Car car3=new Car(193,"Volkswagen","Multivan",2020,"WAUZZZ1592",false,customer3);
        Car car4=new Car(392,"BMW","M3",2021,"BWQ2X9921",false,customer1);
        Car car5=new Car(705,"Porsche","911 Turbo S",2020,"WPD342A62",false,customer2);
        Car car6=new Car(955,"BMW","I3",2016,"BWR9X3179",false,customer2);
        cars.addCar(car1);
        cars.addCar(car2);
        cars.addCar(car3);
        cars.addCar(car4);
        cars.addCar(car5);
        cars.addCar(car6);

        Mechanic mechanic1 = new Mechanic("Matei", "Andreescu", 1900);
        Mechanic mechanic2 = new Mechanic("Andrei", "Cernea", 2700);
        mechanics.addMechanic(mechanic1);
        mechanics.addMechanic(mechanic2);
        Rating r1=new Rating(customer1,mechanic1,4);
        Rating r2=new Rating(customer2,mechanic1,4.5);
        Rating r3=new Rating(customer2,mechanic2,5);
        Rating r4=new Rating(customer1,mechanic2,4.5);
        this.controller1.giveRating(r1);
        this.controller2.setRating();
        this.controller1.giveRating(r2);
        this.controller2.setRating();
        this.controller1.giveRating(r3);
        this.controller2.setRating();
        this.controller1.giveRating(r4);
        this.controller2.setRating();

    }

    public void menucustomer() {

        //menu for Customer
        System.out.println("\n");
        System.out.println("Options: ");
        System.out.println("Press key 1 to add a car ");
        System.out.println("Press key 2 to delete a car ");
        System.out.println("Press key 3 to get the owned cars ");
        System.out.println("Press key 4 to give a rating ");
        System.out.println("Press key 5 to find the oldest car ");
        System.out.println("<<Press key 0 for log out>>");
        System.out.println("\n");

        System.out.println("Choose an option");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        System.out.println("\n");

        switch (option) {
            case 1:
                System.out.println("What Id has the car you want to add?");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("What brand is the car you want to add?");
                String brand = scanner.nextLine();
                System.out.println("What model is the car you want to add?");
                String model = scanner.nextLine();
                System.out.println("What manufacture year is the car you want to add?");
                int manufactureYear = scanner.nextInt();
                scanner.nextLine();
                System.out.println("What chassis series has the car you want to add?");
                String chassisSeries = scanner.nextLine();
                Car car1 = new Car(id, brand, model, manufactureYear, chassisSeries, false, newcustomer);
                this.controller1.addCar(car1);
                menucustomer();
            case 2:
                controller1.viewGetOwnedCars();
                System.out.println("What Id has the car you want to remove?");
                int id2 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("What brand is the car you want to remove?");
                String brand2 = scanner.nextLine();
                System.out.println("What model is the car you want to remove?");
                String model2 = scanner.nextLine();
                System.out.println("What manufacture year is the car you want to remove?");
                int manufactureYear2 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("What chassis series has the car you want to remove?");
                String chassisSeries2 = scanner.nextLine();
                Car car2 = new Car(id2, brand2, model2, manufactureYear2, chassisSeries2, false, newcustomer);
                this.controller1.deleteCar(car2);
                menucustomer();
            case 3:
                this.controller1.viewGetOwnedCars();
                menucustomer();
            case 4:
                this.controller1.viewPrintMechanics(this.mechanics.getMechanics());
                System.out.println("What first name has the mechanic?");
                String firstname = scanner.nextLine();
                System.out.println("What last name has the mechanic?");
                String lastname = scanner.nextLine();
                Mechanic themechanic = null;
                for (Mechanic m : this.mechanics.getMechanics()) {
                    if (Objects.equals(m.getFirstName(), firstname) && Objects.equals(m.getLastName(), lastname)) {
                        themechanic = m;
                    }
                }
                System.out.println("What value has the rating?");
                double value = scanner.nextInt();
                Rating rating = new Rating(newcustomer, themechanic, value);
                this.controller1.giveRating(rating);
                this.controller2.setRating();
                menucustomer();
            case 5:
                this.controller1.viewOldestCar();
                menucustomer();
            case 0:
                exit(0);
            default:
                System.out.println("Incorrect input , try to press a key between 0 and 5");
                menucustomer();
        }
    }

    public void menumechanic() {
        //menu for Mechanic
        System.out.println("\n");
        System.out.println("Options: ");
        System.out.println("Press key 1 to get the earnings ");
        System.out.println("Press key 2 to get the rating ");
        System.out.println("Press key 3 to get the carlist assigned to the mechanic ");
        System.out.println("Press key 4 to get the cars filtered by year ");
        System.out.println("Press key 5 to update a car");
        System.out.println("<<Press key 0 for log out>>");
        System.out.println("\n");


        System.out.println("Choose an option");
        Scanner myscanner = new Scanner(System.in);
        int choose = myscanner.nextInt();
        System.out.println("\n");

        switch (choose) {
            case 1:
                this.controller2.viewEarnings();
                menumechanic();
            case 2:
                this.controller2.viewRating();
                menumechanic();
            case 3:
                this.controller2.viewCarList();
                menumechanic();
            case 4:
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a year");
                int inputYear = scanner.nextInt();
                this.controller2.viewFilterByYear(inputYear);
                menumechanic();
            case 5:
                controller2.viewGetCars();
                System.out.println("What Id has the car you want to update?");
                int id = myscanner.nextInt();
                myscanner.nextLine();
                System.out.println("What brand is the car you want to update?");
                String brand = myscanner.nextLine();
                System.out.println("What model is the car you want to update?");
                String model = myscanner.nextLine();
                System.out.println("What manufacture Year has the car you want to update");
                int manufactureYear = myscanner.nextInt();
                myscanner.nextLine();
                System.out.println("What chassis Series has the car you want to update?");
                String chassisSeries = myscanner.nextLine();
                Car car = new Car(id, brand, model, manufactureYear, chassisSeries, false, newcustomer);
                car.setId(id);
                car.setBrand(brand);
                car.setModel(model);
                car.setManufactureYear(manufactureYear);
                car.setChassisSeries(chassisSeries);
                this.controller2.updateCar(car);
                menumechanic();
            case 0:
                exit(0);
            default:
                System.out.println("Incorrect input , try to press a key between 0 and 5");
                menumechanic();
        }
    }

}