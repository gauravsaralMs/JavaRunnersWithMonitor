import java.util.concurrent.Future;

public class RandomPrintRunnableTask {
    public RandomPrintRunnableTask(String thread_name, Future task){
        this.thread_name = thread_name;
        this.task = task;
    }

    String thread_name;

    Future task;
}
