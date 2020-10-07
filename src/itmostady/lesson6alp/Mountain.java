package itmostady.lesson6alp;

public class Mountain {
    private String name;
    private String country;
    private int height;

    public Mountain(){}

    public Mountain(String name){
        setName(name);
    }

    public Mountain(String name, String country){
        setName(name);
        setCountry(country);
    }

    public Mountain(String name, String country, int height){
        setName(name);
        setCountry(country);
        setHeight(height);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 3)
            throw new IllegalArgumentException("name должен быть не меньше 4");
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country == null || country.trim().length() < 3)
            throw new IllegalArgumentException("country должен быть не меньше 4");
        this.country = country;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 100)
            throw new IllegalArgumentException("height должена быть не меньше 100");
        this.height = height;
    }



    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", height=" + height +
                '}';
    }
}
