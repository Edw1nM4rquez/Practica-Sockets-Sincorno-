/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Edwin
 */
public class Cliente implements Runnable {
   private int puerto;
   private String mensaje;
   
   public Cliente(int puerto, String mensaje){
       this.puerto = puerto;
       this.mensaje = mensaje;
   }

    @Override
    public void run() {
          final String HOST = "127.0.0.1";
          DataOutputStream out;
        
    
        try {
            
            Socket sc= new Socket(HOST, puerto);
           
            out =new DataOutputStream(sc.getOutputStream());
            
            out.writeUTF(mensaje);
                       
            sc.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
