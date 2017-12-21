/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;
import java.util.*;

/**
 *
 * @author p1409881
 */
public class Server {
    private Integer port;
    private List<ConnectedClient> clientsConnectes; 
    private String listeClients;
    
    public Server(){
        this.port = null;
        listeClients = "";
    }
    
    public Server(Integer port){
        this.port = port;
        this.clientsConnectes = new ArrayList<ConnectedClient>();
        listeClients = "";
    }
    
    public void addClient(ConnectedClient newClient){
       clientsConnectes.add(newClient);
       listeClients += "Client"+newClient.getId()+"\n";
        for (ConnectedClient unClient : clientsConnectes){
            unClient.sendMessage("#c"+listeClients); // envoie liste clients
            unClient.sendMessage("#mLe client "+newClient.getId()+" vient de se connecter");
        }
    }
    
    public void broadcastMessage(String message, Integer id){
        System.out.println("Message du client "+id+" : "+message);
        if(message.equals("") == false)
        {
         for(ConnectedClient unClient : clientsConnectes){
             unClient.sendMessage("#mMessage du client "+id+" : "+message);
 //            if(unClient.getId() != id){
 //                unClient.sendMessage("Message de "+id+" : "+message);
 //            }
         }
       }
    }
    
    public void disconnectedClient(ConnectedClient discClient){
        for(ConnectedClient client : clientsConnectes){
            client.sendMessage("Le client "+discClient.getId()+" a quitté le chat");
        }
    }

    /**
     * @return the port
     */
    public Integer getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(Integer port) {
        this.port = port;
    }
}
