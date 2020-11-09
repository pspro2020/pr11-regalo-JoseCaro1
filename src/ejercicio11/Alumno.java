package ejercicio11;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Alumno implements  Runnable{

    private final Comprador comprador;
    private Random random= new Random();

Alumno(Comprador comprador){
    this.comprador=comprador;
}
    private int earnMoney() throws InterruptedException {
    int money=random.nextInt(5)+2;

        TimeUnit.SECONDS.sleep(random.nextInt(10)+3);


        return money;
    }

    @Override
    public void run() {
        int money;
        try {
            money=earnMoney();
        } catch (InterruptedException e) {
            System.out.println("I've been interrupted while going to the meeting\n");
            return;
        }
        comprador.join(money);

    }
}
