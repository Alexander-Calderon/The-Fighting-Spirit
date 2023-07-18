import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Carga2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carga2 extends Menu
{
    /**
     * Act - do whatever the Carga2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Carga2(){
        setImage("CargaCirculo/0.png");
    }
    
    private int z=0;
    private int x=0;
    public void act() 
    {
        // Add your action code here.
        //animación cirgular.
            if(cargado==false){
            z ++;            
            if(z == 5)
            {
                setImage("CargaCirculo/0.png");
            }    
            if(z == 10)
            {
                setImage("CargaCirculo/1.png");
            }            
            if(z == 15)
            {
                setImage("CargaCirculo/2.png");
            }            
            if(z == 20)
            {
                setImage("CargaCirculo/3.png");
            }            
            if(z == 25)
            {
                setImage("CargaCirculo/4.png");
            }
            if(z == 30)
            {
                setImage("CargaCirculo/5.png");
            }            
            if(z == 35)
            {
                setImage("CargaCirculo/6.png");
            }            
            if(z == 40)
            {
                setImage("CargaCirculo/7.png");
                z=0;
                
            }
            
        }
        
        
        
        
        
        if(cargado==true)
        {
            x ++;
            setLocation(450, 599);
            
            if(x == 2)
            {
                setImage("TituloAnimado/TituloAnim1.png");
                getImage().scale(600, 400);
            }    
            if(x == 4)
            {
                setImage("TituloAnimado/TituloAnim2.png");
                getImage().scale(600, 400);
            }            
            if(x == 6)
            {
                setImage("TituloAnimado/TituloAnim3.png");
                getImage().scale(600, 400);
            }            
            if(x == 8)
            {
                setImage("TituloAnimado/TituloAnim4.png");
                getImage().scale(600, 400);                
            }            
            if(x == 10)
            {
                setImage("TituloAnimado/TituloAnim5.png");
                getImage().scale(600, 400);
            }
            if(x == 12)
            {
                setImage("TituloAnimado/TituloAnim6.png");
                getImage().scale(600, 400);
            }            
            if(x == 14)
            {
                setImage("TituloAnimado/TituloAnim7.png");
                getImage().scale(600, 400);
            }            
            if(x == 16)
            {
                setImage("TituloAnimado/TituloAnim8.png");
                getImage().scale(600, 400);
            }            
            if(x == 20)
            {
                setImage("TituloAnimado/TituloAnim9.png");
                getImage().scale(600, 400);
            }    
            if(x == 22)
            {
                setImage("TituloAnimado/TituloAnim8.png");
                getImage().scale(600, 400);
            }            
            if(x == 24)
            {
                setImage("TituloAnimado/TituloAnim7.png");
                getImage().scale(600, 400);
            }            
            if(x == 26)
            {
                setImage("TituloAnimado/TituloAnim6.png");
                getImage().scale(600, 400);
            }            
            if(x == 28)
            {
                setImage("TituloAnimado/TituloAnim5.png");
                getImage().scale(600, 400);
            }
            if(x == 30)
            {
                setImage("TituloAnimado/TituloAnim4.png");
                getImage().scale(600, 400);
            }            
            if(x == 32)
            {
                setImage("TituloAnimado/TituloAnim3.png");
                getImage().scale(600, 400);
            }
            if(x == 34)
            {
                setImage("TituloAnimado/TituloAnim2.png");
                getImage().scale(600, 400);
            }            
            if(x == 36)
            {
                setImage("TituloAnimado/TituloAnim1.png");
                getImage().scale(600, 400);
                x=0;                
            }
            
    
        if(Greenfoot.isKeyDown("enter")) {
             Greenfoot.setWorld(new SelecPersonaje() );
            cargado=false;
        }
            
        }
        
        
        //Greenfoot.setWorld(new MenuCarga() );
        
    }    
}
