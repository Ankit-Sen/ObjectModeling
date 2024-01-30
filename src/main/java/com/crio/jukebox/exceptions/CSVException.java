package com.crio.jukebox.exceptions;

public class CSVException extends RuntimeException {

    public CSVException(){
        super();
    }

    public CSVException(String msg){
        super(msg);
    }
    
}
