/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outilgestionmateriel;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.*;
/**
 *
 * @author FROSINI
 */
public class Utilisateur {
    
    private String idUtilisateur;
    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String mailUtilisateur;
    private boolean isAdmin;
    
    /*Constructeur de la classe Utilisateur*/
    public Utilisateur(String idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String mailUtilisateur, boolean isAdmin){
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.mailUtilisateur = mailUtilisateur;
        this.isAdmin = isAdmin;
    }
    
     /*Méthode qui créé un utilisateur*/
    public static boolean CreateUtilisateur (String Nom, String Prenom, String Mail, boolean isAdmin, String mdp) throws SQLException{
        boolean bool = false;
        ConnexionSQL.initConn();
        String query = "INSERT INTO utilisateur (`Nom_Utilisateur`, `Prenom_Utilisateur`, `Mail_Utilisateur`, `isAdmin`, `mdp_Utilisateur`) VALUES (?, ?, ?, ?, sha(?))";
        try{
            PreparedStatement stmt = ConnexionSQL.conn.prepareStatement(query);

            stmt.setString(1,Nom);
            stmt.setString(2,Prenom);
            stmt.setString(3,Mail);
            stmt.setBoolean(4,isAdmin);
            stmt.setString(5,mdp);
            
            int res =stmt.executeUpdate();
            if(res != 0){
            bool = true;
        }

        }catch(Exception e){
            e.printStackTrace();
        };
        ConnexionSQL.finalise();
        return bool;
    }    
    
    /**
     * @return the idUtilisateur
     */
    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * @param idUtilisateur the idUtilisateur to set
     */
    private void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    /**
     * @return the nomUtilisateur
     */
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    /**
     * @param nomUtilisateur the nomUtilisateur to set
     */
    private void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    /**
     * @return the prenomUtilisateur
     */
    private String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    /**
     * @param prenomUtilisateur the prenomUtilisateur to set
     */
    private void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    /**
     * @return the mailUtilisateur
     */
    private String getMailUtilisateur() {
        return mailUtilisateur;
    }

    /**
     * @param mailUtilisateur the mailUtilisateur to set
     */
    private void setMailUtilisateur(String mailUtilisateur) {
        this.mailUtilisateur = mailUtilisateur;
    }

    /**
     * @return the isAdmin
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    private void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    
}
