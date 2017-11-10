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
import java.io.*;
import java.io.PrintWriter;
import java.io.InputStreamReader;

/**
 *
 * @author p1409881
 */
public class ConnectedClient implements Runnable{
    // il va permettre d’attribuer des identifiants uniques à chaque client. 
    // C’est simplement un compteur d’instances crées
    private static int idCounter;
    //identifiant du client
    private int id;
    private Server server;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    
    public ConnectedClient(Server serv,Socket sock){
        this.server = serv;
        this.socket = sock;
        this.id = idCounter;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());
        System.out.println("Nouvelle connexion, id = " + id);
    }
    @Override
    public void run(){
        String message = "";
        boolean isActive = true;
        while (isActive){
            try{
            message = in.readLine();
            if (message != "")
            {
                server.broadcastMessage(message,id);
            }
            else
            {
                server.disconnectedClient(this);
                isActive = false;
            }
            }
            catch (Exception e){
                
            }
        }
    }
    public void sendMessage(String m){
        this.out.println(m);
        this.out.flush();
    }
    public void closeClient(){
        this.in.close();
        this.out.close();
        this.socket.close();
    }
}
