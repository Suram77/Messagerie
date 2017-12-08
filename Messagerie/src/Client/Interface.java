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
import Client.*;

/**
 *
 * @author p1409881
 */
public class Interface{

    private TextArea chat = new TextArea();
    private  Group root = new Group();
    private  Scene scene = new Scene(root);
    private  TextArea textReceived = new TextArea();
    private  Label labelMembres = new Label("Actifs :");
    private TextArea textMembres = new TextArea();
    private Button boutonEnvoyer = new Button("Envoyer");
    private Button boutonSupprimer = new Button("Supprimer");
    private String discussion;
    
    public Interface (Client cli){
        discussion = "";
        try{
        root = new Group();
        scene = new Scene(getRoot());
        
        //Zone ecriture
        chat = new TextArea();
        chat.setPrefHeight(100);
        chat.setPrefWidth(400);
        chat.positionCaret(5);
        chat.setStyle("-fx-control-inner-background : #F7F7F7;-fx-text-fill: #000000;");
        chat.setLayoutX(50);
        chat.setLayoutY(350);
        
        
        //Zone des messages
        textReceived = new TextArea();
        textReceived.setPrefHeight(275);
        textReceived.setPrefWidth(400);
        textReceived.setStyle("-fx-control-inner-background : #F7F7F7;-fx-text-fill: #000000;");
        textReceived.setLayoutX(50);
        textReceived.setLayoutY(50);
        textReceived.setEditable(false);
        root.getChildren().add(textReceived);
        
        //label
        labelMembres = new Label("Actifs :");
        //labelMembres.setPrefHeight();
        //labelMembres.setPrefWidth();
        labelMembres.setLayoutX(500);
        labelMembres.setLayoutY(25);
        root.getChildren().add(labelMembres);
        
        //Zone liste des membres
        textMembres = new TextArea();
        textMembres.setPrefHeight(275);
        textMembres.setPrefWidth(100);
        textMembres.setLayoutX(500);
        textMembres.setLayoutY(50);
        textMembres.setEditable(false);
        textMembres.setStyle("-fx-control-inner-background : #F7F7F7;-fx-text-fill: #000000;");
        root.getChildren().add(textMembres);
        
        //Bouton envoyer
        boutonEnvoyer = new Button("Envoyer");
        boutonEnvoyer.setPrefHeight(30);
        boutonEnvoyer.setPrefWidth(100);
        boutonEnvoyer.setLayoutX(500);
        boutonEnvoyer.setLayoutY(350);
        root.getChildren().add(boutonEnvoyer);
        
        boutonEnvoyer.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                  discussion += chat.getText() + "\n";
//                monServ.broadcastMessage(chat.getText(),clientConnecte1.getId());
//                discussion += chat.getText() + "\n";
                 textReceived.setText(discussion);
//                chat.setText("");
            }
        });
        
        //bouton supprimer
        boutonSupprimer = new Button("Supprimer");
        boutonSupprimer.setPrefHeight(30);
        boutonSupprimer.setPrefWidth(100);
        boutonSupprimer.setLayoutX(500);
        boutonSupprimer.setLayoutY(385);
        
        boutonSupprimer.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                    getChat().setText("");
            }
        });
        
        root.getChildren().add(boutonSupprimer);
        
//            vhat.setY(50);
//            r.setWidth(100);
//            r.setHeight(100);
//            r.setArcWidth(20);
//            r.setArcHeight(20);
        //root.getChildren().add(text);
        root.getChildren().add(chat);
        }
        catch (Exception e){
            
        }
    }
    
    /**
     * @return the chat
     */
    public TextArea getChat() {
        return chat;
    }

    /**
     * @param chat the chat to set
     */
    public void setChat(TextArea chat) {
        this.chat = chat;
    }

    /**
     * @return the root
     */
    public Group getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(Group root) {
        this.root = root;
    }

    /**
     * @return the scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * @param scene the scene to set
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    /**
     * @return the textReceived
     */
    public TextArea getTextReceived() {
        return textReceived;
    }

    /**
     * @param textReceived the textReceived to set
     */
    public void setTextReceived(TextArea textReceived) {
        this.textReceived = textReceived;
    }

    /**
     * @return the labelMembres
     */
    public Label getLabelMembres() {
        return labelMembres;
    }

    /**
     * @param labelMembres the labelMembres to set
     */
    public void setLabelMembres(Label labelMembres) {
        this.labelMembres = labelMembres;
    }

    /**
     * @return the textMembres
     */
    public TextArea getTextMembres() {
        return textMembres;
    }

    /**
     * @param textMembres the textMembres to set
     */
    public void setTextMembres(TextArea textMembres) {
        this.textMembres = textMembres;
    }

    /**
     * @return the boutonEnvoyer
     */
    public Button getBoutonEnvoyer() {
        return boutonEnvoyer;
    }

    /**
     * @param boutonEnvoyer the boutonEnvoyer to set
     */
    public void setBoutonEnvoyer(Button boutonEnvoyer) {
        this.boutonEnvoyer = boutonEnvoyer;
    }

    /**
     * @return the boutonSupprimer
     */
    public Button getBoutonSupprimer() {
        return boutonSupprimer;
    }

    /**
     * @param boutonSupprimer the boutonSupprimer to set
     */
    public void setBoutonSupprimer(Button boutonSupprimer) {
        this.boutonSupprimer = boutonSupprimer;
    }

        /**
     * @return the discussion
     */
    public String getDiscussion() {
        return discussion;
    }

    /**
     * @param discussion the discussion to set
     */
    public void setDiscussion(String discussion) {
        this.discussion = discussion;
    }
}
