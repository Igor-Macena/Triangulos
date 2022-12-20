/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoTriangulo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author SrHumano
 */
public class Triangulo {
    public int x;
    public int y;
    public Color cor;
    public int dirx;
    public int diry;
    public int velx;
    public int vely;
    public int a; // é um dos lados do Triangulo : )
    public int b;
    public int c;
    public Janela janela;
    
    public void draw (Graphics g2){
        g2.setColor(cor);
        // Poligono virou um obj
        Polygon poligono = new Polygon();
        // Pontos do obj poligono
        poligono.addPoint(x+a, y+c);
        poligono.addPoint(x+b, y+a);
        poligono.addPoint(x+c, y+b);
        // Desenho do mesmo
        g2.drawPolygon(poligono); 
        //g2.fillOval(x, y, dia, dia); // Código antigo...
        movimentacao();
    }
    public void movimentacao(){
        if (dirx == 1) {
            x = x + velx; // Direita
            
        if (x >= janela.getWidth() - (a+b+c)/2)/* O triangulo 
            recebe colisão depois de atravesar 25% de sua area*/
            dirx = -1; // Vai e Volta 
        }
        else if (dirx == -1) {
            x = x - velx; // Esquerda
            
            if (x <= 0)
            dirx = 1; // Vai e Volta outro lado 
        }
        
         ////
        
        if (diry == -1) {
            y = y + vely; // cima
            
        if (y >= janela.getHeight() - (a+b+c)/2)
            diry = 1; // Vai e Volta 
        }
        else if (diry == 1) {
            y = y - vely; // baixo
            
              if (y <= 0)
            diry = -1; // Vai e Volta outra direção
        }
    }
}
