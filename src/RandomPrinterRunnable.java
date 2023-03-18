import java.io.Console;
import java.time.Instant;
import java.util.Date;

public class RandomPrinterRunnable implements Runnable{
    String threadName;

    public RandomPrinterRunnable(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run(){
        while(true){
            System.out.println("Thread name : "+ threadName +" is running at "+ Instant.now().toString());
            try {

                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                System.out.println("some issue  in sleeping in runnable task");
            }

            int randomNumber = (int)(Math.random()*(50));
            System.out.println("random number is " + randomNumber + " in thread " + threadName );
            if(randomNumber < 5){
                System.out.println("Thread is dying " + threadName + " with number " + randomNumber);
                randomNumber = 5 / (randomNumber - randomNumber);
            }
        }
    }
}
