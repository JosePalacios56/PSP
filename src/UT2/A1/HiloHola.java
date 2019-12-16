package src.UT2.A1;

public class HiloHola extends Thread{

    public static void main(String[] args){
        HiloHola h= new HiloHola(1);
        HiloHola h2= new HiloHola(2);
        HiloHola h3= new HiloHola(3);
        HiloHola h4= new HiloHola(4);
        HiloHola h5= new HiloHola(5);

        h.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
    }


   private int x;

    public HiloHola(int x){
        this.x=x;
    }

    public void run() {
            System.out.println("Hola Mundo "+x);
    }
}
