/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;

/**
 *
 * @author p1409881
 */
public class ClientReceive implements Runnable{
    private Client client;
    private BufferedReader in;
    
    public ClientReceive(Client client, BufferedReader in)
    {
        this.client = client;
        this.in = in;
    }
    
    @Override
    public void run()
    {
        boolean isActive = true ;
        while(isActive) {
            try{
            String message = in.readLine();
            if (message != null) {
            System.out.println("\nMessage reçu : " + message);
            } else {
            isActive = false;
            }
            }
            catch (Exception e){
                
            }
        }
        try{
        client.disconnectedServer();
        }
        catch (Exception e){
            
        }
    }
}

