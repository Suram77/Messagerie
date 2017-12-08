/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;
import java.lang.*;
import java.lang.Object;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author p1712712
 */
public class Client {

    /**
     * @return the monInterface
     */
    public Interface getMonInterface() {
        return monInterface;
    }

    /**
     * @param monInterface the monInterface to set
     */
    public void setMonInterface(Interface monInterface) {
        this.monInterface = monInterface;
    }

    private Integer port;
    private String address;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private ClientSend clientSend;
    private ClientReceive clientReceive;
    private Interface monInterface;
    
    public Client(String address, Integer port) throws IOException{
        this.address = address;
        this.port = port;
        this.socket = new Socket();
        this.monInterface = new Interface(this);
        
//        this.in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
//        this.out = new PrintWriter(getSocket().getOutputStream());
//        this.clientSend = new ClientSend(out);
//        this.clientReceive = new ClientReceive(this,in);
    }
    
    public void disconnectedServer() throws IOException{
        this.in.close();
        this.out.close();
        this.getSocket().close();
        System.exit(0);
    }
    
    /**
     * @return the socket
     */
    public Socket getSocket() {
        return socket;
    }

    /**
     * @param socket the socket to set
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }


}
