package com.example.myapplication;

import com.example.myapplication.Affix;

public class Word {
    String word;
    String translation;
    Affix[][] combinations;
    String[] definitions;

    public String getWord() {
        return word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String[] getDefinitions() {
        return definitions;
    }

    public void setDefinitions(String[] definitions) {
        this.definitions = definitions;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranlation() {
        return translation;
    }

    public void setTranlation(String tranlation) {
        this.translation = tranlation;
    }

    public Affix[][] getCombinations() {
        return combinations;
    }

    public void setCombinations(Affix[][] combinations) {
        this.combinations = combinations;
    }

}
