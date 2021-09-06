package com.codecool.enigma;

import java.util.HashMap;
import java.util.Map;

class MorseCode implements Cipher {

    public Map<Character, String> toMorse(){
        Map<Character, String> morse = new HashMap<>();
        morse.put('a', ".-");
        morse.put('b', "-...");
        morse.put('c',  "-.-.");
        morse.put('d',  "-..");
        morse.put('e',    ".");
        morse.put('f', "..-.");
        morse.put('g',  "--.");
        morse.put('h', "....");
        morse.put('i',   "..");
        morse.put('j', ".---");
        morse.put('k',   "-.");
        morse.put('l', ".-..");
        morse.put('m',   "--");
        morse.put('n',   "-.");
        morse.put('o',  "---");
        morse.put('p', ".--.");
        morse.put('q', "--.-");
        morse.put('r', ".-.");
        morse.put('s',  "...");
        morse.put('t',   "-");
        morse.put('u',  "..-");
        morse.put('v', "...-");
        morse.put('w',  ".--");
        morse.put('x', "-..-");
        morse.put('y', "-.--");
        morse.put('z', "--..");
        morse.put('1', ".----");
        morse.put('2',"..---");
        morse.put('3', "...--");
        morse.put('4', "....-");
        morse.put('5', ".....");
        morse.put('6', "-....");
        morse.put('7', "--...");
        morse.put('8', "---..");
        morse.put('9', "----.");
        morse.put('0', "-----");

        return morse;
    }

    @Override
    public String encrypt(String message) {
        message = message.toLowerCase();
        Map<Character, String> englishToMorse = toMorse();
        message = message.replaceAll(" +", "/");
        char[] letters = message.toCharArray();

        String encoded = "";
        for(char ch: letters){
            if(Character.isLetterOrDigit(ch)){
                encoded = encoded.concat(englishToMorse.get(ch)) + " ";
            }else if(ch == '/') {
                encoded = encoded.concat("/ ");
            }

        }
        return encoded;
    }

    @Override
    public String decrypt(String message) {
        String[] symbols = message.split(" +");
        Map<Character, String> englishToMorse = toMorse();
        Map<String, Character> morseToEnglish = new HashMap<>();

        for(Map.Entry<Character, String> entry : englishToMorse.entrySet()){
            morseToEnglish.put(entry.getValue(), entry.getKey());
        }

        String decoded = "";
        for(String sign: symbols){
            if(!sign.equals("/")){
                decoded = decoded.concat(String.valueOf(morseToEnglish.get(sign)));
            }else {
                decoded = decoded.concat(" ");
            }
        }
        return decoded;
    }
}
