import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Girl here.
 * 
 * @author Gabriel Silva de Azevedo 
 * @version 25/07/2017
 */
public class Girl extends Actor
{
    int frames = 1,Vel = 2,aniCounter = 0,direc = 0,vida=0,directdamage = 0;
    boolean controle = false;
    World mundo = getWorld();
    LinkedList lista = new LinkedList();
            
    /**
     * Act - do whatever the Girl wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    public void act() 
    {
        
        chegarRock();
        keys();       
        aniCounter++;
        if(directdamage > 0){
            directdamage--;
        }
        
    }
    public Pilha pilhaPerto(){
        Pilha temp = (Pilha) getOneIntersectingObject(Pilha.class);
        return temp;
    }
    public boolean hitbaterry(){
        if(!controle){
            return this.isTouching(Pilha.class);
        }
        return false;
    }
    public void setVida(int i){
        this.vida = i;
    }
    public void setControle(boolean po){
        this.controle = po;
    }
    public void danolevado(){
        directdamage = 5;
        if(direc == 1){
            setImage("GirlLH.png");
        }
        if(direc == 2){
            setImage("GirlRH.png");
        }
        if(direc == 3){
            setImage("GirlUH.png");
        }
        if(direc == 4){
            setImage("GirlDH.png");
        }
        
    }
    public int getVida(){
        return this.vida;
    }
    public boolean hitSlime(){
        if(directdamage > 0){
            return false;
        }
        if(isTouching(Slime.class) || isTouching(SlimeDumb.class)){ 
            if(vida == 0){
                controle = true;
            }
            return true;
        }
        return false;
    }
    public boolean tocaFinal(){
                if(!controle){
               return isTouching(Escada.class);
            }
            return false;
    }
    
    public void chegarRock(){
        if(!controle){
            World w = getWorld();
            List top = w.getObjectsAt(getX(),getY()-15, Rock.class);
            List bot = w.getObjectsAt(getX(),getY()+15, Rock.class);
            List left = w.getObjectsAt(getX()-15,getY(), Rock.class);
            List right = w.getObjectsAt(getX()+15,getY(), Rock.class);
            if(right.isEmpty()){
                setLocation(getX()+3, getY());
            }
            if(left.isEmpty()){
                setLocation(getX()-3, getY());
            }
    
            if(top.isEmpty()){
                setLocation(getX(), getY()-3);
            }
            if(bot.isEmpty()){
                setLocation(getX(), getY()+3);
            }
        }
    }
    
    public void keys(){
        if(Greenfoot.isKeyDown("left")){
            direc = 1;
            moveLeft();            
        }
        if(Greenfoot.isKeyDown("right")){
            direc = 2;
            moveRight();            
        }
        if(Greenfoot.isKeyDown("up")){
            direc = 3;
            moveUp();            
        }
        if(Greenfoot.isKeyDown("down")){
            direc = 4;
            moveDown();            
        } 
        if(Greenfoot.isKeyDown("space")){
            mundo.addObject(new Luz(),getX(),getY());
        }
    }
    public void AnimateLeft(){
        if(frames == 1){
            setImage("GirlL1.png");
        }
        else if(frames ==2){            
            setImage("GirlL2.png");            
        }
        else if(frames ==3){            
            setImage("GirlL3.png");            
        }        
        else if(frames ==4){
            setImage("GirlL1.png");
            frames = 1;
            return;
        }
        frames ++;
    }
    public void moveLeft(){
        setLocation(getX()-Vel, getY());
        if(aniCounter % 4==0){
            AnimateLeft();
        }        
    }
    public void AnimateRight(){
        if(frames == 1){
            setImage("GirlR1.png");
        }
        else if(frames ==2){
            setImage("GirlR2.png");            
        }
        else if(frames ==3){            
            setImage("GirlR3.png");            
        }        
        else if(frames ==4){
            setImage("GirlR1.png");
            frames = 1;
            return;
        }
        frames ++;
    }
    public void moveRight(){
        setLocation(getX()+Vel, getY());
        if(aniCounter % 4==0){
            AnimateRight();
        }        
    }
    public void AnimateUp(){
        if(frames == 1){
            setImage("GirlU1.png");
        }
        else if(frames ==2){
            setImage("GirlU2.png");            
        }
        else if(frames ==3){
            setImage("GirlU3.png");            
        }        
        else if(frames ==4){
            setImage("GirlU1.png");
            frames = 1;
            return;
        }
        frames ++;
    }
    public void moveUp(){
        setLocation(getX(), getY()-Vel);
        if(aniCounter % 4==0){
            AnimateUp();
        }        
    }
    public void AnimateDown(){
        if(frames == 1){
            setImage("GirlD1.png");
        }
        else if(frames ==2){
            setLocation(getX(),getY()+2);
            setImage("GirlD2.png");            
        }
        else if(frames ==3){
            setLocation(getX(),getY()-2);
            setImage("GirlD3.png");            
        }
        else if(frames ==4){
            setImage("GirlD1.png");
            frames = 1;
            return;
        }
        frames ++;
    }
    public void moveDown(){
        setLocation(getX(), getY()+Vel);
        if(aniCounter % 4==0){
            AnimateDown();
        }        
    }
}
