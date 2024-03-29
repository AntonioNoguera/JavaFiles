package testHama;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DemoServer{

     public static void main(String[] args) throws Exception{

         ObjectInputStream ois = null;
         ObjectOutputStream oos = null;

         Socket s = null;
         ServerSocket ss = new ServerSocket(5432);

         while( true ){

             System.out.println("Esperando Conexion!: ");
             try {

                 // el ServerSocket me da el Socket
                 s = ss.accept();
                 // informacion en la consola
                 System.out.println("Se conectaron desde la IP: " +s.getInetAddress());

                 // enmascaro la entrada y salida de bytes
                 ois = new ObjectInputStream( s.getInputStream() );
                 oos = new ObjectOutputStream( s.getOutputStream() );

                 // leo el nombre que envia el cliente
                 String nom = (String)ois.readObject();

                 // armo el saludo personalizado que le quiero enviar
                 String saludo = "Hola Mundo ("+nom+") _ "+System.currentTimeMillis();

                 // envio el saludo al cliente
                 oos.writeObject(saludo);
                 System.out.println("Saludo enviado...");

             }catch(Exception ex){

                 ex.printStackTrace();

             }finally{

                 if( oos !=null ) oos.close(); 
                 if( ois !=null ) ois.close(); 
                 if( s != null ) s.close();

                 System.out.println("Conexion cerrada!");
             }
         }
     }
}