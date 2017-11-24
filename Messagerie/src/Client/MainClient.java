/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.IOException;
import java.net.UnknownHostException;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

/**
 *
 * @author p1409881
 */

public class MainClient extends Application{
/**
 * construct a new client
 * @param args
 */
    public static void main(String[] args) {
        Application.launch(MainClient.class,args);
    }
    @Override
    public void start(Stage PrimaryStage) throws Exception{           
        Group root = new Group();
        Scene scene = new Scene(root);

        final TextArea chat = new TextArea();
        chat.setPrefHeight(500);
        chat.setPrefWidth(400);
        chat.positionCaret(5);
        chat.setStyle("-fx-control-inner-background : #F7F7F7;-fx-text-fill: #000000;");
        chat.setLayoutX(200);
        chat.setLayoutY(200);
        
//            vhat.setY(50);
//            r.setWidth(100);
//            r.setHeight(100);
//            r.setArcWidth(20);
//            r.setArcHeight(20);
        //root.getChildren().add(text);
        root.getChildren().add(chat);
        PrimaryStage.setTitle("Messagerie");
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }
    private static void printUsage() 
    {
        System.out.println("java client.Client <address> <port>");
        System.out.println("\t<address>: server's ip address");
        System.out.println("\t<port>: server's port");
    }
}
