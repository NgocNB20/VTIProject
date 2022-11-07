package funtion;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Executor {
    static AtomicReference<List<File>> files = new AtomicReference<>();

    static AtomicReference<List<Integer>> numberV = new AtomicReference<>();


    public Executor() {
        System.out.println("số lượng file chưa đọc là: ");
    }

    public synchronized void read() throws InterruptedException {

        System.out.println("đang ĐỌC ĐỌC ĐỌC file !!!!!!");
            try {
                while ((numberV.get()==null||numberV.get().size()==0)){
                    System.out.println("Không có file để đọc");
                    wait();
                    System.out.println("end wait");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println("CÓ FILE MỚI");

        while (!(numberV.get().size()==0||numberV.get()==null)) {
            List<Integer> datas = numberV.get();
            System.out.println(datas.get(0));
            datas.remove(0);
            numberV.set(datas);
            if (numberV.get().size()==0){
                break;
            }
        }

        System.out.println("Số Lượng file còn lại sau khi Đọc là "+numberV.get().size());
            //clear file
    }





    public synchronized void write() throws InterruptedException {

        System.out.println("đang GHI GHI GHI file !!!!!!");
        int count =0;
        int number =0;
        LocalDateTime start = LocalDateTime.now().plusSeconds(2);
        while (true) {
            start = LocalDateTime.now().plusSeconds(30);

            while (LocalDateTime.now().until(start, SECONDS)!=0){

                Thread.sleep(1000);
                Random random = new Random();
                count = random.nextInt(100 - 0) + 0;
                if (count>50) {
                    System.out.println("Xuất file vì quá 1000 dòng");
                    break;
                }
            }
            count=0;
            number++;
            Thread.sleep(1000);
            if((numberV.get()==null || numberV.get().size()==0)){
                List<Integer> datas = new ArrayList<>();
                datas.add(number);
                numberV.set(datas);
            } else {
                List<Integer> datas = numberV.get();
                datas.add(number);
                numberV.set(datas);
            }
            System.out.println("số file còn lại sau kho TẠO file mới là :"+numberV.get().size());
            System.out.println("Ghi xong file "+number);


            this.notifyAll();

        }
    }



    public static void main(String[] args) throws InterruptedException {

        Executor executor =new Executor();

        Thread t1 =new Thread(){
            @Override
            public void run() {
                try {
                    executor.read();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                try {
                    executor.write();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        t2.start();













        /*
        Executor executor = new Executor();
        FileReader fileReader = new FileReader(executor);
        FileWriter fileWriter = new FileWriter(executor);
        Thread t1 = new Thread(fileWriter);
        Thread t2 = new Thread(fileReader);

        t2.start();
        t1.start();*/
/*

        int count =0;
        int number =0;
        LocalDateTime start = LocalDateTime.now().plusSeconds(2);

        while (true) {
            count=0;
            start = LocalDateTime.now().plusSeconds(2);
            while (LocalDateTime.now().until(start, SECONDS)!=0){

                Thread.sleep(1000);
                Random random = new Random();
                count = random.nextInt(100 - 0) + 0;
                if (count>50) {
                    System.out.println("done vì count");
                    break;
                }
            }
            count=0;
            number++;
            System.out.println("DONE file "+number);

        } */




/*        LocalTime l1 = LocalTime.parse("02:53:40");
        LocalTime l2 = LocalTime.parse("02:54:27");
        System.out.println(l1.until(l2, SECONDS));
        System.out.println(SECONDS.between(l1, l2));*/


        //check null Atomic  numberV.get()==null
       /* List<Integer> numbers = new ArrayList<>();
        numberV.set(numbers);
        System.out.println(numberV.get().size()==0||numberV.get()==null);
        numbers.add(1); numbers.add(2); numbers.add(3); numbers.add(4); numbers.add(5); numbers.add(6); numbers.add(7);
        numbers.remove(1);*/


      /*  while (!(numberV.get().size()==0||numberV.get()==null)) {

            List<Integer> datas = numberV.get();
            System.out.println(datas.get(0));
              datas.remove(0);
              numberV.set(datas);


            if (numberV.get().size()==0){
                break;
            }
        }
        System.out.println(numberV.toString());
        System.out.println("DONE");*/








        System.out.println("Done");


    }

}
