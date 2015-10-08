/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Joe
 */
public class messageListner extends Thread 
{
    
    ServerSocket server;
    int port;
    WritableGUI gui;
    
    public messageListner(WritableGUI gui, int port) {
        this.port = port;
        this.gui = gui;
        
        try
        {
             server = new ServerSocket(port);
        }
        catch(IOException ex)
        {
                    
//            Logger.getLogger(messageListner.class.getName()).log(level.SEVERE, null, ex)
        }
       
        
    }
    public messageListner(){
        
        try
        {
            server = new ServerSocket(port);
            
        }
        catch(IOException ex)
        {
            
        }
        
    }
        
    
    @Override
    public void run()
    {
             Socket clientSocket;
        
        try
        {
            while((clientSocket = server.accept()) != null)
            {
                InputStream is = clientSocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = br.readLine();
                if(line != null)
                {
                    gui.write(line);
                }
            }
            
        }  
        catch(IOException ex)
        {
            
            
        }
        
    }
 
            
        
    
     
}
    
  

        
   

