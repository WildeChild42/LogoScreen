/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logoscreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author DylanWilde
 */
public class Animator implements ActionListener
{
    private Logo logo;
    private int count;

    public Animator(Logo logo)
    {
        this.logo = logo;
        logo.initStars(50);
        Timer t = new Timer(50, this);
        t.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        count = count + 1;
        logo.updateStars();
        
        if (count % 100 == 0)
        {
            logo.setShowSpaceShip(false);
        } 
        if (count % 80 == 0)
        {
            logo.setShowSpaceShip(true);
        }
        logo.repaint();
    }
    

    
}
