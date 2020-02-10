package src.Tema4;

import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import java.io.IOException;
import java.io.Writer;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

public class Actividad4_4 {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnrecoverableKeyException,
            KeyStoreException, InvalidKeyException, InvalidKeySpecException {

        // se crea cliente SMTP seguro
        AuthenticatingSMTPClient client = new AuthenticatingSMTPClient();
        Scanner sc= new Scanner(System.in);
    System.out.println("Actividad 4.4");
        // datos del usuario y del servidor
        String server = "smtp.gmail.com";
        System.out.println("dime tu nombre de usuario(el correo electronico)");
        String username = sc.next();
        System.out.println("Dime la contraseña");
        String password = sc.next();
        int puerto = 587;
        System.out.println("Dime el correo del remitente");
        String remitente = sc.next();

        try {
            int respuesta;

            // Creaci�n de la clave para establecer un canal seguro
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(null, null);
            KeyManager km = kmf.getKeyManagers()[0];

            // nos conectamos al servidor SMTP
            client.connect(server, puerto);
            System.out.println("1 - " + client.getReplyString());
            // se establece la clave para la comunicaci�n segura
            client.setKeyManager(km);

            respuesta = client.getReplyCode();
            if (!SMTPReply.isPositiveCompletion(respuesta)) {
                client.disconnect();
                System.err.println("CONEXI�N RECHAZADA.");
                System.exit(1);
            }

            // se env�a el commando EHLO
            client.ehlo(server);// necesario
            System.out.println("2 - " + client.getReplyString());

            // NECESITA NEGOCIACI�N TLS - MODO NO IMPLICITO
            // Se ejecuta el comando STARTTLS y se comprueba si es true
            if (client.execTLS()) {
                System.out.println("3 - " + client.getReplyString());

                // se realiza la autenticaci�n con el servidor
                if (client.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, username, password)) {
                    System.out.println("4 - " + client.getReplyString());
                    System.out.println("dime el correo destinatario");
                    String destino1 = sc.next();
                    System.out.println("Dime el asunto del correo");
                    String asunto = sc.nextLine()+sc.nextLine();
                    System.out.println("Dime el mensaje del correo");
                    String mensaje = sc.nextLine()+sc.nextLine();
                    // se crea la cabecera
                    SimpleSMTPHeader cabecera = new SimpleSMTPHeader(remitente, destino1, asunto);

                    // el nombre de usuario y el email de origen coinciden
                    client.setSender(remitente);
                    client.addRecipient(destino1);
                    System.out.println("5 - " + client.getReplyString());

                    // se envia DATA
                    Writer writer = client.sendMessageData();
                    if (writer == null) { // fallo
                        System.out.println("FALLO AL ENVIAR DATA.");
                        System.exit(1);
                    }

                    writer.write(cabecera.toString()); // cabecera
                    writer.write(mensaje);// luego mensaje
                    writer.close();
                    System.out.println("6 - " + client.getReplyString());

                    boolean exito = client.completePendingCommand();
                    System.out.println("7 - " + client.getReplyString());

                    if (!exito) { // fallo
                        System.out.println("FALLO AL FINALIZAR TRANSACCI�N.");
                        System.exit(1);
                    } else
                        System.out.println("MENSAJE ENVIADO CON EXITO......");

                } else
                    System.out.println("USUARIO NO AUTENTICADO.");
            } else
                System.out.println("FALLO AL EJECUTAR  STARTTLS.");

        } catch (IOException e) {
            System.err.println("Could not connect to server.");
            e.printStackTrace();
            System.exit(1);
        }
        try {
            client.disconnect();
        } catch (IOException f) {
            f.printStackTrace();
        }

        System.out.println("Fin de env�o.");
        System.exit(0);
    }// main
}// ..ClienteSMTP3
