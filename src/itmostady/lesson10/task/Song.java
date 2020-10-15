package itmostady.lesson10.task;

public class Song {
    private String name;
    private int length;
    private String author;
    private String country;

    public Song(String name, int length, String author, String country) {
        setName(name);
        setLength(length);
        setAuthor(author);
        setCountry(country);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 3)
            throw new IllegalArgumentException("name < 3");
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length < 10)
            throw new IllegalArgumentException("length < 10");
        this.length = length;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().length() < 2)
            throw new IllegalArgumentException("author < 2");
        this.author = author;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {
        if (country == null || country.trim().length() < 2)
            throw new IllegalArgumentException("country is null");
        this.country = country;
    }
}
