package com.codecool.enigma;

class Rot13 implements Cipher {

    @Override
    public String encrypt(String message) {
        char[] letters = message.toCharArray();
        char[] encryptedLetters = new char[letters.length];

        int index = 0;
        for(char ch: letters){
            encryptedLetters[index] = encryptLetter(ch);
            index++;
        }

        return new String(encryptedLetters);
    }

    @Override
    public String decrypt(String message) {
        return null;
    }

    private char encryptLetter(char letter) {
        String alphabet = Enigma.readFile("/home/tb_fan/projects/enigma/abc.txt");
        int index = alphabet.indexOf(letter);
        int newIndex = (index + 13) % 52;
        char[] characters = alphabet.toCharArray();
        return characters[newIndex];
    }

    private char decryptLetter(char letter) {
        return letter;
    }

}
