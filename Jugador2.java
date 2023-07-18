import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Timer;
import java.util.TimerTask;
import java.io.IOException;
import java.util.Random;

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador2 extends Jugadores
{
    /**
     * Act - do whatever the Jugador2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    //Constructor:
    public Jugador2()
    {
        setImage("Personajes/KyoKusanagi/KyoAnimA1.png");
        setLocation(400, 200);
        
        
        Player1.setVelocidadMov(5);
        Player1.setFuerzaGravedad(0); //Fuerza de caída inicial y método que almacenará la velocidad de la caída total.
        Player1.setAcelerarGravedad(1);  //1      
        Player1.setFuerzaSaltar(16);     //16   bloques de pixeles -1 en cada bloque        
        
    }
    
    //Creo e inicializo el objeto "Player1" con atributos de "Jugadores".
    Jugadores Player1 = new Jugadores();
    
    Jugadores Tiempo1 = new Jugadores();
    
    Random NumAleatorio = new Random();    //el new es para que cada vez sea un nuevo random y no me de error de nullException.
    //GreenfootSound SPunioDebil = new GreenfootSound("");//dejo la String vacía ya que los valores/NombreDelArchivo se los daré abajo en la animación.
    
    
    private boolean PermisoSalto=true, cancelaranimBaseP1, cancelaranimAvanceP1, siSeAgacho, PunioDebilOn, PatadaDebilOn, PunioFuerteOn, PatadaFuerteOn = false;// especifíco sus valores una por una, las q no tienen por defecto es false.
    boolean Empezar=false, pass=false;
    int cuenta=0, reseteoRun =0;
    boolean lados;
    
    //Variables para las permutacionesOrden/COMBINACIONESsinOrden.
    int RPunioDebil, RPatadaDebil, RPunioFuerte, RPatadaFuerte; //Declaro la variable para el numero RANDOM para la "permutación" del sonido del golpe.
    int RangoPunioD=2, RangoPatadaD=2 ,RangoPunioF=2, RangoPatadaF=2; //establezco el rango disponible para la CANTIDAD de sonidos posibles.
    
    // Teclas.
    String izquierda="left", derecha="right";
    
    GreenfootSound Soundtrack = new GreenfootSound("Personajes/KyoKusanagi/The_King_of_Fighters_2002_Unlimited_Match_-_ESAKA_.wav");
    public void act()
    {
        
        Soundtrack.play();
        
        coordPly2 = getX();
        
        if(testColider() == true)
        {
            System.out.println("El objeto tocado está en estado verdadero");
        }else{System.out.println("El objeto tocado está en estado falso");}
        
        
        // Add your action code here.  //EN EL if el método se activa ._.
          //iniciar (llama al método "inicio" de la clase ..para empezar a contar.
        if(Tiempo1.iniciar() == 50)         //10 = 1 segundo.
        { System.out.println("se cumplió 5 segundo shamo oie khe zukulentongo"); }
        //System.out.println("conteo: "+Tiempo1.inicio() );//esto sigue ejecutandose.
        
        HabilitarGravedadJ1();        
        
        if(Greenfoot.isKeyDown("q") )
        {
             Empezar=false; //método para detener el conteo de milisegundos del objeto Tiempo1 que heredó de la clase contador.
        }
                  
        if(Greenfoot.isKeyDown("e") )
        {
             Empezar=true;
        }
        
        if(Empezar==true)
        {
            Tiempo1.iniciar();
        }
        else {Tiempo1.Detener();}
        
        
        
        if(cancelaranimBaseP1 == false) //Ejecuta la animación estandar si no se está moviendo.
        {   AnimBase();            
            siSeAgacho = true;
        }        
       
        if(Greenfoot.isKeyDown("t") )
        {
            try {
            Thread.sleep (2000);
            } catch (Exception e) {
            // Mensaje en caso de que falle
            }
            //wait(5);
        }
        
        
        //MOVIMIENTO
        
        if(Greenfoot.isKeyDown(derecha) && Greenfoot.isKeyDown(izquierda) )
        {setLocation(getX() + Player1.getVelocidadMov(), getY() ); }
        else    //
        if(Greenfoot.isKeyDown(derecha) && (PunioDebilOn==false && PunioFuerteOn==false && PatadaDebilOn==false && PatadaFuerteOn==false) )
        {   //pass = pasó. (no ha pasado). ejecutará la animacion de avance normal.
            if(testColider() == false){
                setLocation(getX() + Player1.getVelocidadMov(), getY() );
            }
            if(  pass==false)  //siSeAgacho==false &&          
            {
                if(coordPly2 > coordPly1){
                AnimAndarAtras();
                }else {AnimAndarAdelante();}
            }            
        }
    
        if(Greenfoot.isKeyDown(izquierda) && (PunioDebilOn==false && PunioFuerteOn==false && PatadaDebilOn==false && PatadaFuerteOn==false) )        
        {
            // Mover Hacia La Izquierda: Pone el jugador en la misma coordenada Y, y pone el jugador en la misma coordenada X
            // MENOS la velocidad establecida, irá hacia la Izquierda:
            if(testColider() == false){
                setLocation(getX() - Player1.getVelocidadMov(), getY() );
            }
            
            if(coordPly2 > coordPly1){
                AnimAndarAdelante();
            }else {AnimAndarAtras();}//--------------------------------------------------------------
            
        }
    
        //Correr
     
        if(Greenfoot.isKeyDown(derecha) && cuenta == 0)
            
        {   
            cuenta = 1;
            
        }    
        
        if(!Greenfoot.isKeyDown(derecha) && cuenta == 1 )
        {
          cuenta = 2;
        }        
        
        boolean restLeft = false, restRight = false;        
        if(Greenfoot.isKeyDown(derecha) && cuenta ==2)
        {          
          AnimCorrer(); 
              if(pass==false){ //como es la segunda vez q presiona 2 y d está presionada y pass es falsa, estaría corriendo y aumenta una vez 2 a la velocidad
                  if(coordPly2 > coordPly1){
                      Player1.setVelocidadMov((Player1.getVelocidadMov() + 10)*(-1) );}
                  else{Player1.setVelocidadMov((Player1.getVelocidadMov() + 10) );}
                  //else{Player1.setVelocidadMov(Player1.getVelocidadMov() + 10);} 
              pass = true; //esto avisa q está corriendo, para no dejar ejecutar la animación de avanzar. 
              boolean velTemp=false;
            }
          
        }          
        if(!Greenfoot.isKeyDown(derecha) && pass == true)
        {            //como pass ya cambia a true después de correr y soltar la tecla d entonces quita el aumento de velocidad.
            //Player1.setVelocidadMov( (Player1.getVelocidadMov() - 10)*(-1) );
            if(coordPly2 >= coordPly1){                      
                      restRight=true;}
            else{restLeft=true;;} 
            
            cuenta = 0;
            pass = false;            
        }
        //PENDIENTE REVISAR EL CAMBIO AL CORRER!!.
        if(restRight == true){
            Player1.setVelocidadMov((Player1.getVelocidadMov() + 10)*(-1) );
            restRight=false;
        }
        
        if(restLeft ==true){
           Player1.setVelocidadMov((Player1.getVelocidadMov() - 10) );
           restLeft = false;
        }
        
        
        
        
        
        
        if(!Greenfoot.isKeyDown(derecha)) //esto empezará a contar desde q toca la tecla, para tener un rango de tiempo en q se pueda correr.
        {
           reseteoRun ++;
           
        }
        if(reseteoRun == 15) //si ya pasó esa cantidad de ticks, entonces resetea la cuenta para evitar 
        //q corra después de q pase ese tiempo(por no presionar rápido la tecla). pero no es confiable ya q ese conteo solo se ejecuta mientras presiona la tecla y puede generar bugs.
        { cuenta = 0; reseteoRun = 0; }
        //fin de correr        
        
        //Agacharse: PENDIENTE REPARAR BUGS.
        if(Greenfoot.isKeyDown("down") && (ColisionSuelo()==true || getY() ==415) )
        { 
            AnimAgacharse();
            cancelaranimAvanceP1=true;
        }
        else{ cancelaranimAvanceP1 =false;}
        
        
        if(!Greenfoot.isKeyDown("down")  && siSeAgacho == true && getY() ==415 )
        {
            
            FotogramaD = 0;            
        }
        
        if(!Greenfoot.isKeyDown("down")  && (!Greenfoot.isKeyDown("up") && ColisionSuelo() ) )
        {
            setLocation(getX(), 415 );
            
        }
        //FinConfiguraciónPrincipalAgacharse.
        
        
        //INACTIVOPORAHORA->Delay es para mantener un retraso corto entre cada salto, esto para evitar el salto demasiado continuo.
        //PermisoSalto es para que solo se pueda volver a saltar hasta que dejen de mantener la w y la presionen de nuevo.
        if(Greenfoot.isKeyDown("up") && ColisionSuelo() == true && PermisoSalto==true)//añadir de condición el suelo, para saltar solo si está en el suelo.
        {
               
            //La multiplicación amplifica el salto para amplificar la velocidad y poder seguir con la misma altura (sin reducirse la distancia del salto).
            //La fuerza del salto se multiplica por la velocidad establecida para amplificar su misma velocidad sin afectar la distancia del salto.
            Player1.setFuerzaGravedad( -(Player1.getFuerzaSaltar() *Player1.getAcelerarGravedad() ) ); //Proporción negativa inicial de avance vertical de pixeles.
            Gravedad();//-> En un primer ciclo se activa el método Gravedad() para poner al jugador arriba del suelo la cantidad de pixeles
            // del salto inicial, así dejará de tocar el suelo, y se activará el método HabilitarGravedadJ1() para que siga el salto y
            //y se termine una vez llega de nuevo al suelo.
        
            //restarle una secuencia(cantidad/bloque de pixeles) para q empiece el siguiente salto desde una "sección/bloque de pixeles" anterior, para evitar que el salto se vea iniciando desde más arriba de la plataforma.
            Player1.setFuerzaGravedad(Player1.getFuerzaGravedad() -(Player1.getFuerzaGravedad()/Player1.getFuerzaSaltar()) );
            
            PermisoSalto=false;
            

        }
        if(!Greenfoot.isKeyDown("up") && getY() ==415 )
        {PermisoSalto=true;}
        
  
        
        //Si el player se mueve, cancelar la animación estandar para que no afecte interfiriendo con las otras animaciones en ejecución.
        if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown(izquierda) || Greenfoot.isKeyDown(derecha) || Greenfoot.isKeyDown("down") 
        || PunioDebilOn==true || PunioFuerteOn==true || PatadaDebilOn==true || PatadaFuerteOn== true)
        { cancelaranimBaseP1 =true; FotogramaA = 0; cancelaranimAvanceP1=true; }
        else {cancelaranimBaseP1= false; cancelaranimAvanceP1=false;}

        
        
        //ATAQUES BÁSICOS:
        //Puño Debil se ejecutará mientras no se esté ejecutando los demás ataques básicos.
        if(Greenfoot.isKeyDown("4") && (PunioFuerteOn==false && PatadaDebilOn==false && PatadaFuerteOn==false) )
        {
            PunioDebilOn = true;            
        }        
        if(PunioDebilOn==true )
        {
            AnimPunioDebil();
        }            
        //Puño Fuerte
        if(Greenfoot.isKeyDown("2") && (PunioDebilOn== false && PatadaDebilOn==false && PatadaFuerteOn==false))
        {
            PunioFuerteOn = true;
        }        
        if(PunioFuerteOn==true )
        {
            AnimPunioFuerte();
        }        
        
        if(Greenfoot.isKeyDown("5") && (PunioDebilOn== false && PunioFuerteOn==false && PatadaFuerteOn==false) )
        {
            PatadaDebilOn = true;
        }        
        if(PatadaDebilOn==true )
        {
            AnimPatadaDebil();
        }
        
        if(Greenfoot.isKeyDown("1") && (PunioDebilOn== false && PunioFuerteOn==false && PatadaDebilOn==false) )
        {
            PatadaFuerteOn = true;
        }        
        if(PatadaFuerteOn==true )
        {
            AnimPatadaFuerte();
        }
        
    }
    
    
    
    
    
    
    //METODOS EXTERNOS:

    public void Gravedad()
    {
        //Extra: Quitar bug que hace transpasar el suelo por la rapidez de la aceleración. (inicio de quitar bug)
        if( ( getY()+Player1.getFuerzaGravedad() ) >415) //si el valor que se obtuvo queda por debajo del suelo, entonces
        {                                                //el siguiente valor a establecer será exactamente el inicio del suelo.
            setLocation(getX(), 415 ); 
        } 
        else //sino se pasa, el código seguirá normal. (Fin de quitar bug).
        {
        // Cada vez que se ejecute Gravedad(), va a poner al jugador en las mismas coordenadas, pero al eje Y
        //le sumará o restará el valor de fuerzagravedad el cuál será la cantidad de pixeles q se mueva en cada ciclo.
        //Esto ocurrirá rápida y continuamente, dando un efecto estable de aumento y disminución del salto:        

        
        setLocation(getX(), getY() + Player1.getFuerzaGravedad() );        
        
        System.out.println(Player1.getFuerzaGravedad());
        
        
        //En cada ciclo, FuerzaGravedad() va a ser igual a FuerzaGravedad() más el valor fijo de aceleración:
        //ej: 0 = 0+2, 2=2+2, 4=4+2, así sucesivamente irá aumentando de 2 en 2 para simular efecto de aceleración. 
        //Este valor será la cantidad de pixeles que se transladará desde una coordenada Y actual (cantidad negativa,subirá. Cantida positiva, bajará en el eje Y):
            for(int i=0;i < Player1.getAcelerarGravedad();i++)  //cantidad de ciclos dependiendo de la aceleración, para aumentar la cantidad de pixeles en cada tiempo.
            {
                Player1.setFuerzaGravedad( Player1.getFuerzaGravedad()+Player1.getAcelerarGravedad() );
            }
        }
            
    }    
    private void HabilitarGravedadJ1()
    {
        if(!ColisionSuelo() && getY()<415) //si collisionSuelo es falso entonces no está el suelo y activará la gravedad para que caiga:
        {
            Gravedad();
        }
        else //sino, entonces está en el suelo y no activará la gravedad.
        {
            
        }
        
        
    }
    
    
    
    //ANIMACIONES:
    
    
    private int FotogramaA = 0;    //Animación Estandar.
    public void AnimBase()
    {
            FotogramaA ++;
            
 
            if(FotogramaA == 5)                
            {   if(coordPly2 > coordPly1){
                setImage("Personajes/KyoKusanagi/KyoAnimA1.png");
                getImage().mirrorHorizontally();}
                else{setImage("Personajes/KyoKusanagi/KyoAnimA1.png");}
            }    
            if(FotogramaA == 10)
            {   if(coordPly2 > coordPly1){
                setImage("Personajes/KyoKusanagi/KyoAnimA2.png");
                getImage().mirrorHorizontally();}
                else{setImage("Personajes/KyoKusanagi/KyoAnimA2.png");}
            }
            if(FotogramaA == 15)
            {   if(coordPly2 > coordPly1){
                setImage("Personajes/KyoKusanagi/KyoAnimA3.png");
                getImage().mirrorHorizontally();}
                else{setImage("Personajes/KyoKusanagi/KyoAnimA3.png");}
            }
            if(FotogramaA == 20)
            {   if(coordPly2 > coordPly1){
                setImage("Personajes/KyoKusanagi/KyoAnimA4.png");
                getImage().mirrorHorizontally();}
                else{setImage("Personajes/KyoKusanagi/KyoAnimA4.png");}
            }
            if(FotogramaA == 25)
            {   if(coordPly2 > coordPly1){
                setImage("Personajes/KyoKusanagi/KyoAnimA5.png");
                getImage().mirrorHorizontally();}
                else{setImage("Personajes/KyoKusanagi/KyoAnimA5.png");}
            }
            if(FotogramaA == 30)
            {   if(coordPly2 > coordPly1){
                setImage("Personajes/KyoKusanagi/KyoAnimA6.png");
                getImage().mirrorHorizontally();}
                else{setImage("Personajes/KyoKusanagi/KyoAnimA6.png");}
            }
            if(FotogramaA == 35)
            {   if(coordPly2 > coordPly1){
                setImage("Personajes/KyoKusanagi/KyoAnimA7.png");
                getImage().mirrorHorizontally();}
                else{setImage("Personajes/KyoKusanagi/KyoAnimA7.png");}
            }
            if(FotogramaA == 40)
            {   if(coordPly2 > coordPly1){
                setImage("Personajes/KyoKusanagi/KyoAnimA8.png"); 
                getImage().mirrorHorizontally();}
                else{setImage("Personajes/KyoKusanagi/KyoAnimA8.png");}
            }
            if(FotogramaA == 45)
            {   if(coordPly2 > coordPly1){
                setImage("Personajes/KyoKusanagi/KyoAnimA9.png");
                getImage().mirrorHorizontally();}
                else{setImage("Personajes/KyoKusanagi/KyoAnimA9.png");}
            }
            if(FotogramaA == 50)
            {   if(coordPly2 > coordPly1){
                setImage("Personajes/KyoKusanagi/KyoAnimA10.png"); 
                getImage().mirrorHorizontally();}
                else{setImage("Personajes/KyoKusanagi/KyoAnimA10.png");}
            }
            if(FotogramaA == 55)
            {
                if(coordPly2 > coordPly1){
                    setImage("Personajes/KyoKusanagi/KyoAnimA11.png");
                    getImage().mirrorHorizontally();}
                    else{setImage("Personajes/KyoKusanagi/KyoAnimA11.png");}
                
                FotogramaA = 0;                
            }            
    }
    
    private int FotogramaB=0; //Animación Avance.
    public void AnimAndarAdelante()
    {
            FotogramaB ++;
            if(FotogramaB == 4)
            {
                setImage("Personajes/KyoKusanagi/KyoAnimB1.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaB == 8){
                setImage("Personajes/KyoKusanagi/KyoAnimB2.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaB == 12){
                setImage("Personajes/KyoKusanagi/KyoAnimB3.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaB == 16){
                setImage("Personajes/KyoKusanagi/KyoAnimB4.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaB == 20){
                setImage("Personajes/KyoKusanagi/KyoAnimB5.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaB == 24){
                setImage("Personajes/KyoKusanagi/KyoAnimB6.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaB == 28){
                setImage("Personajes/KyoKusanagi/KyoAnimB7.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaB == 32){
                setImage("Personajes/KyoKusanagi/KyoAnimB8.png");     
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaB == 36){
                setImage("Personajes/KyoKusanagi/KyoAnimB9.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaB == 40){
                setImage("Personajes/KyoKusanagi/KyoAnimB10.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaB == 44){            
                setImage("Personajes/KyoKusanagi/KyoAnimB11.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}            
                FotogramaB = 4;
            }
            
    }
    
    int FotogramaC=0;
    public void AnimAndarAtras() //Animación retroceso.
    {
            FotogramaC ++;
            if(FotogramaC == 4){
                setImage("Personajes/KyoKusanagi/KyoAnimC1.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaC == 8){
                setImage("Personajes/KyoKusanagi/KyoAnimC2.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaC == 12){
                setImage("Personajes/KyoKusanagi/KyoAnimC3.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaC == 16){
                setImage("Personajes/KyoKusanagi/KyoAnimC4.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaC == 20){
                setImage("Personajes/KyoKusanagi/KyoAnimC5.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaC == 24){
                setImage("Personajes/KyoKusanagi/KyoAnimC6.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaC == 28){
                setImage("Personajes/KyoKusanagi/KyoAnimC7.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaC == 32){
                setImage("Personajes/KyoKusanagi/KyoAnimC8.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaC == 36){
                setImage("Personajes/KyoKusanagi/KyoAnimC9.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaC == 40){            
               setImage("Personajes/KyoKusanagi/KyoAnimC10.png");
               if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}            
                FotogramaC = 0;
            }
    }     
    
    int FotogramaD=0;    
    public void AnimAgacharse()
    {
            FotogramaD ++;
            if(FotogramaD == 4){
                setImage("Personajes/KyoKusanagi/KyoAnimD1.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaD == 8){
                setImage("Personajes/KyoKusanagi/KyoAnimD2.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaD == 12){
                setImage("Personajes/KyoKusanagi/KyoAnimD3.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaD == 16){
                setImage("Personajes/KyoKusanagi/KyoAnimD4.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaD == 20){
                setImage("Personajes/KyoKusanagi/KyoAnimD5.png");     
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaD == 24){
                setImage("Personajes/KyoKusanagi/KyoAnimD6.png");                
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaD == 28){
                setImage("Personajes/KyoKusanagi/KyoAnimD7.png");   
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaD == 32){
                setImage("Personajes/KyoKusanagi/KyoAnimD8.png");  
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaD == 36){
                setImage("Personajes/KyoKusanagi/KyoAnimD9.png");  
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaD == 40){
                setImage("Personajes/KyoKusanagi/KyoAnimD10.png");      
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaD == 44){            
                setImage("Personajes/KyoKusanagi/KyoAnimD11.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
    }
    
    int FotogramaH=0;    
    public void AnimCorrer()
    {
            FotogramaH ++;
            if(FotogramaH == 2){
                setImage("Personajes/KyoKusanagi/KyoAnimH1.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaH == 4){
                setImage("Personajes/KyoKusanagi/KyoAnimH2.png");                
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaH == 8){
                setImage("Personajes/KyoKusanagi/KyoAnimH3.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaH == 12){
                setImage("Personajes/KyoKusanagi/KyoAnimH4.png");               
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaH == 16){
                setImage("Personajes/KyoKusanagi/KyoAnimH5.png");                
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaH == 20){
                setImage("Personajes/KyoKusanagi/KyoAnimH6.png");                
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaH == 24){
                setImage("Personajes/KyoKusanagi/KyoAnimH7.png");               
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaH == 28){
                setImage("Personajes/KyoKusanagi/KyoAnimH8.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaH == 32){
                setImage("Personajes/KyoKusanagi/KyoAnimH9.png");                            
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaH == 36)
            {
                setImage("Personajes/KyoKusanagi/KyoAnimH10.png");
                FotogramaH=2;
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            
    }
    
    //Animaciones golpes básicos.
    int FotogramaJ=0;
    public void AnimPunioDebil() //Animación puño debil.
    {
            FotogramaJ ++;
            if(FotogramaJ == 4)  { //ejecutando el sonido desde que la animación/puño puede ejecutarse.
                setImage("Personajes/KyoKusanagi/KyoAnimJ1.png");                
                SonidoPunioDebil();//inicia la animación y ejecuta el sonido.
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }                 
            if(FotogramaJ == 8){
                setImage("Personajes/KyoKusanagi/KyoAnimJ2.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaJ == 12){
                setImage("Personajes/KyoKusanagi/KyoAnimJ3.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaJ == 16){
                setImage("Personajes/KyoKusanagi/KyoAnimJ4.png");                
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaJ == 20){
                setImage("Personajes/KyoKusanagi/KyoAnimJ5.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaJ == 24){
                setImage("Personajes/KyoKusanagi/KyoAnimJ6.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaJ == 28){
                setImage("Personajes/KyoKusanagi/KyoAnimJ7.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaJ == 32){
                setImage("Personajes/KyoKusanagi/KyoAnimJ8.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaJ == 36){
                setImage("Personajes/KyoKusanagi/KyoAnimJ9.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaJ == 40)
            {
                setImage("Personajes/KyoKusanagi/KyoAnimJ10.png");                
                FotogramaJ = 0;
                PunioDebilOn = false;
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
    }       
    public void SonidoPunioDebil(){
                GreenfootSound SPunioDebil = new GreenfootSound("Personajes/KyoKusanagi/KyoSonidoJ3.wav"); //este se ejecutará fijo ya q es el sonido del aire causado por el golpe.
                SPunioDebil.play();
                
                RPunioDebil = NumAleatorio.nextInt(RangoPunioD)+1; //primero asigna desde el valor random inicial en adelante, ya q por defecto vale 0. randon va de 1 a 2.
                SPunioDebil = new GreenfootSound("Personajes/KyoKusanagi/KyoSonidoJ" +RPunioDebil+ ".wav"); //Asigna el sonido + el número random para q alterne el sonido cada vez y aleatoriamente.
                SPunioDebil.play();                
                System.out.println("Permutacion de Sonido1: "+RPunioDebil);    
    }
    
    int FotogramaK=0;
    public void AnimPatadaDebil() //Animación patada debil.
    {
            FotogramaK ++;
            if(FotogramaK == 2){                
                setImage("Personajes/KyoKusanagi/KyoAnimK1.png");
                SonidoPatadaDebil();
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaK == 5){
                setImage("Personajes/KyoKusanagi/KyoAnimK2.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaK == 9){
                setImage("Personajes/KyoKusanagi/KyoAnimK3.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaK == 11){
                setImage("Personajes/KyoKusanagi/KyoAnimK4.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaK == 13){
                setImage("Personajes/KyoKusanagi/KyoAnimK5.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaK == 15){
                setImage("Personajes/KyoKusanagi/KyoAnimK6.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaK == 17){
                setImage("Personajes/KyoKusanagi/KyoAnimK7.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaK == 19){
                setImage("Personajes/KyoKusanagi/KyoAnimK8.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }             

            if(FotogramaK == 21)
            {
                setImage("Personajes/KyoKusanagi/KyoAnimK9.png");
                FotogramaK = 0;
                PatadaDebilOn = false;
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
    }
    public void SonidoPatadaDebil(){
                GreenfootSound SPatadaDebil = new GreenfootSound("Personajes/KyoKusanagi/KyoSonidoK3.wav");
                SPatadaDebil.play();
                
                RPatadaDebil = NumAleatorio.nextInt(RangoPatadaD)+1;
                SPatadaDebil = new GreenfootSound("Personajes/KyoKusanagi/KyoSonidoK" +RPatadaDebil+ ".wav");
                SPatadaDebil.play();                
                System.out.println("Permutacion de Sonido2: "+RPatadaDebil);                
    }
    
    int FotogramaL=0;
    public void AnimPunioFuerte() //Animación puño debil.
    {
            FotogramaL ++;
            if(FotogramaL == 4){
                setImage("Personajes/KyoKusanagi/KyoAnimL1.png");
                SonidoPunioFuerte();
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }                
            if(FotogramaL == 8){
                setImage("Personajes/KyoKusanagi/KyoAnimL2.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaL == 12){
                setImage("Personajes/KyoKusanagi/KyoAnimL3.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaL == 16){
                setImage("Personajes/KyoKusanagi/KyoAnimL4.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaL == 20){
                setImage("Personajes/KyoKusanagi/KyoAnimL5.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaL == 24){
                setImage("Personajes/KyoKusanagi/KyoAnimL6.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaL == 28){
                setImage("Personajes/KyoKusanagi/KyoAnimL7.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaL == 32){
                setImage("Personajes/KyoKusanagi/KyoAnimL8.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }             
            if(FotogramaL == 36){
                setImage("Personajes/KyoKusanagi/KyoAnimL9.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaL == 40)
            {
                setImage("Personajes/KyoKusanagi/KyoAnimL10.png");
                FotogramaL = 0;
                PunioFuerteOn = false;  
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
    }
    public void SonidoPunioFuerte(){
                GreenfootSound SPunioFuerte = new GreenfootSound("Personajes/KyoKusanagi/KyoSonidoL3.wav");
                SPunioFuerte.play();
                
                RPunioFuerte = NumAleatorio.nextInt(RangoPunioF)+1;
                SPunioFuerte = new GreenfootSound("Personajes/KyoKusanagi/KyoSonidoL" +RPunioFuerte+ ".wav");
                SPunioFuerte.play();                
                System.out.println("Permutacion de Sonido3: "+RPunioFuerte);                
    }

    int FotogramaM=0;
    public void AnimPatadaFuerte() //Animación puño debil.
    {
            FotogramaM ++;
            if(FotogramaM == 3){
                setImage("Personajes/KyoKusanagi/KyoAnimM1.png");
                SonidoPatadaFuerte();
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaM == 6){
                setImage("Personajes/KyoKusanagi/KyoAnimM2.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaM == 9){
                setImage("Personajes/KyoKusanagi/KyoAnimM3.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaM == 12){
                setImage("Personajes/KyoKusanagi/KyoAnimM4.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaM == 15){
                setImage("Personajes/KyoKusanagi/KyoAnimM5.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaM == 18){
                setImage("Personajes/KyoKusanagi/KyoAnimM6.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaM == 21){
                setImage("Personajes/KyoKusanagi/KyoAnimM7.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaM == 24){
                setImage("Personajes/KyoKusanagi/KyoAnimM8.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }             
            if(FotogramaM == 27){
                setImage("Personajes/KyoKusanagi/KyoAnimM9.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaM == 30){
                setImage("Personajes/KyoKusanagi/KyoAnimM10.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaM == 33){
                setImage("Personajes/KyoKusanagi/KyoAnimM11.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaM == 36){
                setImage("Personajes/KyoKusanagi/KyoAnimM12.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaM == 39){
                setImage("Personajes/KyoKusanagi/KyoAnimM13.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaM == 42){
                setImage("Personajes/KyoKusanagi/KyoAnimM14.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaM == 45){
                setImage("Personajes/KyoKusanagi/KyoAnimM15.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaM == 48){
                setImage("Personajes/KyoKusanagi/KyoAnimM16.png");
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}
            }
            if(FotogramaM == 51)
            {
                setImage("Personajes/KyoKusanagi/KyoAnimM17.png");                
                FotogramaM = 0;
                PatadaFuerteOn = false;
                if(coordPly2 > coordPly1){
                getImage().mirrorHorizontally();}                
            }            
    }
    public void SonidoPatadaFuerte(){
                GreenfootSound SPatadaFuerte = new GreenfootSound("Personajes/KyoKusanagi/KyoSonidoM3.wav");
                SPatadaFuerte.play();
                
                RPatadaFuerte = NumAleatorio.nextInt(RangoPatadaF)+1;
                SPatadaFuerte = new GreenfootSound("Personajes/KyoKusanagi/KyoSonidoM" +RPatadaFuerte+ ".wav");
                SPatadaFuerte.play();                
                System.out.println("Permutacion de Sonido3: "+RPatadaFuerte);                
    }    
    
}