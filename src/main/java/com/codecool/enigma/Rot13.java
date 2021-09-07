package com.codecool.enigma;

class Rot13 implements Cipher {

    @Override
    public String encrypt(String message, int key) {
        char[] letters = message.toCharArray();
        char[] encryptedLetters = new char[letters.length];

        int index = 0;
        for(char ch: letters){
            if(Character.isAlphabetic(ch)){
                encryptedLetters[index] = encryptLetter(ch);
            }else {
                encryptedLetters[index] = ch;
            }
            index++;
        }

        return new String(encryptedLetters);
    }

    @Override
    public String decrypt(String message, int key) {
        char[] letters = message.toCharArray();
        char[] decryptedLetters = new char[letters.length];

        int index = 0;
        for(char ch: letters){
            if(Character.isAlphabetic(ch)){
                decryptedLetters[index] = decryptLetter(ch);
            }else {
                decryptedLetters[index] = ch;
            }
            index++;
        }

        return new String(decryptedLetters);
    }

    private char encryptLetter(char letter) {
        String alphabet = Enigma.readFile("/home/tb_fan/projects/enigma/abc.txt");
        int index = alphabet.indexOf(letter);
        int newIndex = (index + 13) % 52;
        char[] characters = alphabet.toCharArray();
        return characters[newIndex];
    }

    private char decryptLetter(char letter) {
        String alphabet = Enigma.readFile("/home/tb_fan/projects/enigma/abc.txt");
        int index = alphabet.indexOf(letter);
        int newIndex = (index + 39) % 52;
        char[] characters = alphabet.toCharArray();
        return characters[newIndex];
    }

}
