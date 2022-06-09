/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outilgestionmateriel;

/**
 *
 * @author FROSINI
 */
public class Session {
    public static Utilisateur UTIL_CONN = null;

    @Override
    public String toString() {
        return Session.UTIL_CONN.getNomUtilisateur();
    }
}
