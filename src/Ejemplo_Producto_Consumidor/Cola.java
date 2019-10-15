package src.Ejemplo_Producto_Consumidor;

public class Cola {
    private int numero;
    private boolean disponible= false;
    private int turno=1;




    public synchronized int  get(int n){
        while(!disponible||n!=turno){
            try{
                wait();
            }catch (InterruptedException e){ }
        }
        disponible=false;
        if (turno==1){
            turno=2;
        }else{
            turno=1;
        }
                notify();
                return numero;
    }



    public synchronized void put(int valor, int numero){

        while(disponible|| numero!=turno){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("Proceso interumpido");
            }

        }

        this.numero=valor;
        disponible=true;
        notify();
    }
}
