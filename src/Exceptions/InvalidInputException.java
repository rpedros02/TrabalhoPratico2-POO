/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Exceptions;

/**
 * Exception thrown when a given input is Invalid.
 */
public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String s) {
        super(s);
    }
}