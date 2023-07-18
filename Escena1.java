import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Escena1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Escena1 extends World
{
    // Importar Archivo(s)
    private final GreenfootImage fondo1 = new GreenfootImage ("Fondos/EsakaFondo1.png");
    
    
    // Constantes para el tamaño de la pantalla del juego.
    public final static int AnchoDelJuego = 1100;
    public final static int AlturaDelJuego = 600;

    // OBJETOS
    // Principal imagenBase para el desplazamiento:
    private GreenfootImage g = new GreenfootImage (AnchoDelJuego, AlturaDelJuego); 
    
    
    // VARIABLES
    private GreenfootImage bg;
    private int PosicionPixelDesplazamiento=0;    
    private int AnchoFondo1;
    private int scrollSpeed;
    
    
    
    
    /**
     * Constructor for objects of class Escena1.
     * 
     */
    public Escena1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(AnchoDelJuego, AlturaDelJuego, 1, false); 

        // Almacena el tamaño ancho de la imagen de fondo, como un entero.
        AnchoFondo1 = fondo1.getWidth();

        //----------------A
        // Crea la INICIAL imagen de fondo, ya q antes de darle "run", sale en blanco.
        // porque el constructor tiene por defecto el fondo en blanco.
        bg = MoverFondo();
        
        // Establece la imagen de fondo INICIAL: 
        setBackground(bg);
        AparecerPlayer1();
        /* Add an object to the world for visual effect. 
        runner = new Runner ();
        addObject (runner, 100, AlturaDelJuego / 2);
        */
    }
        //----------------A
    
    int a = 0;
    
    public void act ()
    {
        // "mueve" el fondo llamando el método MoverFondo , que 
        // redibuja la imagen de fondoe, movido de a 2x pixels desplazado.
        
        bg = MoverFondo();
        setBackground(bg);
        
    }
    private void AparecerPlayer1()
    {
        addObject(new Suelo1(), 550, 550);
        Jugador1 plyr1 = new Jugador1();
        addObject(plyr1, 100, 400);        
        plyr1.setLocation(100, 415); 
        
        Jugador2 plyr2 = new Jugador2();
        addObject(plyr2, 1000, 415);
    }
    
    
    
    //desplazamiento:
    int VelocidadMovPixel=5; //cantidad de pixeles que desplaza.
    boolean stopDerecha, stopIzquierda = false;
    // Mueve los pixeles de desplazamiento y redibuja el fondo.  
    private GreenfootImage MoverFondo() //para darle efecto de movimiento por toda la imagen.
    {       
        // Ancho de la imagen de fondo en pixeles.
        
        ///2523-1100 =1423 el cual es el ancho máximo en pixeles q se puede mover 
        // por toda la imagen de extremo a extremo.
        /*1100 es la cantidad q ocupa lo visible en pantalla.           
        1423 son la cantidad de pixeles que faltan para
        llegar hasta el ancho final visible en pantalla
        ya que 2523 es el tamaño ancho total y 1100 +1423 = 2523.
        */
        if (PosicionPixelDesplazamiento >= AnchoFondo1-AnchoDelJuego)
        {
            //PosicionPixelDsplazamiento es la cantidad de pixeles q avanzó ._.
            //PosicionPixelDesplazamiento = 0; 1 pixel es de tamaño 1 de ancho y 1 de alto px.
            stopDerecha = true;
        }
        else { stopDerecha = false; }
        
        if(PosicionPixelDesplazamiento <= 0)
        {
            stopIzquierda = true;
        }
        else { stopIzquierda = false; }
        
        //movimiento derecha; los valores son positivos y negativos para q funcione bn,
        //pero al dibujar se resta 0-posicionP... para q la imagen se mueva hacia
        //el otro lado, dando el efecto de avance o retroceso correcto.
        if( (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) && stopDerecha == false)
        {
            PosicionPixelDesplazamiento += VelocidadMovPixel;            
        }
        //movimiento izquierda
        if( (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left") ) && stopIzquierda ==false)
        {
            PosicionPixelDesplazamiento += -VelocidadMovPixel;
        }        
        
        //g es la imagen del tamaño de la pantalla del juego, que va a estar estática,
        //fondo1 es la imagen de fondo que va a estar siendo "dibujada" en ciertas 
        //posiciones de pixel para darle efecto de movimiento, pero
        //g se encarga de mantener el fondo estático para q la pantalla no se 
        // mueva también cuando la imagen es movida.
        
        // Dibuja la imagen sobre:  (Dibuja a fondo1 sobre g)
        //g siendo de base, es el límite o espacio permitido para moverse ya que estamos dibujando sobre g
        //cuando ponemos g.drawImage, por eso es o debe ser igual al ancho del juego. 
        // y fondo1 siendo la imagen movida en cierta cantidad de pixeles.
        g.drawImage(fondo1, 0-PosicionPixelDesplazamiento, -250 );        

        // Retorna la "g", imagen de resultado final en cada proceso (en pixel movido).
        return g;
    }
    
    
    
    
    
    
}
