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
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author p1712712
 */
public class Messagerie{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
// TEST CLIENT
        MainClient prog = new MainClient();
        String[] myargs = new String[2];
        myargs[0] = "127.0.0.1";
        myargs[1] = "1050";
        prog.main(myargs);



//Test SERVEUR
//        String[] myargs = new String[1];
//        myargs[0] = "1090";
//        MainServer prog = new MainServer();
//        prog.main(myargs);

    }
}
