/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagerie;
import Client.*;
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
        String[] myargs = new String[1];
        myargs[0] = "1050";
        prog.main(myargs);
    }
    
}
