
public class Calango{
    int bucho;
    int maxBucho;
    int nPatas;
    boolean alive;
    int vida;
    //parametros das variáveis = sombreamento
    Calango(int bucho,int maxBucho,int nPatas,boolean alive ,int vida){
        this.bucho=bucho;
        this.maxBucho=maxBucho;
        this.nPatas = nPatas;
        this.alive = alive;
        this.vida = vida;
    }


    void comer(){
        if(alive==true){
            if(bucho < maxBucho){
                bucho++;
                System.out.println("nham nham que gostoso");
            }else
                System.out.println("Tô cheio");
    
        }else{
            System.out.println("Morto");
            alive=false;
        }
    }
    void andar(){
    if(nPatas>1){
        if(alive==true){
            if(bucho>0){
                bucho--;
                System.out.println("Estou andando perdi energia");
            }else if(vida>0){
                vida--;
                System.out.println("Estou usando vida para andar");
                if(vida<=0)
                    alive=false;
            }else{
                System.out.println("Morto");
                alive=false;
            }



        }
      
                
    
     
    }else
        System.out.println("Não consigo andar com esse tanto de patas");   
}
    void acidentar(){
        if(alive==true){
            if(nPatas > 0){
                nPatas--;
                System.out.println("Ouch!");
            }else if(vida > 0){
                System.out.println("acidentes estão causando dano na minha vida");
                vida--;
                if(vida<=0){
                    System.out.println("Morto");
                    alive=false;
                    }
                }
        }else{
            System.out.println("Morto");
            alive=false;  
        }
    }
    void regenerar(){
        if(alive == true){
            if(nPatas == 4){
                System.out.println("Estou perfeito");
            }else if(bucho>0){
                bucho--;
                nPatas++;
                System.out.println("Regenerei uma pata");
            }else if(vida>0 && nPatas < 4){
                System.out.println("Não tenho energia para regenerar vou usar minha vida para regenerar");
                vida--;
                nPatas++;
            }
            else{
                System.out.println("Morto");
                alive=false;
                } 
        }else
            System.out.println("Morto");        
    }

public String toString(){
    return "Bucho: "+ bucho + "/" + maxBucho + " Patas: " + nPatas + " Vivo: " + alive + " Vidas: " +vida;
}
    public static void main(String[] args){
        

        //referencia   =         objeto
        Calango deadlango = new Calango(0,20,4,true,4);

        deadlango.acidentar();
        deadlango.acidentar();
        deadlango.acidentar();
        deadlango.andar();
        deadlango.comer();
        deadlango.regenerar();
        deadlango.regenerar();
        deadlango.regenerar();
        deadlango.regenerar();
        
        



    }


}