/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outilgestionmateriel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FROSINI
 */
public class Salle {
    
    private int idSalle;
    private String nomSalle;
    private float longueurSalle;
    private float largeurSalle;
    
    /*Constructeur de la classe Salle*/
    public Salle(int idSalle, String nomSalle, float longueurSalle, float largeurSalle){
        
        this.idSalle = idSalle;
        this.nomSalle = nomSalle;
        this.longueurSalle = longueurSalle;
        this.largeurSalle = largeurSalle;
    };
    
    /*Méthode qui créé une salle*/
    public static boolean CreateSalle(String nomSalle,float longueurSalle,float largeurSalle) throws SQLException{
        boolean bool = false;
        ConnexionSQL.initConn();
        String query = "INSERT INTO salle (`Nom_Salle`, `Longueur_Salle`, `Largeur_Salle`) VALUES (?, ?, ?)";
        try{
            PreparedStatement stmt = ConnexionSQL.conn.prepareStatement(query);

            stmt.setString(1,nomSalle);
            stmt.setFloat(2,largeurSalle);
            stmt.setFloat(3,largeurSalle);
            int res = stmt.executeUpdate();
            if(res != 0){
                bool = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        };
        ConnexionSQL.finalise();
        return bool;
    }
    
    /*Méthode qui supprime une salle*/
    public static boolean DeleteSalle(String nomSalle) throws SQLException{
        boolean bool = false;
        ConnexionSQL.initConn();
        String query = "DELETE FROM salle WHERE Nom_Salle = ?";
        try{
            PreparedStatement stmt = ConnexionSQL.conn.prepareStatement(query);

            stmt.setString(1,nomSalle);
            int res = stmt.executeUpdate();
            if(res != 0){
                bool = true;
            }

        }catch(Exception e){
            e.printStackTrace();
        };
        ConnexionSQL.finalise();
        return bool;
    }
    
    /*Méthode qui modifie une salle*/
    public static boolean UpdateSalle(String nomSalle, float longueurSalle, float largeurSalle, String condition) throws SQLException{
        boolean bool = false;
        ConnexionSQL.initConn();
        String query = "UPDATE salle SET `Nom_Salle`= ?, `Longueur_Salle`= ?, `Largeur_Salle`= ? WHERE ?";
        try{
            PreparedStatement stmt = ConnexionSQL.conn.prepareStatement(query);

            stmt.setString(1,nomSalle);
            stmt.setFloat(2,longueurSalle);
            stmt.setFloat(3,largeurSalle);
            stmt.setString(4,condition);
            int res = stmt.executeUpdate();
            if(res != 0){
                bool = true;
            }

        }catch(Exception e){
            e.printStackTrace();
        };
        ConnexionSQL.finalise();
        return bool;
    }
    
    public static List<Salle> listSalle() throws SQLException{
        List<Salle> listSalle = new ArrayList();
        ConnexionSQL.initConn();
        String query = "SELECT * FROM salle";
        try{
            PreparedStatement stmt = ConnexionSQL.conn.prepareStatement(query);
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                Salle salle = new Salle(res.getInt("Id_Salle"),res.getString("Nom_Salle"),res.getFloat("Longueur_Salle"),res.getFloat("Largeur_Salle"));
                listSalle.add(salle);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        ConnexionSQL.finalise();
        return listSalle;
    }
    /**
     * @return the idSalle
     */
    public int getIdSalle() {
        return idSalle;
    }

    /**
     * @param idSalle the idSalle to set
     */
    private void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    /**
     * @return the nomSalle
     */
    private String getNomSalle() {
        return nomSalle;
    }

    /**
     * @param nomSalle the nomSalle to set
     */
    private void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    /**
     * @return the longueurSalle
     */
    private float getLongueurSalle() {
        return longueurSalle;
    }

    /**
     * @param longueurSalle the longueurSalle to set
     */
    private void setLongueurSalle(float longueurSalle) {
        this.longueurSalle = longueurSalle;
    }

    /**
     * @return the largeurSalle
     */
    private float getLargeurSalle() {
        return largeurSalle;
    }

    /**
     * @param largeurSalle the largeurSalle to set
     */
    private void setLargeurSalle(float largeurSalle) {
        this.largeurSalle = largeurSalle;
    }

    @Override
    public String toString() {
        return  nomSalle;
    }

}
