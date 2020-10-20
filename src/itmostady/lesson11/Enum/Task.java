package itmostady.lesson11.Enum;

public class Task {
    public static void main(String[] args) {
        Planet[] planets = Planet.values();
        for (Planet planet : planets) {
            System.out.println(planet + "\n" + planet.getInfo());
        }
    }
}

enum Planet{
    EARTH(20, 600, 1666), MARS(40, 1000, 10000),
    VENUS(10, 100, 200);
    private final int weight;
    private final int radPlanet;
    private final int radOrbit;

    Planet(int weight, int radPlanet, int radOrbit) {
        this.weight = weight;
        this.radPlanet = radPlanet;
        this.radOrbit = radOrbit;
    }

    public int getWeight() {
        return weight;
    }

    public int getRadPlanet() {
        return radPlanet;
    }

    public int getRadOrbit() {
        return radOrbit;
    }

    String getInfo(){
         return "масса " + getWeight() + "\n" + "Радиус планеты " + getRadPlanet() + "\n"
                 + "Радиус орбиты " + getRadOrbit();
    }
}
