package itmostady.lesson6alp;

public class Alpinist {
    private String name;
    private String address;

    public Alpinist(){}

    public Alpinist(String name){
        setName(name);
    }
    public Alpinist(String name, String address){
        setName(name);
        setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 3)
            throw new IllegalArgumentException("name должен быть не меньше 3");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().length() < 5)
            throw new IllegalArgumentException("address должен быть не меньше 5");
        this.address = address;
    }
    public String getAlpInfo(){
        return name + " " + address;
    }

    @Override
    public String toString() {
        return "Alpinist{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
