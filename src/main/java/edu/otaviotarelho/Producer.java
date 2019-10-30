package edu.otaviotarelho;

public class Producer {

    public static void main(String[] args) {
        Address address = new Address("R. Luís Coelho - Consolação, São Paulo - SP", 223, "01309001");
	    User user = new User((long) 1, "Otavio", "Tarelho", 1994,
                        9, 16, "otavio.barros@avenuecode.com", address);

	    Address newAddress = new Address("O'Farrell St, San Francisco, CA, US", 26, "94108");

	    new UserService().updateUser(user, newAddress);

    }
}
