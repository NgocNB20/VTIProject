package entity;

public class Person {
    private String phone;
    private String name;
    private String dateOfBirth;
    private String place;

    public Person() {
    }

    public Person(String phone, String name, String dateOfBirth, String place) {
        this.phone = phone;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.place = place;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Person{" +
                "phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
