package Main;

//import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sk.itsovy.data.DataIP;
import sk.itsovy.data.Date;
import sk.itsovy.data.MacAddress;
import sk.itsovy.data.PersonalID;
//import sk.itsovy.

public class Main {
    private static final String ipadresPattern = "((2[0-5][0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.){3}(2[0-5][0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])[$0-9]";
    private static final String slovakIdPattern = "^[0-9]{2}[0156][0-9]{3}\\/?[0-9]{3,4}$";
    private static final String datePattern="^((([1-9]|([1-2][0-9]|31|30))\\.(1|3|5|7|9|11))|(([1-9]|([1-2][0-9]))\\.(2|4|6|8|10|12)))\\.((19|20)([0-9]{2}))$";
    private static final String macAdressPattern="^([0-9A-Fa-z]{2}[:-]){5}([0-9A-Fa-z]{2})$";

    public static void main(String[] args) {
        DataIP dataIP = new DataIP();
        PersonalID personalID = new PersonalID();
        MacAddress macAddress=new MacAddress();
        Date date = new Date();

        System.out.println(dataIP.get());

        //findMatches(dataIP.get(),ipadresPattern);// works
        //findMatches(personalID.get(),slovakIdPattern);
        //findMatches(date.get(),datePattern);
        //findMatches(macAddress.get(),macAdressPattern);

        findMatchesInList((ArrayList<String>) dataIP.get(),ipadresPattern);// works
        findMatchesInList((ArrayList<String>) personalID.get(),slovakIdPattern);//works
        findMatchesInList((ArrayList<String>) date.get(),datePattern);// works
        findMatchesInList((ArrayList<String>) macAddress.get(),macAdressPattern);// works

    }

    public static void findMatches(List list, String stringPattern) {
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
        System.out.println("Number of matches:"+count);
    }
    public static void findMatchesInList(ArrayList<String> list, String pattern){
        Pattern pattern1=Pattern.compile(pattern);
        int count=0;
        for (int i=0; list.size()>i;i++) {

            if (list.get(i) != null) {
                Matcher matcher = pattern1.matcher(list.get(i));
                while (matcher.find()) {
                    System.out.println(matcher.group());
                    count++;
                }
            }
        }
        System.out.println("Matches: "+count);
        System.out.println();
    }
}
