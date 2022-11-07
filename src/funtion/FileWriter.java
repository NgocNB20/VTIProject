package funtion;

import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class FileWriter implements Runnable{

    Executor executor;

    public FileWriter(Executor executor) {
        this.executor = executor;
    }

    public FileWriter() {
    }

    @Override
    public void run() {

        synchronized (this) {
            try {
                executor.write();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }






    public static void main(String[] args) throws InterruptedException {

/*        FileWriter fileWriter = new FileWriter();
        FileReader fileReader = new FileReader();
        Thread writer = new Thread(fileWriter,"writer");
        Thread reader = new Thread(fileReader,"reader");
        Thread thread = new Thread(){
            @Override
            public void run() {

                for (int i=1;i<=5;i++){
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i==5){
                        System.out.println("đủ 30 giây tạm dừng ghi file");
                        System.out.println("tạm dừng việc ghi file");
                        try {
                            writer.wait();
                            writer.notifyAll();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }*/
/*

            }
        };
        writer.start();
        thread.start();
        reader.wait();
*/

    }
}

/*
*
*
* */
