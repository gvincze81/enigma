package com.codecool.enigma;

import java.io.File;
import java.util.Arrays;
import java.util.List;

class CipherFactory {

    static boolean isCipherAvailable(String cipherName) {
        String[] encryptions = {"rot13", "morse", "rail-fence"};
        List<String> ciphers = Arrays.asList(encryptions);
        return ciphers.contains(cipherName);
    }

    static boolean fileExists(String path){
        File tempFile = new File(path);
        return tempFile.exists();
    }

    static Cipher getCipherForArgs(ArgsParser args) throws EnigmaException {
        try {
            if(args.getOption() == null || args.getOption().equals("-h")){
                System.out.println(Enigma.getMENU());
            } else if(!args.getOption().equals("-e") && !args.getOption().equals("-d")) {
                throw new EnigmaException("Wrong option");
            } else if (!isCipherAvailable(args.getCipher())) {
                throw new EnigmaException("No such cipher");
            } else if(!fileExists(args.getFile())){
                throw new EnigmaException("File not found");
            } else if(args.getCipher().equals("rail-fence") && args.getKey() == null){
                throw new EnigmaException("No key given");
            }

        }catch(EnigmaException e){
            System.out.println(e.getMessage());
        }

    }
}
