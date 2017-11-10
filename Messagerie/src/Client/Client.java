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

/**
 *
 * @author p1712712
 */
public class Client {
    private Integer port;
    private String address;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    
    public Client(String address, Integer port){
        this.address = address;
        this.port = port;
    }
    
    public void disconnectedServer() throws IOException{
        this.in.close();
        this.out.close();
        this.socket.close();
        System.exit(0);
    }
}
