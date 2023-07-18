import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Escenario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Escenario extends Actor
{
    /**
     * Act - do whatever the Escenario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        // Add your action code here.

    } 
    
    public boolean ColisionSuelo()
    {
        Actor ColisionS1 = getOneObjectAtOffset(0, getImage().getHeight()/2, Suelo1.class); //cheque la locación en X
        return ColisionS1 != null;
    }
    
    public boolean testColider()
    {
        Actor Player1 = getOneIntersectingObject( Jugador1.class );
        if (Player1 == null) {
            return false;
        } else {
            return true;
        }
    }
    
   
    
    
}
