import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelecPersonaje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelecPersonaje extends World
{

    /**
     * Constructor for objects of class Paso.
     * 
     */
    //Carga carga = new Carga();

    
    
    public SelecPersonaje()    
    {
        super(1100, 600, 1);
        //removeObject(carga);
        
        setBackground("SeleccionPersonaje.png");
        SelectKyo selectkyo = new SelectKyo();
        addObject(selectkyo, 126, 244);
        
        SelectIori selectiori = new SelectIori();
        addObject(selectiori, 882, 244);        
        
    }
}
