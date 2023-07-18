import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Carga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carga extends Menu
{
    /**
     * Act - do whatever the Carga wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Carga()
    {
        setImage("Cargando2.png");
    }
    
    int cont;
    public void act() 
    {
        // Add your action code here.
        
        for(int i=0;i<1;i++)
        {
            for(int j=0;j<20;j++)
            {
                
            }
            if(getX() < 550){
                setLocation(getX()+1,getY());
            }
            else{ cargado=true; }
        }
        
        
    }    
}
