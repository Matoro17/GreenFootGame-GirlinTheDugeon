import greenfoot.*;

/**
 * Write a description of class SlimeDumbRight here.
 * 
 * @author Gabriel Silva de Azevedo 
 * @version 25/07/2017
 */
public class SlimeDumbRight extends Slime
{
    boolean direc=false;
    
    /**
     * Act - do whatever the SlimeDumbRight wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!direc){
            if(isTouching(Rock.class)){
                setLocation(getX()-5, getY());
                direc = true;
            }
            moveRight();            
        }
        else{
            if(isTouching(Rock.class)){
                setLocation(getX()+5, getY());
                direc = false;
            }
            moveLeft();
        }
        animationCounter++;
    }    
}
