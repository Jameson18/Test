package itmostady.lessonException.HomeTask1;

public class TextException extends Exception{
    public TextException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " Message HERE!!!";
    }
}
