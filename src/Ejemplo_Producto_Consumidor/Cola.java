package src.Ejemplo_Producto_Consumidor;

public class Cola {
    private int numero;
    private boolean disponible= false;

    public int get(){
        if (disponible) {
            disponible=false;
            return numero;
        }
        return -1;
    }
    public void put(int valor){
        numero=valor;
        disponible=true;
    }
}
