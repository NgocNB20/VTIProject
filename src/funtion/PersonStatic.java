package funtion;

import entity.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import static constant.Constant.*;

public class PersonStatic {
    public volatile int count = 0;


    /* This gives you a random number in between startValue (inclusive) and 100 (endValue) */
    public static int random(int startValue, int endValue) {
        Random random = new Random();
        return random.nextInt(endValue - startValue) + startValue;
    }


    /*" nguyễN bÁ nGọc "  =>  "Nguyễn Bá Ngọc"*/
    public static String convertFormatName(String fullName) {
        char[] chArr;
        String[] arrStr = fullName.split(" ");
        StringBuilder name = new StringBuilder();

        for (String str : arrStr) {
            chArr = str.toCharArray();
            chArr[0] = Character.toUpperCase(chArr[0]);
            for (int i = 1; i < str.length(); i++) {
                chArr[i] = Character.toLowerCase(chArr[i]);
            }
            name.append(new String(chArr)).append(" ");
        }
        return name.toString();
    }


    public static String generateDateOfBirth() {

        StringBuilder dateOfBirth = new StringBuilder();
        int month = random(1, 12);
        int day = month == 2 ? random(1, 30) : random(1, 32);
        int year = random(1980, 2023);

        if (day >= 1 && day <= 9) {
            dateOfBirth.append(0)
                    .append(day)
                    .append("-");
        } else {
            dateOfBirth.append(day)
                    .append("-");
        }

        if (month >= 1 && month <= 9) {
            dateOfBirth.append(0)
                    .append(month)
                    .append("-");
        } else {
            dateOfBirth.append(month)
                    .append("-");
        }
        dateOfBirth.append(year);


        return dateOfBirth.toString();
    }

    /* random 7 character last in phone number*/
    static StringBuilder randomPhone(String[] phones, StringBuilder phone) {
        phone.append(phones[random(0, phones.length)]);
        for (int i = 0; i < 7; i++) {
            phone.append(random(0, 10));
        }
        return phone;
    }

    /*1:Viettel   2: Vina    3:Mobie */
    public static StringBuilder generatePhone() {
        int indexType = random(1, 4);
        StringBuilder phone = new StringBuilder();

        if (indexType == 1) {
            return randomPhone(PHONE_VIETTEL, phone);
        } else if (indexType == 2) {
            return randomPhone(PHONE_VINAPHONE, phone);
        } else {
            return randomPhone(PHONE_MOBIEPHONE, phone);
        }
    }

    /* check type phone number*/
    public static boolean isTypePhone(String[] phones, String phone) {

        for (String str : phones) {
            if (phone.substring(0, 3).trim().equals(str.trim())) {
                return true;
            }
        }
        return false;

    }

    public static Person convertToPerson(String lineFile) {

        Person person = new Person();
        String arr = lineFile.replace("|", " 0-0 ");
        String[] datas = arr.split("0-0");

        person.setPhone(datas[1].trim());
        person.setName(datas[2].trim());
        person.setDateOfBirth(datas[3].trim());
        person.setPlace(datas[4].trim());

        return person;

    }

    public static void randomPerson() {
        int count = 1;
        StringBuilder name;
        StringBuilder infor;

        try (FileWriter f = new FileWriter("names.txt", true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b)) {

            while (count<100) {



                infor = new StringBuilder("");
                infor.append(count).append(" | ");
                infor.append(generatePhone());
                infor.append(" | ");

                name = new StringBuilder("");
                name.append(FIRST_NAME[random(0, FIRST_NAME.length)]).append(" ");
                name.append(MIDDLE_NAME[random(0,MIDDLE_NAME.length)]).append(" ");
                name.append(LAST_NAME[random(0, LAST_NAME.length)]);

                infor.append(convertFormatName(name.toString())).append(" | ");
                infor.append(generateDateOfBirth()).append(" | ");
                infor.append(PLACE[random(0, PLACE.length)]);

                System.out.println(infor);
                p.println(infor);
                count++;
            }

        } catch (IOException i) {
            i.printStackTrace();
        }



    }

    public static synchronized void writeFile() {
          //ghi file trong 30s  sau
         //

    }

    public static synchronized void readFile() throws InterruptedException {

        Thread.sleep(30000);
    }




    public static void main(String[] args) {

        randomPerson();



/*        char[] chArr = "nguyễn bá ngọc".toCharArray();
        chArr[0] = Character.toUpperCase(chArr[0]);
        System.out.println(chArr);*/


        /* System.out.println(convertFormatName("nguyễN bÁ nGọc"));*/

 /*       System.out.println(generateDateOfBirth());

        System.out.println(PLACE[random(0, PLACE.length)]);

        StringBuilder name = new StringBuilder("");
        name.append(FIRST_NAME[random(0, FIRST_NAME.length)])
                .append(" ")
                .append(MIDDLE_NAME[random(0,MIDDLE_NAME.length)]).append(" ")
                .append(LAST_NAME[random(0, LAST_NAME.length)]);
        System.out.println(convertFormatName(name.toString()));      */

/*        for (int i=0;i<100;i++){
            System.out.println(randomPhone());
        }
        String s1 ="0963653789";//viettel
        String s2 = "0888150376";//vina
        String s3 ="0792950049";//mobie
        System.out.println(isType(PHONE_VIETTEL,s1));
        System.out.println(isType(PHONE_VINAPHONE,s2));
        System.out.println(isType(PHONE_MOBIEPHONE,s3));*/


/*        for (int i=0;i<1000; i++) {
            StringBuilder infor = new StringBuilder("");
            infor.append(i).append(" | ");
            infor.append(randomPhone()).append(" | ");
            StringBuilder name = new StringBuilder("");
            name.append(FIRST_NAME[random(0, FIRST_NAME.length)])
                    .append(" ")
                    .append(MIDDLE_NAME[random(0,MIDDLE_NAME.length)]).append(" ")
                    .append(LAST_NAME[random(0, LAST_NAME.length)]);
            infor.append(convertFormatName(name.toString())).append(" | ");
            infor.append(generateDateOfBirth()).append(" | ");
            infor.append(PLACE[random(0, PLACE.length)]);

            System.out.println(infor);
        }*/


/*        String arr = "962 | 0861174734 | Hồ Hồng Vinh | 24-03-2014 | Đồng Tháp";
        System.out.println(convertToPerson(arr).toString());

        String[] datas = arr.split("0-0");
        Arrays.asList(datas).forEach(c -> {
            System.out.println(c.trim());
        });*/




    }



}
