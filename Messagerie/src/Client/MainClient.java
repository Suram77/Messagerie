/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.IOException;
import java.net.UnknownHostException;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import Server.*;
import messagerie.Messagerie;


/**
 *
 * @author p1409881
 */

public class MainClient extends Application{
    public static void main(String[] args) {    
            MainClient prog = new MainClient();
            String[] myargs = new String[2];
            myargs[0] = "127.0.0.1";
            myargs[1] = "1050";
            Application.launch(MainClient.class,myargs);
    //        Création du client

    ////        try{
    ////        Client client1 = new Client(myargs[0],Integer.parseInt("1049"));

    ////        ConnectedClient clientConnected1 = new ConnectedClient(monServ,client1.getSocket());
    ////        monServ.addClient(clientConnected1);
    ////        }
    ////        catch (Exception e)
    ////        {
    ////            
    ////        }

    }
            @Override
        public void start(Stage PrimaryStage) throws Exception{ 
            try{
                Client client1 = new Client("127.0.0.1",Integer.parseInt("1050"));
                PrimaryStage.setTitle("Messagerie");
                PrimaryStage.setScene(client1.getMonInterface().getScene());
                PrimaryStage.show();
            }
            catch (Exception e){

            }
            
        
        }
    private static void printUsage() 
    {
        System.out.println("java client.Client <address> <port>");
        System.out.println("\t<address>: server's ip address");
        System.out.println("\t<port>: server's port");
    }
}
