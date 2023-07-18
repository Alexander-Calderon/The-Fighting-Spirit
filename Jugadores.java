import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.util.Timer;  //esta librería es compleja, bn mamona xd.
import java.util.TimerTask;
import java.io.IOException;

import javax.swing.Timer; //esta es del paquete más moderno y más "usable" la clase timer. argumentos: delay, ActionListener.
import java.awt.event.ActionListener; //Es para almacenar los eventos.
import java.awt.event.ActionEvent; //es para poder crear eventos.
/**
 * Write a description of class Jugadores here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugadores extends Escenario
{   
    private int VelocidadMov;
    private int FuerzaGravedad;
    private int AcelerarGravedad; //para darle más realismo a la caída incrementando de a 2.
    private int FuerzaSaltar;
    
    
    public static int coordPly1; //static para q mantenga su valor, aunq se isntancie etc.
    public static int coordPly2;
    
    public int getVelocidadMov() {
        return VelocidadMov;
    }
    public void setVelocidadMov(int TempVelocidadMov) {
        this.VelocidadMov = TempVelocidadMov;
    }

    public int getFuerzaGravedad() {
        return FuerzaGravedad;
    }
    public void setFuerzaGravedad(int TempFuerzaGravedad) {
        this.FuerzaGravedad = TempFuerzaGravedad;
    }
       

    
    
    
    public int getAcelerarGravedad() {
        return AcelerarGravedad;
    }
    public void setAcelerarGravedad(int TempAcelerarGravedad) {
        this.AcelerarGravedad = TempAcelerarGravedad;
    }
    
    public int getFuerzaSaltar() {        
        return FuerzaSaltar;        
    }
    public void setFuerzaSaltar(int TempFuerzaSaltar) {
        this.FuerzaSaltar = TempFuerzaSaltar;
    }
    
    
//Inicio del TiempoGeneral.
    private int segundosTranscurridos=0;
    
    // La clase Timer pide la cantidad de milisegundos a recorrer, y el evento almacenado en un ActionListener q se ejecutará al terminar ese tiempo(en especificados intervalos).
    // La clase ActionListener recibe actionEvent(un evento) para procesar/ejecutar, y lo hace usando su método obligatorio (es el único metodo q tiene.)
    // para recibir eventos como argumento, llamado actionPerformed.

    // instanciar/declarar, e inicializar la clase timer, dandole directamente los valores(milisegundos, ActionListener"q guarda el evento")
    Timer Tiempo= new Timer(100, new ActionListener()
    {    
        @Override        //actionPerformed -> metodo abstracto= q no se puede instanciar. Entonces lo sobreescribo.
        public void actionPerformed(ActionEvent nombreEventoArgumentoCualquiera){                
                segundosTranscurridos++;  //centenasTranscurridas.  100 = 1décima, 100*(10^-1)==10.0                         extra: ej: 23,400
                System.out.println("SEGUNDOS Transcurridos: "+ (segundosTranscurridos * Math.pow(10, -1)) );            
        }
    });

    //Inicio métodos para ejecutar/detener el conteo.
    public int iniciar(){ //Empiezo a correr el timer con la tarea q se le asignó.
        Tiempo.start();
        return segundosTranscurridos; //retorno el valor de los segundos para poder compararlo en if. 
        //lo uso como puente para devolver el valor de los segundos, ya q la variable q almacena los segundos la puse privada.
    }
    
    public void Detener(){ //Detengo el timer y reseteo el conteo.
        segundosTranscurridos=0;
        Tiempo.stop();    
    }
    
//fin del TiempoGeneral.
















/*    
    //SubClase para el tiempo en segundos.
    public class Contador{
    int segundosTranscurridos = 0;
    
    //creo un objeto llamado tiempo, con atributos de la clase Timer del paquete importado.
    Timer Tiempo = new Timer(); //Clase Timer de la librería import java.util.Timer;
    
    TimerTask Tarea = new TimerTask(){  //establecer tarea a programadar .
        public void run(){  //llamar al método "run" por defecto de la clase TimerTask para darle los ajustes o valores a ejecutar, //será el Contador:
                                    //a) al imprimir segundos transcurridos *10 elevado a la menos 1: // a) El dígito final, de la derecha valdrá lo mismo más 2 ceros en la derecha, ej: 24.3 00 -> 300milisegundos.
            segundosTranscurridos++;  //centenasTranscurridas.  100 = 1décima, 100*(10^-1)==10.0                         extra: ej: 23,400
            System.out.println("Segundos Transcurridos: "+ (segundosTranscurridos * Math.pow(10, -1)) ); //extra para ver los segundos,milisegundos. 
            //los valores decimales no son exactos pero se puede tomar el entero y devolver el .leght del entero + un espacio a la derecha para mostrar.
        }
        
    };
    
    public int inicio(){ //iniciar tarea programada.
        //como esto se ejecuta continuamente cuando se llama, hasta comparando en el booleano del if, 
        //da error de ejecucion el Timer porq la Task ya se puso en marcha, por eso está el try.
        //scheduleAtFixedRate es para PROGRAMAR la tarea, y mantener una velocidad sincronizada/fija.
        
        try  //0) esto INTENTARÁ capturar el error si se produce y una vez capturado hacer algo con él                    
        {   //valor de inicio, final donde la "tarea"task empieza a ejecutarse en milisegundos.        
            Tiempo.scheduleAtFixedRate(Tarea, 100, 100);  //contar de a 100 milisegundos, ==10 seguntransc.. será 1 segundo.    
            System.out.println("INICIO EJECUTADO"); //Si está ejecutada la tarea, no se ejecutará al llamar.
        }catch (Exception e)//“Exception e”. Esto significa que cuando se produce un error Java genera un objeto de tipo Exception con la información sobre el error y este objeto se envía al bloque catch.(solo se ejecuta si hay error.)
        { // Mensaje en caso de que falle 
        }
        return segundosTranscurridos; //retorna entero, cada segundo vale 10, así para poder controlar una décima de cualquier cantidad.
        
    }
        
   //Detiene el contador
    public void Detener() {
       Tiempo.cancel();
       Tiempo.purge();
       
       segundosTranscurridos = 0;
       Tarea = new TimerTask()
        {
            @Override
            public void run(){
                
                segundosTranscurridos++;  //centenasTranscurridas.  100 = 1décima, 100*(10^-1)==10.0                         extra: ej: 23,400
                System.out.println("SEGUNDOS Transcurridos: "+ (segundosTranscurridos * Math.pow(10, -1)) );
                
            }
            
        };
        Tiempo = new Timer();
    
}





    
    } */
    
    
    
    //act similar al método main.
    /**
     * Act - do whatever the Jugadores wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.

        
    }    
}
