import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectKyo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectKyo extends Selecciones
{
    /**
     * Act - do whatever the SelectKyo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SelectKyo(){
         setImage("kyoSelect.png");
    }
    
    int v=0;
    public void act() 
    {
        // Add your action code here.
        
        
        if(Greenfoot.mouseClicked(this)){
            SeleccionKyo1=true;
        }
        

        
        if(Greenfoot.mouseClicked(this) ){            
            SeleccionKyo2=true;
        }
        
        if( (SeleccionKyo1== true && SeleccionKyo2 == true) )
        {
            Greenfoot.setWorld(new Escena1() );
            SeleccionKyo1=false;
            SeleccionKyo2=false;
            
        }
        
        
    }    
}
