package src.UT2;

public class Main {
    public static void main(String[]args) {

        Cliente cliente1 = new Cliente("Cliente1",new int[]{2,2,1,5,2,3});
        Cliente cliente2 = new Cliente("Cliente2",new int[]{1,3,5,1,1});
        long initialTime=System.currentTimeMillis();
        Cajera cajera1=new Cajera("Cajera1");
        Cajera cajera2=new Cajera("Cajera2");


        cajera1.procesarCompra(cliente1, initialTime);
        cajera2.procesarCompra(cliente2,initialTime);

        
    }


}
