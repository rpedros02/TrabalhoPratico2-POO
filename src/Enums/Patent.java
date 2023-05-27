/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 *
 * Nome: Miguel Correia da Silva
 * Número: 8221002
 * Turma: LSIG
 */
package Enums;

import java.io.Serializable;

/**
 * Enumerator of the {@link Models.CrewMember CrewMembers}' Patent
 */
public enum Patent implements Serializable {
    PRACA,
    SARGENTO,
    SUBALTERNO,
    GENERAL;

    /**
     * Conventional method toString but takes the patent and converts itself to current language
     *
     * @param patent
     * @return patent in current language
     */
    public String toString(Patent patent) {
        switch (patent) {
            case PRACA -> {
                return "Praça";
            }
            case SARGENTO -> {
                return "Sargento";
            }
            case SUBALTERNO -> {
                return "Oficial Subalterno";
            }
            default -> {
                return "Oficial General";
            }
        }
    }
}
