/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logoscreen;
import javax.swing.JFrame;

/**
 *
 * @author DylanWilde
 */
public class LogoDisplay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        JFrame windows = new JFrame("Dylan's Logo");
        windows.setBounds(550, 225, 700, 500);
        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Logo logo = new Logo();
        windows.add(logo);
        
        windows.setVisible(true);
        Animator a = new Animator(logo);
    }    
    
    
}
