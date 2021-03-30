package bin;

abstract public class Person {
    private int age;
    private String firstName, lastName;
    private String name = firstName+lastName;
    private char gender; // M or F


    public Person(){
        this.age = 0;
        this.firstName = "";
        this.lastName = "";
        this.gender = 0;
    }

    public Person(int _age, String _firstName, String _lastName, char _gender){
        if(_age > 0)
            this.age = _age;
        if(!_firstName.equals(""))
            this.firstName = _firstName;
        if(!_lastName.equals(""))
            this.lastName = _lastName;
        if(_gender == 'M' || _gender == 'F')
            this.gender = _gender;
        this.name = this.firstName + this.lastName;
    }

    public Person(Person person){
        setAge(person.age);
        setFirstName(person.firstName);
        setLastName(person.lastName);
        setGender(person.gender);
    }

    public void setAge(int age) {
        if(ageisValid(age))
            this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        if(firstnameisValid(firstName))
            this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        if(firstnameisValid(lastName)) {
            this.lastName = lastName;
            this.name = this.firstName + " " + this.lastName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setGender(char gender) {
        if(genderisValid(gender))
            this.gender = gender;
    }

    public char getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public boolean ageisValid(int age){
        if(age < 0) {
            System.out.println("Age cannot be a negative value!");
            return false;
        }
        return true;
    }

    public boolean firstnameisValid(String name){
        if(name.equals("")){
            System.out.println("Name cannot be an empty string!");
            return false;
        }
        return true;
    }

    public boolean genderisValid(char c){
        if(c != 'M' && c != 'F'){
            System.out.println("Please select M or F for the gender!");
            return false;
        }
        return true;
    }

}
