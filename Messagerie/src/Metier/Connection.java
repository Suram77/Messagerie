/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;
import java.io.IOException;
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
    
    public Connection(Server monServ) throws IOException
    {
        this.server = monServ;
        this.serverSocket = new ServerSocket(getServer().getPort());
    }
    
    @Override
    public void run()
    {
        while(1 == 1)
        {
            try{
            Socket sockNewClient = getServerSocket().accept();
            ConnectedClient newClient = new ConnectedClient(getServer(),sockNewClient);
                getServer().addClient(newClient);
            Thread threadNewClient = new Thread(newClient);
            threadNewClient.start();
            }
            catch(Exception e)
            {
                
            }
        }
    }
    
    /**
     * @return the server
     */
    public Server getServer() {
        return server;
    }

    /**
     * @param server the server to set
     */
    public void setServer(Server server) {
        this.server = server;
    }

    /**
     * @return the serverSocket
     */
    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    /**
     * @param serverSocket the serverSocket to set
     */
    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
}
