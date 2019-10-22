package src.CuentaBancaria1;

public class Cuenta {
    double saldo;
    int valorMaximo;

//GETTERS Y SETTERS

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setValorMaximo(int valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getValorMaximo() {
        return valorMaximo;
    }

    //CONSTRUCTOR
    public  Cuenta(int saldo, int valorMaximo){
        this.saldo = saldo;
        this.valorMaximo = valorMaximo;
    }
    //METODOS DE LA CUENTA
    public synchronized double obtenerSaldo(){
        return this.saldo;
    }
    public synchronized void ingreso(double ingreso){
        if(ingreso+saldo > valorMaximo){
            System.out.println("No se puede ingresar tal cantidad supera el valor maximo");
        }
        this.saldo = saldo + ingreso;
    }
    public synchronized void reintegro(double reintegro){
        if((saldo-reintegro) < 0){
            System.out.println("No se puede retirar tal cantidad de dinero");
        }
        this.saldo = saldo - reintegro;
    }
}
