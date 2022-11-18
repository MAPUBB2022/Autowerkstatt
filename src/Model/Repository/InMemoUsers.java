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
        boolean found = false;
        for (Person person:this.users){
            if(Objects.equals(person.getFirstName(), p.getFirstName()) && Objects.equals(person.getLastName(), p.getLastName())) {
                found = true;
                throw new RuntimeException();
            }
        }
        if(!found){
            this.users.add(p);
        }
    }

    public void removeUser(Person p){
        boolean deleted = false;
        for (Person person:this.users){
            if(Objects.equals(person.getFirstName(), p.getFirstName()) && Objects.equals(person.getLastName(), p.getLastName())) {
                deleted = true;
                this.users.remove(p);
            }
        }
        if(!deleted){
            throw new RuntimeException();
        }
    }
}
