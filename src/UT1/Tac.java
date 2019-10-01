package src.UT1;

public class Tac extends Thread{

    @Override
    public void run() {
        while(true) {
            System.out.println("TAC");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
