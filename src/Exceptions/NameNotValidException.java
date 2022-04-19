package Exceptions;

//exception
public class NameNotValidException extends Exception {

    private String name;

    public NameNotValidException(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
