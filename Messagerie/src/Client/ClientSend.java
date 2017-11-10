/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;
import java.io.*;
import java.util.*;

/**
 *
 * @author p1409881
 */
public class ClientSend implements Runnable{
    private PrintWriter out;
    
    public ClientSend(PrintWriter out){
        this.out = out;
    }
    
    @Override
    public void run(){
        Scanner sc = new Scanner(System.in);
        while (true) 
        {
            System.out.print("Votre message >> ");
            String m = sc.nextLine();
            out.println(m);
            out.flush();
        }
    }
}
