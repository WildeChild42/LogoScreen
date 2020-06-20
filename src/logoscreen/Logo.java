/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logoscreen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author DylanWilde
 */
public class Logo extends JPanel 
{
    private boolean showSpaceShip;
    private int starX;
    private int [][] starMap;
    
    @Override
    public void paint(Graphics g1)
    {
        Graphics2D g = (Graphics2D) g1;

        g.setColor(Color.BLACK);
        Dimension d = this.getSize();
        g.fillRect(0, 0, (int) d.getWidth(), (int) d.getHeight());

        this.drawStars(g);
        
        g.setColor(Color.RED);
        
        Font f = g.getFont();
        Font newFont = new Font(f.getFontName(), Font.BOLD, f.getSize() + 30);
        g.setFont(newFont);
        g.drawString("N7 Enterprises", 180, 300);
        
        
        g.setColor(Color.BLUE);
        this.paintHouse(g, 300, 250);
        g.setColor(Color.WHITE);
        this.paintHouse(g, 360, 250);
        g.setColor(Color.RED);
        this.paintHouse(g, 240, 250);
        
        if (showSpaceShip)
        {
            g.setColor(Color.BLUE);
            g.fillRoundRect(170, 155, 200, 20, 20, 20);
        }

        g.setColor(Color.GRAY);
        g.fillOval(360, 150, 200, 30);
        
    }
    
    public void updateStars()
    {
        Dimension d = this.getSize();
        for (int[] starMap1 : starMap) {
            starMap1[0] = starMap1[0] + 2;
            if (starMap1[0] > d.getWidth()) {
                starMap1[0] = 0;
            }
            starMap1[1] = starMap1[1] + 1;
            if (starMap1[1] > d.getHeight()) {
                starMap1[1] = 0;
            }
        }
    }
    
    
    private void paintHouse(Graphics2D g, int x, int y)
    {
        GeneralPath path = new GeneralPath();
        path.moveTo(x,      y);
        path.lineTo(x + 0, y);
        path.lineTo(x + 45, y - 0);
        path.lineTo(x + 45, y - 50);
        path.lineTo(x,      y - 0);
        path.lineTo(x,      y - 0);
        
        g.fill(path);
    }

    public void initStars(int stars)
    {
        Dimension d = this.getSize();
        Random r = new Random();
        starMap = new int[stars][2];
        for (int i = 0; i < stars; i++)
        {
            starMap[i][0] = r.nextInt((int) d.getWidth());
            starMap[i][1] = r.nextInt((int) d.getHeight());
        }
    }

    private void drawStars(Graphics2D g)
    {
        for (int[] starMap1 : starMap) {
            drawStar(g, starMap1[0], starMap1[1]);
        }
    }
    
    private void drawStar(Graphics2D g, int x, int y)
    {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 2, 2);
    }

    public boolean isShowSpaceShip()
    {
        return showSpaceShip;
    }

    public void setShowSpaceShip(boolean showSpaceShip)
    {
        this.showSpaceShip = showSpaceShip;
    }
}
