/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoTriangulo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author desenv
 */
public class Principal {
    
    public static void main(String[] args){
    Janela jan = new Janela();
    
    while(true){
        try{
       long start = System.currentTimeMillis();
        jan.repaint();
        long end = System.currentTimeMillis();
        Thread.sleep(55-(end-start));
        } 
        catch (InterruptedException ex){
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            break;
        }
        }
    }
}
