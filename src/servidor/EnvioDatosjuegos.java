package servidor;

/**
 *
 * @author Ellioth
 */
public class EnvioDatosjuegos {
    private double posX;
    private double posY;
    private boolean disparo;
    private int TipoDisparo;
    
    public EnvioDatosjuegos(){
        posX=0;
        posY=0;
        disparo=false;
        TipoDisparo=0;
    }
    
    public void verificarMensaje(String mensaje){
        try{
            String [] vector= mensaje.split(",");
            if(vector[0].equals("A"))
                setPosX(-30);
            else if(vector[0].equals("a"))
                setPosX(+30);
            if (vector[1].equals("i"))
                setPosY(-30);
            else if (vector[1].equals("d"))
                setPosY(+30);
            if (vector[2].equals("t"))
                setDisparo(true);
            else if (vector[2].equals("f"))
                setDisparo(false);
            if(vector[3].equals("1"))
                setTipoDisparo(1);
            else if(vector[3].equals("2"))
                setTipoDisparo(2);
            else if(vector[3].equals("3"))
                setTipoDisparo(3);
            else if(vector[3].equals("4"))
                setTipoDisparo(4);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error de mensaje entrante (se fue a la pichita)");
        }
    }
    public void setPosX(double posX){
        this.posX= posX;
    }
    
    public void setPosY(double posY){
        this.posY=posY;
    }
    
    public void setDisparo(boolean disparo){
        this.disparo= disparo;
    }
    
    public void setTipoDisparo(int TipoDisparo){
        this.TipoDisparo=TipoDisparo;
    }
}
