package pt.ipca.androidbookdwm;

public class Address {

    //Variaveis
    private String streetName,postalCode;
    private int doorNo;

    //Construtor
    public Address(String streetName, String postalCode, int doorNo) {
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.doorNo = doorNo;
    }

    //Metodos

    public String getStreetName() {
        return streetName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getDoorNo() {
        return doorNo;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setDoorNo(int doorNo) {
        this.doorNo = doorNo;
    }
}