/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;
import java.lang.*;
import java.lang.Object;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author p1409881
 */
public class Connection implements Runnable {
    private Server server;
    private ServerSocket serverSocket;
    
    public Connection(Server monServ)
    {
        this.server = monServ;
        this.serverSocket = new ServerSocket(server.getPort());
    }
    
    @Override
    public void run()
    {
        while(1 == 1)
        {
            Socket sockNewClient = serverSocket.accept();
            try{
            ConnectedClient newClient = new ConnectedClient(server,sockNewClient);
            server.addClient(newClient);
            Thread threadNewClient = new Thread(newClient);
            threadNewClient.start();
            }
            catch(Exception e)
            {
                
            }
        }
    }
}
