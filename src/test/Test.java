package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Test {
    private static AtomicInteger count = new AtomicInteger();
    static AtomicReference<List<File>> files = new AtomicReference<>();
    public static void main(String[] args) throws Exception {
/*        List<File> a = new ArrayList<>();
        a.add(new File("t1.txt"));
        a.add(new File("t2.txt"));
        System.out.println(a.size());
        files.set(a);
        files.set(null);

        files.get().forEach(c->{
            System.out.println(c.getName());
        });*/

        Calendar date = Calendar.getInstance();
        System.out.println("Current Date and TIme : " + date.getTime());










    }


}