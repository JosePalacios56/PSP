package src.UT2.A2;

import static java.lang.Thread.sleep;

public class HolaRunnable implements Runnable {

    public static void main(String[] args){

        HolaRunnable h1= new HolaRunnable("A",10);
        Thread h11= new Thread(h1);

        HolaRunnable h2= new HolaRunnable("B",20);
        Thread h22= new Thread(h2);

        HolaRunnable h3= new HolaRunnable("C",30);
        Thread h33=new Thread(h3);

        HolaRunnable h4= new HolaRunnable("D",40);
        Thread h44= new Thread(h4);

        HolaRunnable h5= new HolaRunnable("E",50);
        Thread h55=new Thread(h5);

        h11.start();
        h22.start();
        h33.start();
        h44.start();
        h55.start();


    }

    private String x;
    private int y;
    public HolaRunnable(String x, int y){

        this.x=x;
        this.y=y;
    }

    public void run() {


        try {
            sleep(y);
            System.out.println("Hola Mundo "+x );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
