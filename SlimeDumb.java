import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SlimeDumb here.
 * 
 * @author Gabriel Silva de Azevedo 
 * @version 25/07/2017
 */
public class SlimeDumb extends Slime
{
    boolean direc=false;
   /**
     * Act - do whatever the SlimeDumb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        if(!direc){
            if(isTouching(Rock.class)){
                setLocation(getX(), getY()+5);
                direc = true;
            }
            moveUp();            
        }
        else{
            if(isTouching(Rock.class)){
                setLocation(getX(), getY()-5);
                direc = false;
            }
            moveDown();
        }
        animationCounter++;
    }    
}
