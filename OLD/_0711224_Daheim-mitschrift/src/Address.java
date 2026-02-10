public class Address {
    private String city;
    private String street;
    private int streeNumber;
    private int zipCode;

    public Address(String street, int streeNumber, int zipCode, String city) {
        this.street = street;
        this.streeNumber = streeNumber;
        this.zipCode = zipCode;
        this.city = city;
    }

    public String getStreet() {
        return this.street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreeNumber() {
        return this.streeNumber;
    }
    public void setStreeNumber(int streeNumber) {
        this.streeNumber = streeNumber;
    }

    public int getZipCode() {
        return this.zipCode;
    }
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.street + " ");
        sb.append(this.streeNumber + ", ");
        sb.append(this.zipCode + " " + this.city);

        return sb.toString();
    }

    public void main(String[] args) {
        Address address = new Address("Grazerstrasse", 203, 8430, "Leibniz");
        System.out.println(address.toString());
    }
}
