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
    public String decrypt(String message, int key) {
        char[] letters = message.toCharArray();

        char[] decoded= new char[message.length()];

        int row = 0;
        int col = 0;
        int index = 0;
        for(int i = 0; i < key; i++){
            for(int j = i; j < decoded.length; j += (key - 1) * 2){
                decoded[j] = letters[index];
                index++;
                if(i > 0 && i < key - 1 && j + (key - 1 - i) * 2 < letters.length){
                    decoded[j + (key - 1 - i) * 2] = letters[index];
                    index++;
                }
                if(index >= letters.length)
                    break;
            }
        }

        return new String(decoded);
    }
}
