import java.util.Scanner;
public class Calango{
    int bucho;
    int maxBucho;
    int nPatas;
    boolean alive;
    int vida;
    //parametros das variáveis = sombreamento
    Calango(int maxBucho){
        this.bucho=maxBucho;
        this.maxBucho=maxBucho;
        this.nPatas = 4;
        this.alive = true;
        this.vida = 4;
    }


    void comer(int qtd){
        if(alive==true){
            bucho+=qtd;
            if(bucho > maxBucho){
                bucho=maxBucho;
                System.out.println("comi até encher");
            }else{
                System.out.println("Tô cheio");
            }
        }else{
            System.out.println("Morto");
            alive=false;
        }
    }
    void andar(int dist){
        if(alive==true){
            if(nPatas < 2){
                System.out.println("Não posso andar com essa quantidade de patas");
                return;
            }
            if(bucho>0){
                if(bucho<dist){
                    System.out.println("Andei só"+ bucho);
                    bucho=0;
                    return;
                }
                bucho-=dist;
                System.out.println("Estou andando gastei energia");
                return;
            }
            if(bucho==0 && vida > 0){
                if(dist > vida){
                    System.out.println("Andei até "+vida+" e morri");
                    vida=0;
                    alive=false;
                    return;
                }
                System.out.println("Gastei vida par andar");
                vida-=dist;
                if(vida<=0)
                    alive=false;
                return;
            }




        }else{
            System.out.println("Morto");
            alive=false;
        }
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
                if(vida==0){
                    alive=false;
                    System.out.println("Morri me regenerando");
                }
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

        Calango deadlango = new Calango(20);
        Scanner scanner= new Scanner(System.in);        
        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
        if(line.equals("end")){
            break;
        }else if(line.equals("show")){
            System.out.println(deadlango);
        }else if(ui[0].equals("andar")){
            deadlango.andar(Integer.parseInt(ui[1]));
        }else if(ui[0].equals("comer")){
            deadlango.comer(Integer.parseInt(ui[1]));
        }else if(line.equals("regenerar")){
            deadlango.regenerar();
        }else if(line.equals("acidentar")){
            deadlango.acidentar();

        }else{
            System.out.println("comando inválido");
        }   
        
    }
        
        scanner.close();


    }


}