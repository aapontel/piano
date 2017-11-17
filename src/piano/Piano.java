/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class Piano implements ActionListener,MouseListener{

    public static Piano piano;
    private URL url = null;
    public  Renderer renderer;
    public boolean creatingPattern=true,peteada=false ;
    
    
    public static final int WIDTH =412,HEIGHT =400;  
    public int flashed= 0,indexPattern=0,miralo,count=0;
    public ArrayList<Integer> pattern;
    
    public void start(){
        pattern = new ArrayList<Integer>();
        while (peteada==false) {            
         if(creatingPattern== true){
            if (flashed != 18) {
             pattern.add(flashed);
            indexPattern++;
            creatingPattern=false; 
            flashed=9;   
            }
            
        }
        if (creatingPattern == false) {
            for (int i =0; i < indexPattern; i++) {
                miralo=pattern.get(i);
                if (flashed!=9) {
                    if(flashed==miralo){
                        count++;
                    }else if(flashed!=miralo){
                        peteada=false;
                    }
                }
                
                
            }
            count=0;
        }  
        }
         
    }
    public Piano(){
        JFrame frame = new JFrame();
        Timer timer = new Timer(20,this);
        renderer =new Renderer();
        frame.addMouseListener(this);
        frame.setSize(WIDTH, HEIGHT+20);
        frame.setVisible(true);
        frame.add(renderer);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        timer.start();
    }
        
    
    public static void main(String[] args) {
        piano = new Piano(); 
        piano.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
       renderer.repaint();
    }

    void paint(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON  );
        
        g.setColor(Color.BLACK);
        
        Image fondo = loadImage("piano1.jpg");
        g.drawImage(fondo, 0, 0, null);
      
        g.setStroke(new BasicStroke(200));
        
        if (peteada == false) {
            g.drawString(count+"/"+indexPattern, WIDTH/2, HEIGHT*3/4);
        }else if (peteada == true){
            g.drawString("la morraqueo", WIDTH/2, HEIGHT*3/4);
        }
      }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
   }

    @Override
    public void mousePressed(MouseEvent e) {
        int x= e.getX(),y= e.getY();
        
        if(x>0 && x<WIDTH/7 && y>0 && y < HEIGHT  ){
            try {
                 url = new URL("file:DO.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
             }
                flashed=1;
        }
        else if (x>WIDTH/7 && x<WIDTH/7+WIDTH/7 && y>0 && y < HEIGHT ) {
            try {
                 url = new URL("file:RE.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
             }
                flashed=2;
        } else if (x>WIDTH*2/7 && x<WIDTH*3/7&& y>0 && y < HEIGHT ) {
            try {
                 url = new URL("file:MI.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
             }
            flashed=3;
        } else if (x>WIDTH*3/7 && x<WIDTH*4/7&& y>0 && y < HEIGHT) {
            try {
                 url = new URL("file:FA.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
             }
            flashed=4;
        } else if (x>WIDTH*4/7 && x<WIDTH*5/7&& y>0 && y < HEIGHT) {
            try {
                 url = new URL("file:SOL.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
             }
            flashed=5;
        } else if (x>WIDTH*5/7 && x<WIDTH*6/7&& y>0 && y < HEIGHT) {
            try {
                 url = new URL("file:LA.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
             }
            flashed=6;
        } else if (x>WIDTH*6/7 && x<WIDTH*7/7&& y>0 && y < HEIGHT) {
            try {
                 url = new URL("file:SI.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
             }
            flashed=7;
        } 
        

}
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
   }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
