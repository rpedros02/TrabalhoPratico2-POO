/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Exceptions;

/**
 * Exception thrown when a given date is Invalid.
 */
public class InvalidDateException extends RuntimeException {
    public InvalidDateException(String s) {
        super(s);
    }
}