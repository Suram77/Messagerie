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
    
    public Server(){
        this.port = null;
    }
    
    public Server(Integer port){
        this.port = port;
        this.clientsConnectes = new ArrayList<ConnectedClient>();
    }
    
    public void addClient(ConnectedClient newClient){
        for (ConnectedClient unClient : clientsConnectes){
            unClient.sendMessage("Le client "+newClient.getId()+" vient de se connecter");
        }
        clientsConnectes.add(newClient);
    }
    
    public void broadcastMessage(String message, Integer id){
        for(ConnectedClient unClient : clientsConnectes){
            if(unClient.getId() != id){
                unClient.sendMessage("Message de "+id+" : "+message);
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
