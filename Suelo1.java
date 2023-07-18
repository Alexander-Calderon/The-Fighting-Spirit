import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Suelo1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Suelo1 extends Elementos
{
    /**
     * Act - do whatever the Suelo1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage sueloA = new GreenfootImage ("Elementos/Suelo_Nivel1.png");
    
    //constructor para establecer valores antes de abrir correr el juego.
    public Suelo1()
    {
        setImage(sueloA);
        sueloA.scale(1200, 47);
        sueloA.setTransparency(0); //rango de 0 a 255        
    }
    
    
    public void act() 
    {
        // Add your action code here.
 
    }    
}
