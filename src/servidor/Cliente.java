package servidor;

/**
 *
 * @author Ellioth
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente extends Thread{
    
    private Socket socket;
    //private DataInputStream Datos_Entrada;
    private DataOutputStream Datos_Salida;
    private int puerto;
    private boolean bandera;
    private String ip;
    private String mensaje;
    private  int id;;
    
    public Cliente(String ip, int puerto, int id){
        mensaje="";
        this.ip= ip;
        bandera= true;
        this.puerto= puerto;
        this.id= id;
    }
    
    @Override
    public void run(){
        try{
            socket= new Socket(ip, puerto);
            //Datos_Entrada= new DataInputStream(socket.getInputStream());
            Datos_Salida= new  DataOutputStream(socket.getOutputStream());
            //if(mensaje.length()>0){}
            System.out.println("escriba un mensaje");
            Datos_Salida.writeUTF((new Scanner(System.in)).nextLine());
            Datos_Salida.flush();
            System.out.println("usuario"+ id + "mensaje enviado");
            mensaje= Datos_Salida.toString();
            if(mensaje.equals("out")){
                //Datos_Entrada.close();    
                Datos_Salida.close();
                socket.close();
            }
        }catch(IOException e){
            System.out.print(e);
        }
    }
    
    public void getMensaje(String mensaje){
        this.mensaje=mensaje;
    }
    
    public String setMensaje(){
        return mensaje;
    }
    
    public void setBandera(boolean bandera){
        this.bandera= bandera;
    }
    
    public static void main(String[] args) {
        Cliente id= new Cliente("192.168.1.104", 5005,2 );
        id.start();
    }
   
}
