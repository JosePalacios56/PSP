package src.PingPong;

public class Main {
    public static void main(String[] args){
        PingPong hilo1 = new PingPong("PING");
        PingPong hilo2 = new PingPong("PONG");

        hilo1.start();
        hilo2.start();

    }
}
