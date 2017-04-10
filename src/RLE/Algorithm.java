package RLE;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Algorithm {

    public static String encode(String source) {
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

    public static void encodeToFile() throws IOException {
        FileWriter writer = new FileWriter("encodeResult.txt");
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\kj280\\Desktop\\kot.txt"), StandardCharsets.UTF_8);
        for(String line: lines){
            writer.write(encode(line));
        }
        writer.close();
    }

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

    public static void decodeToFile() throws IOException {
        FileWriter writer = new FileWriter("decodeResult.txt");
        List<String> lines = Files.readAllLines(Paths.get("encodeResult.txt"), StandardCharsets.UTF_8);
        for(String line: lines){
            writer.write(decode(line));
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException{
        encodeToFile();
        decodeToFile();
    }
}
