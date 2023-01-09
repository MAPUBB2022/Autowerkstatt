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
    private Customer newcustomer;
    private Mechanic newmechanic;
    private InMemoCustomers customers = new InMemoCustomers();
    private InMemoMechanics mechanics = new InMemoMechanics();
    private CustomerView view1=new CustomerView();
    private MechanicView view2= new MechanicView();
    private CustomerController controller1=new CustomerController(newcustomer,view1);
    private MechanicController controller2= new MechanicController(newmechanic,view2);
    private InMemoRatings ratings = new InMemoRatings();

    /**
     * populates the system with enough data for it to be used
     */
    public void populate() {
        Customer customer1 = new Customer("Emil", "Pop", cars, ratings);
        Customer customer2 = new Customer("Cristian", "Popescu", cars, ratings);
        Customer customer3 = new Customer("Andrei", "Serban", cars, ratings);
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
        customer1.setOwned();
        customer2.setOwned();
        customer3.setOwned();

        Mechanic mechanic1 = new Mechanic("Matei", "Andreescu", 1900, cars, ratings);
        Mechanic mechanic2 = new Mechanic("Andrei", "Cernea", 2700, cars, ratings);
        mechanics.addMechanic(mechanic1);
        mechanics.addMechanic(mechanic2);
        Rating r1=new Rating(customer1,mechanic1,4);
        Rating r2=new Rating(customer2,mechanic1,4.5);
        Rating r3=new Rating(customer2,mechanic2,5);
        Rating r4=new Rating(customer1,mechanic2,4.5);
        ratings.addRating(r1);
        ratings.addRating(r2);
        ratings.addRating(r3);
        ratings.addRating(r4);
        mechanic1.setRating();
        mechanic2.setRating();
    }

    /**
     * with this function we determine the role and the user you want to be while using the application
     */
    public void login() {
        //populate();
        System.out.println("What role do you want to have?");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter key 1 for customer or enter key 2 for mechanic");
        int choose = scanner.nextInt();

        switch (choose) {
            case 1:
                for (Customer c : this.customers.getCustomers()) {
                        System.out.println(c.stringPerson());
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
                        System.out.println(m.stringPerson());
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

    /**
     * menu corresponding to a customer user; each case represents a feature you can use in this application
     */
    public void menucustomer() {

        //menu for Customer
        System.out.println("\n");
        System.out.println("Options: ");
        System.out.println("Press key 1 to add a car ");
        System.out.println("Press key 2 to delete a car ");
        System.out.println("Press key 3 to get the owned cars ");
        System.out.println("Press key 4 to assign mechanics ");
        System.out.println("Press key 5 to give a rating ");
        System.out.println("Press key 6 to remove a rating ");
        System.out.println("Press key 7 to update a rating ");
        System.out.println("Press key 8 to view ratings ");
        System.out.println("Press key 9 to view mechanics ");
        System.out.println("Press key 10 to find the oldest car ");
        System.out.println("Press key 11 to switch user ");
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
                this.controller1.addCar(car1); //adding a car to the repository
                this.controller1.setOwnedCars(); //setting the owned attribute of a customer after each car is added
                menucustomer();
            case 2:
                controller1.viewGetOwnedCars();
                System.out.println("What Id has the car you want to remove?");
                int id2 = scanner.nextInt();
                scanner.nextLine();
                for(Car c:controller1.getOwnedCars()){
                    if(c.getId()==id2){  //find the car by id
                        this.controller1.deleteCar(c);  //deleting car from repository
                        this.controller1.setOwnedCars(); //setting the owned attribute of a customer after each car is removed
                        for(Mechanic me:this.mechanics.getMechanics()){
                            me.setCarList();  //setting the list of cars assigned to each mechanic to be repaired
                                              //after each car is deleted
                        }
                    }
                }
                menucustomer();
            case 3:
                this.controller1.viewGetOwnedCars();  //displays the cars owned by the customer
                menucustomer();
            case 4:
                this.controller1.viewGetOwnedCars();
                List<Mechanic> list=new ArrayList<>();
                System.out.println("What Id has the car you want to assign mechanics to?");
                int id3=scanner.nextInt();
                scanner.nextLine();
                for(Car c:controller1.getOwnedCars()){
                    if(c.getId()==id3){   //find the car by id
                        this.controller1.viewPrintMechanics(this.mechanics.getMechanics());
                        System.out.println("How many mechanics do you want to choose?");
                        int nr=scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Please give in the chosen mechanics ");
                        while (nr!=0){
                            System.out.println("What first name has the mechanic?");
                            String firstname = scanner.nextLine();
                            System.out.println("What last name has the mechanic?");
                            String lastname = scanner.nextLine();
                            Mechanic themechanic = null;
                            for (Mechanic m : this.mechanics.getMechanics()) {
                                if (Objects.equals(m.getFirstName(), firstname) && Objects.equals(m.getLastName(), lastname)) {
                                    list.add(m); //if the mechanic is found add him to a list
                                }
                            }
                            nr=nr-1;
                        }
                        Car aux=new Car(c.getId(),c.getBrand(),c.getModel(),c.getManufactureYear(),c.getChassisSeries(),false,c.getOwned());
                        aux.setAssigned(list);
                        this.controller1.updateCar(aux); //update the cars repair status and list of assigned mechanics
                        for(Mechanic mch:list){
                            mch.setCarList();
                        }
                    }
                }
                menucustomer();
            case 5:
                Scanner scn=new Scanner(System.in);
                this.controller1.viewPrintMechanics(this.mechanics.getMechanics());
                System.out.println("What first name has the mechanic?");
                String firstname = scn.nextLine();
                System.out.println("What last name has the mechanic?");
                String lastname = scn.nextLine();
                Mechanic themechanic = null;
                for (Mechanic m : this.mechanics.getMechanics()) {
                    if (Objects.equals(m.getFirstName(), firstname) && Objects.equals(m.getLastName(), lastname)) {
                        themechanic = m;  //find the mechanic
                    }
                }
                System.out.println("What value has the rating?");
                double value = scn.nextDouble();
                Rating rating = new Rating(newcustomer, themechanic, value); //create a rating with the given mechanic and value
                this.controller1.giveRating(rating); //add rating to repository
                themechanic.setRating();  //calculate the average rating for the mechanic
                menucustomer();
            case 6:
                Scanner sc=new Scanner(System.in);
                this.controller1.viewPrintMechanics(this.mechanics.getMechanics());
                System.out.println("What first name has the mechanic?");
                String fname = sc.nextLine();
                System.out.println("What last name has the mechanic?");
                String lname = sc.nextLine();
                Mechanic mechanic1 = null;
                for (Mechanic m : this.mechanics.getMechanics()) {
                    if (Objects.equals(m.getFirstName(), fname) && Objects.equals(m.getLastName(), lname)) {
                        mechanic1 = m;  //find the mechanic
                    }
                }
                List<Rating> aux1=new ArrayList<>();
                for(Rating r:this.ratings.getRatings()){
                    if(r.getCust()==this.newcustomer && r.getMech()==mechanic1){
                        aux1.add(r);   //find the rating
                    }
                }
                for(Rating rt:aux1){
                    this.controller1.removeRating(rt);  //remove the rating
                    mechanic1.setRating();  //calculate average rating for the mechanic
                }
                menucustomer();
            case 7:
                Scanner scan=new Scanner(System.in);
                this.controller1.viewPrintMechanics(this.mechanics.getMechanics());
                System.out.println("What first name has the mechanic?");
                String finame = scan.nextLine();
                System.out.println("What last name has the mechanic?");
                String laname = scan.nextLine();
                Mechanic mechanic2 = null;
                for (Mechanic m : this.mechanics.getMechanics()) {
                    if (Objects.equals(m.getFirstName(), finame) && Objects.equals(m.getLastName(), laname)) {
                        mechanic2 = m;  //find the mechanic
                    }
                }
                for(Rating r:this.ratings.getRatings()){
                    if(r.getCust()==this.newcustomer && r.getMech()==mechanic2){
                        System.out.println("What value has the rating?");
                        double val = scan.nextDouble();
                        Rating aux=new Rating(r.getCust(),r.getMech(),val);  //set the new value for the rating
                        this.controller1.updateRating(aux);
                        mechanic2.setRating();  //calculate average rating for the mechanic
                    }
                }

                menucustomer();
            case 8:
                List<Rating> lst=new ArrayList<>();
                for(Rating rt:this.ratings.getRatings()){
                    if(rt.getCust()==newcustomer){
                        lst.add(rt);
                    }
                }
                this.controller1.viewRatings(lst); //display the ratings with the customers name
                menucustomer();
            case 9:
                this.controller1.viewPrintMechanics(this.mechanics.getMechanics());  //display the available mechanics
                menucustomer();
            case 10:
                this.controller1.viewOldestCar();  //display the oldest car the customer has
                menucustomer();
            case 11:
                login();  //use login function to switch user
            case 0:
                exit(0);
            default:
                System.out.println("Incorrect input , try to press a key between 0 and 11");
                menucustomer();
        }
    }

    /**
     * menu corresponding to a mechanic user;  each case represents a feature you can use in this application
     */
    public void menumechanic() {
        //menu for Mechanic
        System.out.println("\n");
        System.out.println("Options: ");
        System.out.println("Press key 1 to get the earnings ");
        System.out.println("Press key 2 to get the rating ");
        System.out.println("Press key 3 to get the carlist assigned to the mechanic ");
        System.out.println("Press key 4 to get the cars filtered by maximum year ");
        System.out.println("Press key 5 to update a car");
        System.out.println("Press key 6 to switch user ");
        System.out.println("<<Press key 0 for log out>>");
        System.out.println("\n");


        System.out.println("Choose an option");
        Scanner myscanner = new Scanner(System.in);
        int choose = myscanner.nextInt();
        System.out.println("\n");

        switch (choose) {
            case 1:
                this.controller2.viewEarnings();  //display earnings
                menumechanic();
            case 2:
                this.controller2.viewRating();  //display average rating
                menumechanic();
            case 3:
                this.controller2.viewCarList();  //display list of cars assigned to the mechanic
                menumechanic();
            case 4:
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a year");
                int inputYear = scanner.nextInt();
                this.controller2.viewFilterByYear(inputYear);  //display cars older than the given year
                menumechanic();
            case 5:
                controller2.viewGetCars();
                List<Mechanic> list=new ArrayList<>();
                System.out.println("What Id has the car you want to update?"); //updating means the car has been repaired
                int id = myscanner.nextInt();
                myscanner.nextLine();
                for(Car c:this.controller2.getCars()){
                    if(c.getId()==id) {  //find car by id
                        Car aux=new Car(c.getId(),c.getBrand(),c.getModel(),c.getManufactureYear(),c.getChassisSeries(),c.isRepaired(),c.getOwned());
                        aux.setRepaired(true);
                        aux.setAssigned(list);
                        this.controller2.updateCar(aux);  //set repair status to true
                        this.controller1.updateCar(aux);  //list of assigned mechanics is going to be empty, because the car is now repaired
                        for(Mechanic mech:this.mechanics.getMechanics()){
                            mech.setCarList();  //set the list of assigned cars for the corresponding mechanic
                        }
                    }
                }
                menumechanic();
            case 6:
                login();  //use login function to switch user
            case 0:
                exit(0);
            default:
                System.out.println("Incorrect input , try to press a key between 0 and 6");
                menumechanic();
        }
    }

}