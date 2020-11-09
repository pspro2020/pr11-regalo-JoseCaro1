package ejercicio11;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;

public class Comprador implements Runnable {

    private final CountDownLatch countDownLatch;
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");


    public Comprador(int quorom) {
        countDownLatch = new CountDownLatch(quorom);
    }

    @Override
    public void run() {
        System.out.printf("%s -> Waiting for money to buy the present\n",
                LocalTime.now().format(format));
        try {
            countDownLatch.await();
            System.out.printf("%s -> Tenemos el dinero el hermano mayor ira a comprar el regalo\n",
                    LocalTime.now().format(format));
        } catch (InterruptedException e) {
            System.out.println("Meeting has been interrupted while waiting to have quorum\n");
        }
    }

    protected void join(int money) {
        System.out.printf("%s - El %s ha dado %d euros\n", LocalTime.now().format(format), Thread.currentThread().getName(), money);
        for (int i = 0; i < money; i++) {
            countDownLatch.countDown();
        }
    }


}
