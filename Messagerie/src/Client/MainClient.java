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
import javafx.scene.control.Label;
import javafx.scene.control.Button;

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

        //Zone ecriture
        final TextArea chat = new TextArea();
        chat.setPrefHeight(100);
        chat.setPrefWidth(400);
        chat.positionCaret(5);
        chat.setStyle("-fx-control-inner-background : #F7F7F7;-fx-text-fill: #000000;");
        chat.setLayoutX(50);
        chat.setLayoutY(350);
        
        
        //Zone des messages
        final TextArea textReceived = new TextArea();
        textReceived.setPrefHeight(275);
        textReceived.setPrefWidth(400);
        textReceived.setStyle("-fx-control-inner-background : BLUE;-fx-text-fill: #000000;");
        textReceived.setLayoutX(50);
        textReceived.setLayoutY(50);
        root.getChildren().add(textReceived);
        
        //label
        final Label labelMembres = new Label("Actifs :");
        //labelMembres.setPrefHeight();
        //labelMembres.setPrefWidth();
        labelMembres.setLayoutX(500);
        labelMembres.setLayoutY(25);
        root.getChildren().add(labelMembres);
        
        //Zone liste des membres
        final TextArea textMembres = new TextArea();
        textMembres.setPrefHeight(275);
        textMembres.setPrefWidth(100);
        textMembres.setLayoutX(500);
        textMembres.setLayoutY(50);
        textMembres.setStyle("-fx-control-inner-background : RED;-fx-text-fill: #000000;");
        root.getChildren().add(textMembres);
        
        //Bouton envoyer
        final Button boutonEnvoyer = new Button("Envoyer");
        boutonEnvoyer.setPrefHeight(30);
        boutonEnvoyer.setPrefWidth(100);
        boutonEnvoyer.setLayoutX(500);
        boutonEnvoyer.setLayoutY(350);
        root.getChildren().add(boutonEnvoyer);
        
        //bouton supprimer
        final Button boutonSupprimer = new Button("Supprimer");
        boutonSupprimer.setPrefHeight(30);
        boutonSupprimer.setPrefWidth(100);
        boutonSupprimer.setLayoutX(500);
        boutonSupprimer.setLayoutY(385);
        root.getChildren().add(boutonSupprimer);
        
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
