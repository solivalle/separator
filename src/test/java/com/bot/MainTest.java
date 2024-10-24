package com.bot;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @Test
    public void happyPath(){
        List<String> words = new ArrayList<>();
        words.add("this");
        words.add("is");
        words.add("a");
        words.add("test");

        int max = 10;

        List<String> result = Main.getList(words, max);

        System.out.println("------------------");
        System.out.println("Final Result");
        result.forEach(System.out::println);
    }

    @Test
    public void ThreeWordsSingleLinePerfect(){
        List<String> words = new ArrayList<>();
        words.add("this");
        words.add("is");
        words.add("something");

        int max = 17;

        List<String> result = Main.getList(words, max);

        System.out.println("------------------");
        System.out.println("Final Result");
        result.forEach(System.out::println);
        Assert.assertEquals(result.getFirst().length(), max);
    }

    @Test
    public void ThreeWordsDoubleLinePerfect(){
        List<String> words = new ArrayList<>();
        words.add("this");
        words.add("is");
        words.add("something");
        words.add("this");
        words.add("is");
        words.add("something");

        int max = 17;

        List<String> result = Main.getList(words, max);

        System.out.println("------------------");
        System.out.println("Final Result");
        result.forEach(System.out::println);
        Assert.assertEquals(result.getFirst().length(), max);
        Assert.assertEquals(result.get(1).length(), max);
    }

    @Test
    public void ThreeWordsSingleLine1ExtraSpaceAtTheEnd(){
        List<String> words = new ArrayList<>();
        words.add("this");
        words.add("is");
        words.add("something");

        int max = 18;

        List<String> result = Main.getList(words, max);

        System.out.println("------------------");
        System.out.println("Final Result");
        result.forEach(System.out::println);
        Assert.assertEquals(result.getFirst().length(), max);
    }

    @Test
    public void ThreeWordsSingleLine2SeparationAtTheEnd(){
        List<String> words = new ArrayList<>();
        words.add("this");
        words.add("is");
        words.add("something");

        int max = 19;

        List<String> result = Main.getList(words, max);

        System.out.println("------------------");
        System.out.println("Final Result");
        result.forEach(System.out::println);
        Assert.assertEquals(result.getFirst().length(), max);
    }

    @Test
    public void ThreeWords2Lines2SeparationAtTheEnd(){
        List<String> words = new ArrayList<>();
        words.add("this");
        words.add("is");
        words.add("something");
        words.add("this");
        words.add("is");
        words.add("something");

        int max = 19;

        List<String> result = Main.getList(words, max);

        System.out.println("------------------");
        System.out.println("Final Result");
        result.forEach(System.out::println);
        Assert.assertEquals(result.getFirst().length(), max);
        Assert.assertEquals(result.get(1).length(), max);
    }


}
