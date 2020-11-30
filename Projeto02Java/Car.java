public class Car{
    int pass;
    int passMax;
    int gas;
    int gasMax;
    int km;

    Car(int pass, int passMax,int gas,int gasMax,int km){
        this.pass=pass;
        this.passMax=passMax;
        this.gas=gas;
        this.gasMax=gasMax;
        this.km=km;
    }


    boolean in(){
        if(pass < passMax){
            pass++;
            return true;
        }else{
            System.out.println("Limite de pessoas atingido");
            return false;
        }

    }
    boolean out(){
        if(pass>0){
            pass--;
            return true;
        }else{
            System.out.println("Não tem ninguém para sair");
            return false;
        }
    }
    void fuel(int value){
        if(gas<gasMax){
            gas+= value;
            if(gas>gasMax)
                gas=100;
        }
        else
            gas=100;
            System.out.println("tanque cheio");    
    }
    boolean drive(int distance){
        int k;
        if(pass>0){
            if(gas>0){
                gas-=distance;
                if(gas<0){
                    km = km + (distance+gas);
                    k= distance + gas;
                    System.out.println("Tanque vazio ao alcançar " + k + "km");
                    gas=0;
                    return false;
                }else{
                    km+=distance;
                    System.out.println("Foi possivel chegar");
                    return true;
                }

            }   
            else{
                System.out.println("Tanque vazio");
                return false;
            }    


            




                  
    }else{
        System.out.println("Ninguém para dirigir");
        return false;
        }
    }

   public String toString(){
       return "pass: " + pass + " gas:" + gas + " km: " + km;
   } 

   public static void main(String[] args){

    Car car = new Car(0,2,0,100,0);
    System.out.println(car);
    //pass: 0, gas: 0, km: 0
    car.in();
    car.in();
    System.out.println(car);
    //pass: 2, gas: 0, km: 0
    car.in();
    //fail: limite de pessoas atingido
    System.out.println(car);
    //pass: 2, gas: 0, km: 0
    car.out();
    car.out();
    car.out();
    //fail: nao ha ninguem no carro
    System.out.println(car);
    //pass: 0, gas: 0, km: 0
    car = new Car(0,2,0,100,0);
    car.fuel(60);
    System.out.println(car);
    //pass: 0, gas: 60, km: 0
    
    car.drive(10);
    //fail: nao ha ninguem no carro
    
    car.in();
    car.drive(10);
    System.out.println(car);
    //pass: 1, gas: 50, km: 10
    
    car.drive(70);
    //fail: tanque vazio apos andar 50 km
    car.drive(10);
    //fail: tanque vazio
    System.out.println(car);
    //pass: 1, gas: 0, km: 60
    
    car.fuel(200);
    System.out.println(car);
    //pass: 1, gas: 100, km: 60
    



   } 
}