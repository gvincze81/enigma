package com.codecool.enigma;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Enigma {

    private final static String MENU = "Enigma Manual\n" +
            "Run options: [-h | -e | -d] {CipherName} {FileName} {EncryptionKey}\n" +
            "   -h : displays this menu; other arguments are ignored.\n" +
            "   -e : encrypt and display\n" +
            "   -d : decrypt and display\n" +
            "   CipherName      : cipher to use when encrypting/decrypting; [rot13, rail-fence, morse]\n" +
            "   FileName        : path to file to encrypt/decrypt\n" +
            "   EncryptionKey   : Optional -> must be provided if cipher requires a key";

    public static void main(String[] args) {
        ArgsParser argsParser = new ArgsParser(args);
        handleCipherOperation(argsParser);
    }

    private static void handleCipherOperation(ArgsParser argsParser) {
        try {
            Cipher cipher = CipherFactory.getCipherForArgs(argsParser);
            // use cipher

            if(cipher == null)
                throw new EnigmaException("error");
            String encodedMessage = cipher.encrypt(readFile(argsParser.getFile()));
            System.out.println(encodedMessage);

        } catch(EnigmaException e){
            System.out.println();
        }
    }

    public static String getMENU(){
        return MENU;
    }

    public static String readFile(String filePath){
        String data = "";
        try {
            File source = new File(filePath);
            Scanner reader = new Scanner(source);

            while(reader.hasNextLine()){
                data = reader.nextLine();
            }
            return data;

        }catch(IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
        return "";
    }

}
