package Model.Repository;

import Model.Car;
import Model.Person;

import java.util.*;

public class InMemoUsers {
    private List<Person> users ;

    public InMemoUsers() {
        this.users = new ArrayList<>();
    }

    public List<Person> getUsers() {
        return users;
    }

    public void addUser(Person p){
        this.users.add(p);
    }

    public void removeUser(Person p){
        this.users.remove(p);
    }

}
