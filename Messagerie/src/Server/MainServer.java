/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;
import java.io.IOException;
import java.util.List;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.text.*;

/**
 *
 * @author p1409881
 */
public class MainServer{
        /**
     * creates a new server
     * @param args
     */
    public static void main(String[] args) {
    try {
        if (args.length != 1) 
        {
            printUsage();
        } 
        else 
        {
            Integer port = new Integer(args[0]);
            Server server = new Server(port);
        }
    } 
    catch (Exception e1) 
    {
        e1.printStackTrace();
    }
    }
    
    private static void printUsage() 
    {
        System.out.println("java server.Server <port>");
        System.out.println("\t<port>: server's port");
    }
}
