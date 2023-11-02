package it.unibo.exceptions.fakenetwork.Exceptions;

import java.io.IOException;

public class NetworkException extends IOException{

    public NetworkException() throws java.io.IOException{
        throw new java.io.IOException("Network error: no response");
    }

    public NetworkException(String message){
        System.out.println("Network error while sending message: [" + message + "]");
    }
    
}
