import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<String> names = Arrays.asList(new String[]{"foo", "bar", "fabrikam", "cornwell"});

        ExecutorService executor = Executors.newFixedThreadPool(names.size() + 1);
        List<RandomPrintRunnableTask> taskList = new ArrayList<>();

        for(String name : names){
            Future task = executor.submit(new RandomPrinterRunnable(name));
            taskList.add(new RandomPrintRunnableTask(name, task));
        }

        executor.submit(new MonitorThread(taskList, executor));

        while(true){
            try {
                Thread.sleep(5*1000);
                System.out.println("Main thread just slept for 5 seconds");
            } catch (InterruptedException e) {
               System.out.println("some issue with sleeping in main thread");
            }
        }
    }
}