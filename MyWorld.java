import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Gabriel Silva de Azevedo 
 * @version 25/07/2017
 */
public class MyWorld extends World
{
    boolean gameover = false;
    GreenfootSound main = new GreenfootSound("main_themed.wav");
    GreenfootSound pilhaSound = new GreenfootSound("pilha.wav");
    GreenfootSound Over = new GreenfootSound("Game Over.wav");
    GreenfootSound win = new GreenfootSound("ganhar.wav");
    GreenfootSound dano = new GreenfootSound("damage.wav");    
    Girl garota = new Girl();
    Bateria batery = new Bateria();
    int pilhas = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        
        super(1000, 500, 1);
        setBackground("Backgroud 1.png");
                      
        gerar();
        addObject(garota,250,300);
        addObject(batery,900,25);
         
    }
    public void act(){
        if(!gameover){
            main.playLoop();
        }
        aparenciaDaBateria();
        if(!gameover){
            if(garota.hitSlime()){
                if(garota.getVida()==0){
                    gameover = true;
                    main.stop();
                    teladegameover();
                }
                else{
                    garota.setVida(garota.getVida()-1);
                    dano.play();
                    garota.danolevado();
                    pilhas--;
                }
                
            }
            if(garota.tocaFinal()){
                garota.setControle(true);
                gameover=true;
                finalGame();                
            }
            if(garota.hitbaterry()){
                pilhaSound.play();
                pilhas++;
                garota.setVida(garota.getVida()+1);
                Pilha temp = garota.pilhaPerto();
                this.removeObject(temp);
            }
        }
        
        
    }
    public void teladegameover(){
        main.stop();
        
        Over.play();
        addObject(new GameOver(), this.getWidth()/2, this.getHeight()/2);
        removeObject(garota);
        return;
    }
    public void finalGame(){
        main.stop();   
        this.removeObjects(this.getObjects(null));
        win.play();
        setBackground("ganhar.png");
        removeObject(garota);
        return;
    
    }
    public void aparenciaDaBateria(){
        if(pilhas==0){
            batery.setImage("baterry1.png");
        }
        if(pilhas==1){
            batery.setImage("baterry2.png");
        }
        if(pilhas==2){
            batery.setImage("baterry3.png");
        }
        if(pilhas==3){
            batery.setImage("baterry4.png");
        }
        if(pilhas==4){
            batery.setImage("baterry5.png");
        }
    }
    public int getgarotapilhas(){
        return this.pilhas;
    }
    public void hitpilha(){
        if(garota.hitbaterry()){
            pilhas++;            
            removeObject(garota.pilhaPerto());
        }
    }
    public Girl getGarota(){
        return this.garota;
    }    
    public void gerar(){
        addObject(new Escada(),850,100);
        addObject(new SlimeDumb(), 75 , 75);
        addObject(new SlimeDumb(),925,420);
        addObject(new SlimeDumbRight(),720,75);
        addObject(new SlimeDumbRight(),780,438);
        
        addObject(new Pilha(), 400, 300);
        addObject(new Pilha(), 650, 310);
        
        addObject(new Rock(),800,50);
        addObject(new Rock(),800,100);
        addObject(new Rock(),800,150);
        addObject(new Rock(),850,150);
        addObject(new Rock(),850,200);
        addObject(new Rock(),850,250);
                addObject(new Rock(),150,150);
                addObject(new Rock(),250,150);
                addObject(new Rock(),150,270);                
                addObject(new Rock(),150,320);
                addObject(new Rock(),150,370);
                addObject(new Rock(),200,370);
                addObject(new Rock(),250,370);
        addObject(new Rock(),550,150);
        addObject(new Rock(),600,150);
        addObject(new Rock(),650,150);
        
        addObject(new Rock(),800,250);
        addObject(new Rock(),750,250);
        addObject(new Rock(),700,250);
        addObject(new Rock(),650,250);
        addObject(new Rock(),610,250);
        
        addObject(new Rock(),610,300);
        addObject(new Rock(),610,350);
        addObject(new Rock(),610,375);
        addObject(new Rock(),650,375);
        addObject(new Rock(),750,375);
        addObject(new Rock(),800,375);
        
        addObject(new Rock(),200,250);  
        addObject(new Rock(),300,370);
        addObject(new Rock(),200,250);
        
        
        
        addObject(new Rock(),850,450);
        addObject(new Rock(),850,400);
        addObject(new Rock(),850,370);
        for(int i=0;i<1001;i=i+50){
            addObject(new Rock(),i,0);
            addObject(new Rock(),i,500);
            if(i>100){
                addObject(new Rock(),this.getWidth()/2,i);
            }
            }

        for(int i=0;i<501;i=i+50){
            addObject(new Rock(),0,i);
            addObject(new Rock(),1000,i);
        }
        addObject(new Rock(), 200, 200);
        addObject(new Rock(), 250, 200);
        addObject(new Rock(), 300, 200);
        addObject(new Rock(), 350, 200);
        addObject(new Rock(),400,200);
        addObject(new Rock(),450,200);
        
    }
}
