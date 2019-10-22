package src.CuentaBancaria2;

public class Main {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(100, 10000);
        Persona persona1 = new Persona("Persona1", cuenta, "Ingreso");
        Persona persona2 = new Persona("Persona2", cuenta, "Reintegro");

        persona1.start();
        persona2.start();
    }
}