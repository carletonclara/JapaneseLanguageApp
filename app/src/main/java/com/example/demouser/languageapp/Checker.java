package com.example.demouser.languageapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Checker {

    private ArrayList<String> vocabList = new ArrayList();
    private ArrayList<String> translationList = new ArrayList();
    private ArrayList<String> options = new ArrayList();
    private ArrayList<Integer> previously = new ArrayList();
    private String word = "";
    private String choice = "";
    private int choiceIndex;

    //gets the list of vocab words
    public Checker()  {
        getVocabList();
        getTranslationList();
    }


    public ArrayList<String> getVocabList(){
        vocabList.add("hello");
        vocabList.add("I'm sorry");
        vocabList.add("Japan");
        vocabList.add("delicious");
        vocabList.add("to eat");
        vocabList.add("excuse me");
        vocabList.add("cute");
        vocabList.add("friend");
        vocabList.add("money");
        vocabList.add("see you");
        vocabList.add("amazing");
        vocabList.add("America");
        vocabList.add("cake");
        vocabList.add("university");
        vocabList.add("student");
        vocabList.add("to speak");
        vocabList.add("cat");
        vocabList.add("dog");
        vocabList.add("to do");
        vocabList.add("to study");

        return vocabList;
    }

    public ArrayList<String> getTranslationList() {
        translationList.add("こんにちわ");
        translationList.add("ごめんなさい");
        translationList.add("日本");
        translationList.add("おいしい");
        translationList.add("食べる");
        translationList.add("すみません");
        translationList.add("かわいい");
        translationList.add("友だち");
        translationList.add("お金");
        translationList.add("じゃあまた");
        translationList.add("すごい");
        translationList.add("アメリカ");
        translationList.add("ケーキ");
        translationList.add("大学");
        translationList.add("学生");
        translationList.add("話す");
        translationList.add("ネコ");
        translationList.add("犬");
        translationList.add("する");
        translationList.add("勉強する");

        return translationList;
    }

    //choose the main word
    public String chooseWord(){
        Random r = new Random();
        int rand = r.nextInt(vocabList.size());
        word = vocabList.get(rand);
        //options.add(translationList.get(rand));
        return word;
    }

    public int getChoiceIndex(){
        choiceIndex = vocabList.indexOf(word);
        return choiceIndex;
    }

    public ArrayList<Integer> previousChoices(){
        return previously;
    }

    //choose the options for user to choose from
    public ArrayList<String> chooseOptions(){
        int cI = getChoiceIndex();
        options.add(translationList.get(cI));
        int otherChoice = 100;
        int i=0;
        while(i<2){
            Random r = new Random();
            int rand = r.nextInt(translationList.size());
            if(rand != cI && rand != otherChoice) {
                String temp = translationList.get(rand);
                options.add(temp);
                otherChoice = rand;
                i++;
            }
        }
        Collections.shuffle(options);
        return options;
    }

    //check choice against
    //public boolean correct(){
    //   if(choice == word){
    //        return true;
    //    }
    //    return false;
    //}

}
