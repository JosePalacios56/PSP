package src.UT1;

public class Tic extends Thread {

    public void run() {
        while (true) {
            System.out.println("TIC");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
