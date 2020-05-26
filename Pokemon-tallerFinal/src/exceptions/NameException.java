package exceptions;

public class NameException extends Exception {

    public NameException() {

        super("El numero de carateres debe estar entre 3 y 12 \n Porfavor ingrese un nuevo nombre");

    }
}
