package donnees.messages;

import exceptions.ExceptionConversionImpossible;

import java.util.ArrayList;

public interface Message {
    public String asString() throws ExceptionConversionImpossible;
    public Integer asInteger() throws ExceptionConversionImpossible;
    public ArrayList<Integer> getListAsciiCode() throws ExceptionConversionImpossible;
}
