import Controller.CustomerController;
import Model.Customer;
import Model.Repository.InMemoCars;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.populate();
        menu.login();
    }
}