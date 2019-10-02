package src.UT2;

public class Cajera {
    private String nombre;


    public Cajera(String nombre) {
        this.nombre = nombre;
    }
    public void procesarCompra(Cliente cliente, long timeStamp){
        System.out.println("La cajera "+this.nombre+
                "COMIENZA A PROCESAR LA COMPRA DEL CLIENTE"+cliente.getNombre()+
                "EN EL TIEMPO"+ (System.currentTimeMillis()-timeStamp)/1000+" seg");

        for(int i=0<cliente.getCarroCompra().length;i++){
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto");
        }


    }
}
