import java.util.List;
import java.util.concurrent.ExecutorService;

public class MonitorThread implements Runnable{

    List<RandomPrintRunnableTask> taskList;
    ExecutorService executor;

    public MonitorThread(List<RandomPrintRunnableTask> taskList,ExecutorService executor){
        this.taskList = taskList;
        this.executor = executor;
    }

    @Override
    public void run() {
        while (true){
            try{
                Thread.sleep(2*1000);
                for(RandomPrintRunnableTask printTask: taskList){
                    if(printTask.task.isDone()){
                        System.out.println(printTask.thread_name + " thread  is DEAD");
                        printTask.task = executor.submit(new RandomPrinterRunnable(printTask.thread_name));
                    }else{
                        System.out.println(printTask.thread_name + " thread  is RUNNING");
                    }
                }
            }catch (Exception ex){
                System.out.println("got an exception in monitor thread " + ex.toString());
            }
        }
    }
}
