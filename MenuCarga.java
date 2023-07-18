import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuCarga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuCarga extends World
{

    /**
     * Constructor for objects of class MenuCarga.
     * 
     */
    public MenuCarga()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 600, 1);  
        setBackground("Cargando3.png");
        
        Carga carga = new Carga(); //añadir primero la imagen de carga.
        addObject(carga, 110, 370);
        //completado 550 370_ inicia en 110, 730

        Menu menu = new Menu(); //luego añadir la imagen de menú principal para q cubra la anterior.
        addObject(menu, 550, 302);


        
        //Establecer el fondo de color sólido q se verá detrás de la barra que carga.
        
        
        
    }
    
    Carga2 carga2 = new Carga2(); //añadir primero la imagen de carga.
    
    public void act(){
        addObject(carga2, 534, 323);
    }



}
