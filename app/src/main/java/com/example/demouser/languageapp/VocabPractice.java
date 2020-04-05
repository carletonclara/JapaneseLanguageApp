package com.example.demouser.languageapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class VocabPractice extends AppCompatActivity implements DialogInterface.OnClickListener{

    //private Checker check = new Checker();
    private String main;
    private ArrayList<String> opts;
    private ArrayList<String> vocab;
    private ArrayList<String> translate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_practice);
        //main = check.chooseWord();
        //opts = check.chooseOptions();
        //vocab = check.getVocabList();
        //translate = check.getTranslationList();
        onStart(null);
    }

    public boolean onStart(View view){
        Checker check = new Checker();
        main = check.chooseWord();
        opts = check.chooseOptions();
        vocab = check.getVocabList();
        translate = check.getTranslationList();

        TextView text = (TextView) findViewById(R.id.exWord);
        text.setText(main);
        Button choice1 = (Button) findViewById(R.id.choice1);
        Button choice2 = (Button) findViewById(R.id.choice2);
        Button choice3 = (Button) findViewById(R.id.choice3);
        choice1.setText(opts.get(0));
        choice2.setText(opts.get(1));
        choice3.setText(opts.get(2));
        return true;
    }

    private void restart(String message){
        AlertDialog.Builder dlg = new AlertDialog.Builder(this)
                .setTitle("がんばったね！")
                .setMessage(message)
                .setCancelable(true);
                //.setPositiveButton("New word?", this);
        dlg.show();
    }

    public void onClick(DialogInterface dialogInterface, int i) {onStart(null);}

    public boolean onChoice1(View view){
        String choice = ((TextView) findViewById(R.id.choice1)).getText().toString();
        int a = translate.indexOf(choice);
        int b = vocab.indexOf(main);
        if(a==b){
            restart("That's correct!");
           return true;
        }
        restart("That's incorrect!");
        return false;
    }
    public boolean onChoice2(View view){
        String choice = ((TextView) findViewById(R.id.choice2)).getText().toString();
        int a = translate.indexOf(choice);
        int b = vocab.indexOf(main);
        if(a==b){
            restart("That's correct!");
            return true;
        }
        restart("That's incorrect!");
        return false;
    }
    public boolean onChoice3(View view){
        String choice = ((TextView) findViewById(R.id.choice3)).getText().toString();
        int a = translate.indexOf(choice);
        int b = vocab.indexOf(main);
        if(a==b){
            restart("That's correct!");
            return true;
        }
        restart("That's incorrect!");
        return false;
    }


}
