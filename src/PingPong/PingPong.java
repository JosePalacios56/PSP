package src.PingPong;

public class PingPong extends Thread{

    private String mensage;
    private static String turno;

    public PingPong(String mensage){
        this.mensage=mensage;
    }

    public void run(){
        while(true){
            playTurn();
            try{
                sleep(500);
            }catch(InterruptedException e){

            }
        }
    }
    public synchronized void playTurn(){
        if(!mensage.equals(turno)){
            turno=mensage;
            System.out.println(mensage);
        }
    }

}
