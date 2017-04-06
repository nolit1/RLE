package RLE;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Algorithm {
    public static String encode(String source) {
        // try (FileReader reader = new FileReader("C:\\\\Users\\kj280\\Desktop\\kod.txt")) {
        StringBuilder buff = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            int partLength = 1;
            while (i + 1 < source.length()
                    && source.charAt(i) == source.charAt(i + 1)) {
                partLength++;
                i++;
            }
            buff.append(partLength);
            buff.append(source.charAt(i));
        }
        return buff.toString();
    }
    //return buff.toString();
    // } catch (IOException ex)
    //   System.out.println(ex.getMessage());
    //}
    //}

    public static String decode(String source) {
        StringBuilder buff = new StringBuilder();
        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            matcher.find();
            while (number-- != 0) {
                buff.append(matcher.group());
            }
        }
        return buff.toString();
    }


    public static void main(String[] args) {

        String a = "aaaaabbbbbcccgggkkkccr";
        System.out.println(encode(a));
        System.out.println(decode(encode(a)));
    }
}
