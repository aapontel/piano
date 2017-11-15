/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Andres
 */
public class Board extends JPanel implements MouseListener{
    
    
    private URL url = null;
    
 
    public Board() {
        
        
        this.addMouseListener(this);
        
        
    }
     
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarEscenario(g);
    }

    private void dibujarEscenario(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        Image fondo = loadImage("piano1.jpg");
        g2d.drawImage(fondo, 0, 0, null);
    }
    
   
      public Rectangle DO() {
        return new Rectangle(0, 0, 59, 300);
      }
      public Rectangle RE() {
        return new Rectangle(59, 0, 59, 300);
      }
      public Rectangle MI() {
        return new Rectangle(59+59, 0, 59, 300);
      }
      public Rectangle FA() {
        return new Rectangle(59+59+59, 0, 59, 300);
      }
      public Rectangle SOL() {
        return new Rectangle(59+59+59+59, 0, 59, 300);
      }
      public Rectangle LA() {
        return new Rectangle(59+59+59+59+59, 0, 59, 300);
      }
      public Rectangle SI() {
        return new Rectangle(59+59+59+59+59+59, 0, 59, 300);
      }

      
    
    //Se llama cuando se oprime y se suelta un botón en el mouse
    @Override
    public void mouseClicked(MouseEvent e) {
         Point NOTA = e.getPoint();
         
         if(DO().contains(NOTA)){
             try {
                 url = new URL("file:do.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
             }
         } 
         if(RE().contains(NOTA)){
             try {
                 url = new URL("file:re.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         if(MI().contains(NOTA)){
             try {
                 url = new URL("file:mi.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         if(FA().contains(NOTA)){
             try {
                 url = new URL("file:fa.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         if(SOL().contains(NOTA)){
             try {
                 url = new URL("file:sol.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         if(LA().contains(NOTA)){
             try {
                 url = new URL("file:la.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         if(SI().contains(NOTA)){
             try {
                 url = new URL("file:si.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
          
    }

    //Es llamado cuando se oprime un botón en el Mouse.
    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    // Ocurre cuando se suelta un botón en el Mouse.
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    //Ocurre cuando el cursor entra dentro de los límites del componente.
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    //Ocurre cuando el cursor sale dentro de los límites del componente.
    @Override
    public void mouseExited(MouseEvent e) {

    }
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}
  