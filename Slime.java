import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Slime here.
 * 
 * @author Gabriel Silva de Azevedo 
 * @version 25/07/2017
 */
public class Slime extends Actor
{
    int frame = 1,speed = 2,animationCounter = 0,direction = 0,vida = 3;
    
    /**
     * Act - do whatever the Slime wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        chegarRock();       
        
        animationCounter++;
    }
    public int getVida(){
        return this.vida;
    }
    public void setVida(int j){
        this.vida = j;
    }
    public int getDirec(){
        return this.direction;
    }
    public void setDirec(int i){
        this.direction = i;
    }
    public void chegarRock(){
        
            World w = getWorld();
            List top = w.getObjectsAt(getX(),getY()-15, Rock.class);
            List bot = w.getObjectsAt(getX(),getY()+15, Rock.class);
            List left = w.getObjectsAt(getX()-15,getY(), Rock.class);
            List right = w.getObjectsAt(getX()+15,getY(), Rock.class);
            if(right.isEmpty()){
                setLocation(getX()+3, getY());
                direction = 1;
            }
            if(left.isEmpty()){
                setLocation(getX()-3, getY());
                direction = 0;
            }
    
            if(top.isEmpty()){
                setLocation(getX(), getY()-3);
                direction = 2;
            }
            if(bot.isEmpty()){
                setLocation(getX(), getY()+3);
                direction = 3;
            }
        
    }
    
    public void AnimateLeft(){
        if(frame == 1){
            setImage("SlimeL1.png");
        }
        else if(frame ==2){
            setLocation(getX(),getY()+2);
            setImage("SlimeL2.png");            
        }
        else if(frame ==3){
            setLocation(getX(),getY()-2);
            setImage("SlimeL3.png");            
        }
        else if(frame ==4){
            setLocation(getX(),getY()-2);
            setImage("SlimeL4.png");            
        }
        else if(frame ==5){
            setLocation(getX(),getY()+2);
            setImage("SlimeL5.png");            
        }
        else if(frame ==6){
            setImage("SlimeL1.png");
            frame = 1;
            return;
        }
        frame ++;
    }
    public void moveLeft(){
        setLocation(getX()-speed, getY());
        /*if(animationCounter % 6==0){
            AnimateLeft();
        }   */     
    }
    public void AnimateRight(){
        if(frame == 1){
            setImage("SlimeR1.png");
        }
        else if(frame ==2){
            setLocation(getX(),getY()+2);
            setImage("SlimeR2.png");            
        }
        else if(frame ==3){
            setLocation(getX(),getY()-2);
            setImage("SlimeR3.png");            
        }
        else if(frame ==4){
            setLocation(getX(),getY()-2);
            setImage("SlimeR4.png");            
        }
        else if(frame ==5){
            setLocation(getX(),getY()+2);
            setImage("SlimeR5.png");            
        }
        else if(frame ==6){
            setImage("SlimeR1.png");
            frame = 1;
            return;
        }
        frame ++;
    }
    public void moveRight(){
        setLocation(getX()+speed, getY());
        /*if(animationCounter % 6==0){
            AnimateRight();
        } */       
    }
    public void AnimateUp(){
        if(frame == 1){
            setImage("SlimeU1.png");
        }
        else if(frame ==2){
            setLocation(getX(),getY()+2);
            setImage("SlimeU2.png");            
        }
        else if(frame ==3){
            setLocation(getX(),getY()-2);
            setImage("SlimeU3.png");            
        }
        else if(frame ==4){
            setLocation(getX(),getY()-2);
            setImage("SlimeU4.png");            
        }
        else if(frame ==5){
            setLocation(getX(),getY()+2);
            setImage("SlimeU5.png");            
        }
        else if(frame ==6){
            setImage("SlimeU1.png");
            frame = 1;
            return;
        }
        frame ++;
    }
    public void moveUp(){
        setLocation(getX(), getY()-speed);
        if(animationCounter % 6==0){
            AnimateUp();
        }        
    }
    public void AnimateDown(){
        if(frame == 1){
            setImage("Slime 1.png");
        }
        else if(frame ==2){
            setLocation(getX(),getY()+2);
            setImage("SlimeD2.png");            
        }
        else if(frame ==3){
            setLocation(getX(),getY()-2);
            setImage("SlimeD3.png");            
        }
        else if(frame ==4){
            setLocation(getX(),getY()-2);
            setImage("SlimeD4.png");            
        }
        else if(frame ==5){
            setLocation(getX(),getY()+2);
            setImage("SlimeD5.png");            
        }
        else if(frame ==6){
            setImage("Slime 1.png");
            frame = 1;
            return;
        }
        frame ++;
    }
    public void moveDown(){
        setLocation(getX(), getY()+speed);
        if(animationCounter % 6==0){
            AnimateDown();
        }        
    }
    
}
