package UT1.EjercicioTic_Tac;

public class Tic {

    public void run(){
        System.out.println("TIC");
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
