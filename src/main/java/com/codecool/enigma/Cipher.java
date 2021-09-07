package com.codecool.enigma;

public interface Cipher {

    String encrypt(String message, int key);

    String decrypt(String message, int key);
}
