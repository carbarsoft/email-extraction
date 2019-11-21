package com.company;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main (String[] args) throws IOException {
        Path textLocation = Path.of("binary.txt");
        String searchText = Files.readString(textLocation);
        int emailCounter = 0;
        for (int i = 0; i < searchText.length()-12; i++) {
            if ((searchText.substring(i, i + 13).equals("@softwire.com"))){
                emailCounter++;
            }
        }
        System.out.println(emailCounter);

        int regexCounter = 0;
        Pattern softwireRegex = Pattern.compile("(@softwire\\.com)\\W|(@softwire\\.com)$");
        Matcher softwireMatcher = softwireRegex.matcher(searchText);
        while (softwireMatcher.find()) {
            regexCounter++;
        }
        System.out.println(regexCounter);

        HashMap<String,Integer> domainCount = new HashMap<String,Integer>();
        Pattern domainRegex = Pattern.compile("(?<=\\s)[\\w.'_%+-]*@([\\w'_%+-]*(\\.[\\w'_%+-]*)*)(?=\\s)");
        Matcher domainMatcher = domainRegex.matcher(searchText);
        while (domainMatcher.find()) {
            if (domainCount.containsKey(domainMatcher.group(1))) {
                var prevCount = domainCount.get(domainMatcher.group(1));
                domainCount.put(domainMatcher.group(1),prevCount+1);
            }
            else
            {
                domainCount.put(domainMatcher.group(1),1);
            }
        }
        System.out.println(domainCount);

        var highScores = domainCount.values().toArray();
        public string nMostPopular (tally, n) {
            for (i=0, i< n, i++) {
                tally.entrySet().stream().max(Integer::compare).get();
                tally.remove()
            }
        }




    }
}
