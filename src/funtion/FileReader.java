package funtion;

public class FileReader implements Runnable{

    Executor executor;

    public FileReader(Executor executor) {
        this.executor = executor;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                executor.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
