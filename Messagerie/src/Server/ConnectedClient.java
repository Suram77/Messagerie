/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;
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
    
    public ConnectedClient(Server serv,Socket sock) throws IOException{
        this.server = serv;
        this.socket = sock;
        this.id = idCounter;
        in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
        out = new PrintWriter(getSocket().getOutputStream());
        System.out.println("Nouvelle connexion, id = " + id);
    }
    @Override
    public void run(){
        String message = "";
        boolean isActive = true;
        while (isActive){
            try{
            message = getIn().readLine();
            if (message != "")
            {
                    getServer().broadcastMessage(message, getId());
            }
            else
            {
                    getServer().disconnectedClient(this);
                isActive = false;
            }
            }
            catch (Exception e){
                
            }
        }
    }
    public void sendMessage(String m){
        this.getOut().println(m);
        this.getOut().flush();
    }
    public void closeClient(){
        try{
        this.getIn().close();
        this.getOut().close();
        this.getSocket().close();
        }
        catch(Exception e){
            
        }
    }
    
    
    /**
     * @return the idCounter
     */
    public static int getIdCounter() {
        return idCounter;
    }

    /**
     * @param aIdCounter the idCounter to set
     */
    public static void setIdCounter(int aIdCounter) {
        idCounter = aIdCounter;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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

    /**
     * @return the in
     */
    public BufferedReader getIn() {
        return in;
    }

    /**
     * @param in the in to set
     */
    public void setIn(BufferedReader in) {
        this.in = in;
    }

    /**
     * @return the out
     */
    public PrintWriter getOut() {
        return out;
    }

    /**
     * @param out the out to set
     */
    public void setOut(PrintWriter out) {
        this.out = out;
    }
}
