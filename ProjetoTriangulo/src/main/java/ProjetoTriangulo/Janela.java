/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoTriangulo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javax.swing.JFrame;
import sun.java2d.pipe.RenderingEngine;

/**
 *
 * @author desenv
 */
public class Janela extends JFrame {
    public List<Triangulo> tri = new ArrayList<>();
    BufferedImage img;
    
    public Janela(){
        super("Art Ataque");
        
        setSize(620,480);
        setVisible(true);
        
        for (int i = 0; i < 100; i++) {
            Triangulo triangulo = new Triangulo();
            triangulo.x = (int) (620* Math.random());
            triangulo.y = (int) (480* Math.random());
            triangulo.a = 10 + ((int) (90*Math.random()));
            triangulo.b = 10 + ((int) (90*Math.random()));
            triangulo.c = 10 + ((int) (90*Math.random()));
            int vx = (int) (Math.random() *1);
            if (vx == 0 )
                vx = -1;
            int vy = (int) (Math.random() *1);
            if (vy == 0) 
                vy = 1;
            triangulo.dirx = vx;
            triangulo.diry = vy;
            int r = (int) (Math.random() * 255);
            int g = (int) (Math.random() * 255);
            int b = (int) (Math.random() * 255);
            triangulo.cor = new Color(r, g, b);
            triangulo.velx = 5 + (int) (Math.random() * 10);
            triangulo.vely = 5 + (int) (Math.random()) *10;
            triangulo.janela = this;
            
            tri.add(triangulo);
        }
        img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        if (img.getWidth() != getWidth() || img.getHeight()!= getHeight()) {
            img = new BufferedImage(getWidth(),
                    getHeight(), BufferedImage.TYPE_INT_ARGB);
        }
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());
        
        for (Triangulo t : tri){
        t.draw(g2);
        }
    g.drawImage(img, 0, 0, null);
    }
}
