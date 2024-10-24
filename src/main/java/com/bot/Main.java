package com.bot;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //do nothing
    }

    public static List<String> getList(List<String> list, int max) {

        List<String> result = new ArrayList<>();
        List<String> subResult = new ArrayList<>();
        int count = 0;
        boolean isLast = false;

        for(int i = 0; i < list.size(); i++){

            System.out.println("now reading: " + list.get(i));

            count = count + list.get(i).length();

            if(i == list.size() - 1){
                //isLast
                System.out.println("is last word");
                isLast = true;
            }
            else{
                if(count >= max){
                    //do nothing
                }
                else{
                    count++;
                }
            }

            System.out.println("result total characters: " + count);

            try {

                if (count > max) {

                    System.out.println("breaking max " + max);

                    System.out.println("now building the line: " + subResult);
                    String line = buildLine(subResult, max, isLast);
                    System.out.println("line built: " + line);
                    result.add(line);
                    subResult = new ArrayList<>();
                    count = 0;
                }

                subResult.add(list.get(i));

            }finally {

                if(isLast){
                    System.out.println("now building the line: " + subResult);
                    String line = buildLine(subResult, max, isLast);
                    System.out.println("line built: " + line);
                    result.add(line);
                    subResult = new ArrayList<>();
                    count = 0;
                }

            }

        }

        return result;

    }

    private static String buildLine(List<String> words, int max, boolean isLastLine){
        int wordSize = words.stream().mapToInt(String::length).sum();

        System.out.println("characters in line: " + wordSize);

        if(isLastLine){
            //last line
            System.out.println("is last line");
            StringBuilder lastLine = new StringBuilder(String.join("_", words));
            int missing = max - lastLine.length();
            if(missing == 0){
                return lastLine.toString();
            }

            for(int i = 0; i < missing; i++){
                lastLine.append("_");
            }

            String result = lastLine.toString();
            System.out.println("result: " + result);
            return result;
        }

        if(wordSize + words.size() - 1 == max){
            //exact match
            System.out.println("exact match");
            String result = String.join("_", words);

            System.out.println("result: " + result);
            return result;
        }

        //split spaces
        int missing = max - wordSize;

        System.out.println("Spaces missing " + missing);

        if(missing % words.size() - 1 == 0){
            //exact division
            System.out.println("exact division means spaces are perfectly even between words");
            int spaces = missing / (words.size() - 1);

            System.out.println("now having #" + spaces + " between words");

            String result = String.join("_".repeat(Math.max(0, spaces)), words);

            System.out.println("result: " + result);
            return result;

        }

        System.out.println("division between " + missing);

        int spaces = (missing - 1) / words.size();

        String result = String.join("_".repeat(Math.max(0, spaces)), words);

        result = result + "_";

        System.out.println("result: " + result);
        return result;

    }

}
