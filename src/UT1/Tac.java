package UT1.EjercicioTic_Tac;

public class Tac extends Thread{

    @Override
    public void run() {
        super.run();
        System.out.println("TAC");
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
