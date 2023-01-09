package Model;

public abstract class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * used to display the attributes in View-Layer and others
     * @return the attributes of the object
     */
    public String stringPerson(){
        return "(Firstname:"+this.getFirstName()+", Lastname:"+this.getLastName()+")"+"\n";
    }
}
