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
        if(_firstName != "")
            this.firstName = _firstName;
        if(_lastName != "")
            this.lastName = _lastName;
        if(_gender == 'M' || _gender == 'F')
            this.gender = _gender;
        this.name = this.firstName + this.lastName;
    }

    public void setAge(int age) {
        if(age > 0)
            this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        if(firstName != "")
            this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        if(lastName != "")
            this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setGender(char gender) {
        if(gender == 'M' || gender == 'F')
            this.gender = gender;
    }

    public char getGender() {
        return gender;
    }



}
