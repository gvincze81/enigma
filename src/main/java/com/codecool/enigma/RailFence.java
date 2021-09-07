package com.codecool.enigma;

import java.util.ArrayList;
import java.util.List;

class RailFence implements Cipher {

    @Override
    public String encrypt(String message, int key) {
        message = message.replaceAll(" +", "");
        char[] letters = message.toCharArray();

        String encoded = "";
        List<List<Character>> levels = new ArrayList<>(key);

        for(int i = 0; i < key; i++){
            levels.add(new ArrayList<>());
        }

        int index = 0;
        boolean operation = true;
        for(char ch: letters){
            levels.get(index).add(ch);
            if(index >= key - 1 || index == 0 && !operation)
                operation = !operation;
            if(operation)
                index++;
            else index--;
        }
        for(List<Character> level: levels){
            for(char ch: level){
                encoded = encoded.concat(String.valueOf(ch));
            }
        }
        return encoded;
    }

    @Override
    public String decrypt(String message) {
        return null;
    }
}
