package itmostady.lessonException.HomeTask1;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException, AccessDeniedException, JarException {
        try{
            throwException(Status.FILE_NOT_FOUND);
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            throwException(Status.ACCESS_DENIED);
        }catch (AccessDeniedException e){
            System.out.println(e.getMessage());
        }
        try{
            throwException(Status.JAR_ERROR);
        }catch (JarException e){
            System.out.println(e.getMessage());
        }

    }
    public static void throwException(Status status) throws FileNotFoundException, AccessDeniedException, JarException {
            if (status.equals(Status.FILE_NOT_FOUND))
                throw new FileNotFoundException("Файл не найден");
            if (status.equals(Status.ACCESS_DENIED))
                throw new AccessDeniedException("Проблемы с доступом");
            if (status.equals(Status.JAR_ERROR))
                throw new JarException("Проблемы с наполнением");
    }
}


enum Status{
    FILE_NOT_FOUND, ACCESS_DENIED, JAR_ERROR
}
