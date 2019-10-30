package edu.otaviotarelho;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer yearOfBirth;
    private Integer monthOfBirth;
    private Integer dayOfBirth;
    private String email;
    private Address address;

    public User(Long id, String firstName, String lastName, Integer yearOfBirth, Integer monthOfBirth,
                Integer dayOfBirth, String email, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.dayOfBirth = dayOfBirth;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public Integer getMonthOfBirth() {
        return monthOfBirth;
    }

    public Integer getDayOfBirth() {
        return dayOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void updateUserGenerals(User user){
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.yearOfBirth = user.yearOfBirth;
        this.monthOfBirth = user.dayOfBirth;
        this.email = user.email;
    }

    public void updateUserAddress(Address address){
        this.address = address;
    }
}
