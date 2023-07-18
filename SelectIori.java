import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectIori here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectIori extends Selecciones
{
    /**
     * Act - do whatever the SelectIori wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SelectIori(){
        setImage("ioriSelect.png");
    }
    
    public void act() 
    // Add your action code here.
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            SeleccionIori1=true;
        }
        
        if(Greenfoot.mouseClicked(this) && SeleccionIori1==true){
            SeleccionIori2=true;
        }
    }  
        
}
