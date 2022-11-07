package test;

import java.io.*;

public class TestCountLine {
    public static void main(String[] args) throws IOException {
/*        BufferedReader reader = new BufferedReader(new FileReader("names.txt"));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        System.out.println(lines);*/
/*        FileReader reader = new FileReader(new File("names.txt"));
        LineNumberReader lineNumberReader = new LineNumberReader(reader);*/

/*        String str = "";
        while ((str = lineNumberReader.readLine()) != null) {
            System.out.println(str);
        }
        System.out.println(System.getProperty("user.dir") + "\\src\\io\\" + new File("names.txt"));*/

        FileRead fileReader = new FileRead();
        FileRead fileReader2 = new FileRead();
        Thread t1 = new Thread(fileReader, "thread1");
        Thread t2 = new Thread(fileReader2,"thead2");
        t1.start();
        t2.start();

    }
}

class FileRead implements Runnable {
    FileReader reader = null;
    LineNumberReader lineNumberReader = null;
    String path = System.getProperty("user.dir") + "\\src\\io\\" + new File("names.txt");

    public FileRead() throws FileNotFoundException {
        reader = new FileReader(path);
        lineNumberReader = new LineNumberReader(reader);

    }

     void Read(String name ) throws IOException {
        String str = "";
        while ((str = lineNumberReader.readLine()) != null) {
            System.out.println(str+name);
        }
    }


    @Override
    public void run() {
        try {
            /*System.out.println(Thread.currentThread().getName());*/
            Read(Thread.currentThread().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
