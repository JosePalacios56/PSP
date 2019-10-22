package src.CuentaBancaria;
public class Persona extends Thread{
    String nombre;
    Cuenta cuenta;
    String movimiento;

    //CONSTRUCTOR
    public Persona(String nombre,Cuenta cuenta,String movimiento) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.movimiento = movimiento;
    }

    @Override
    public void run(){
        super.run();
        for(int i =0; i<2; i++) {
            if (movimiento.equalsIgnoreCase("Reintegro")) {
                double reinte = Math.random() * 1000 + 1;
                cuenta.reintegro(reinte);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(nombre + " ha retirado " + reinte);
                System.out.println(nombre + " salario actual " + cuenta.obtenerSaldo());
            } else if (movimiento.equalsIgnoreCase("Ingreso")) {
                double ingre = Math.random() * 1000 + 1;
                cuenta.ingreso(ingre);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(nombre + " ha ingresado " + ingre);
                System.out.println(nombre + " salario actual " + cuenta.obtenerSaldo());
            }
        }
    }
}
