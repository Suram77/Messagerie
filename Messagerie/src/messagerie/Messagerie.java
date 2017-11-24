/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagerie;
import Client.*;
import Server.*;
import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author p1712712
 */
public class Messagerie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainClient prog = new MainClient();
        String[] myargs = new String[2];
        myargs[0] = "127.0.0.1";
        myargs[1] = "1050";
////        Création du serveur
////        Server monServ = new Server(Integer.parseInt("1049"));
////        Création du client
////        try{
////        Client client1 = new Client(myargs[0],Integer.parseInt("1049"));
        prog.main(myargs);
////        ConnectedClient clientConnected1 = new ConnectedClient(monServ,client1.getSocket());
////        monServ.addClient(clientConnected1);
////        }
////        catch (Exception e)
////        {
////            
////        }

    }
    
}
