package Main;

//import java.util.ArrayList;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sk.itsovy.data.DataIP;


public class Main {
    public static void main(String[] args) {
        DataIP dataIP = new DataIP();

        System.out.println(dataIP.get());

        ipAdress(dataIP.get());

    }

    public static void slovakId(List list) {
        String stringPattern = "[0-9]{2}[0156][0-9]{3}\\/?[0-9]{3,4}";

        Pattern pattern = Pattern.compile(stringPattern);
        //  Matcher matcher=new Matcher(list.get);


    }

    public static void ipAdress(List list) {
        String stringPattern = "((2[0-5][0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.){3}(2[0-5][0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])[$0-9]";
        String line = list.toString();

        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(line);

        int count=0;
        if (matcher.find()) {
            do {
                System.out.println("match!");
                System.out.println(matcher.group(0));
                count++;
            }while (matcher.find());
        }else {
            System.out.println("no matches");
        }
        System.out.println(count);

    }
}
