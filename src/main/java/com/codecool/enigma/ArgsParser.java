package com.codecool.enigma;

class ArgsParser {

    private String option;
    private String cipher;
    private String file;
    private String key;

    ArgsParser(String[] args) {

        int len = args.length;
        switch(len) {
            case 0:
                this.setOption(null);
                this.setCipher(null);
                this.setFile(null);
                this.setKey(null);
                break;
            case 1:
                this.setOption(args[0].toLowerCase());
                this.setCipher(null);
                this.setFile(null);
                this.setKey(null);
                break;
            case 2:
                this.setOption(args[0].toLowerCase());
                this.setCipher(args[1].toLowerCase());
                this.setFile(null);
                this.setKey(null);
                break;
            case 3:
                this.setOption(args[0].toLowerCase());
                this.setCipher(args[1].toLowerCase());
                this.setFile(args[2].toLowerCase());
                this.setKey(null);
                break;
            default:
                this.setOption(args[0].toLowerCase());
                this.setCipher(args[1].toLowerCase());
                this.setFile(args[2].toLowerCase());
                this.setKey(args[3].toLowerCase());

        }

    }

    void setOption(String option){
        this.option = option;
    }

    void setCipher(String cipher){
        this.cipher = cipher;
    }

    void setFile(String file){
        this.file = file;
    }

    void setKey(String key){
        this.key = key;
    }

    String getOption(){
        return option;
    }

    String getCipher(){
        return cipher;
    }

    String getFile(){
        return file;
    }

    String getKey(){
        return key;
    }
}
