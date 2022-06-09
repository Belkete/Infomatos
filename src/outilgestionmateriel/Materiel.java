/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outilgestionmateriel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author FROSINI
 */
public class Materiel {
    
    private String idMateriel;
    private String nomMateriel;
    private int etatMateriel;
    private String idType;
    private String idSalle;

    /*Contructeur de la classe Materiel*/
    public Materiel(String idMateriel, String nomMateriel, int etatMateriel, String idType, String idSalle){
        this.idMateriel = idMateriel;
        this.nomMateriel = nomMateriel;
        this.etatMateriel = etatMateriel;
        this.idType = idType;
        this.idSalle = idSalle;
    }
    
    /*Méthode qui créé un matériel*/
    public static boolean CreateMateriel(String codeMateriel,String nomMateriel, int etatMateriel, String idType, String idSalle ) throws SQLException{
        boolean bool = false;
        ConnexionSQL.initConn();
        String query = "INSERT INTO materiel (`Code_Materiel`,`Nom_Materiel`, `Etat_Materiel`, `Id_Type`, `Id_Salle`) VALUES (?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt = ConnexionSQL.conn.prepareStatement(query);
            
            stmt.setString(1,codeMateriel);
            stmt.setString(2,nomMateriel);
            stmt.setInt(3,etatMateriel);
            stmt.setString(4,idType);
            stmt.setString(5,idSalle);
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
    
    /*Méthode qui supprimé un matériel*/
    public static boolean DeleteMateriel(String nomMateriel) throws SQLException{
        boolean bool = false;
        ConnexionSQL.initConn();
        String query = "DELETE FROM materiel WHERE Nom_Materiel = ?";
        try{
            PreparedStatement stmt = ConnexionSQL.conn.prepareStatement(query);

            stmt.setString(1,nomMateriel);
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
    
    /*Méthode qui modifie un matériel*/
    public static boolean UpdateMateriel(String nomMateriel, int etatMateriel) throws SQLException{
        boolean bool = false;
        ConnexionSQL.initConn();
        String query = "UPDATE materiel SET `Nom_Materiel`= ?, `Etat_Materiel`= ? where Nom_Materiel = ?";
        try{
            PreparedStatement stmt = ConnexionSQL.conn.prepareStatement(query);

            stmt.setString(1,nomMateriel);
            stmt.setInt(2,etatMateriel);
            stmt.setString(3,nomMateriel);
            
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
    
    public static List<Materiel> listMateriel(int idSalle) throws SQLException{
        List<Materiel> listMateriel = new ArrayList();
        ConnexionSQL.initConn();
        String query = "SELECT * FROM materiel WHERE Id_Salle = ?";
        try{
            PreparedStatement stmt = ConnexionSQL.conn.prepareStatement(query);
            stmt.setInt(1,idSalle);
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                Materiel materiel = new Materiel(res.getString("Code_Materiel"),res.getString("Nom_Materiel"),res.getInt("Etat_Materiel"),res.getString("Id_Type"),res.getString("Id_Salle"));
                listMateriel.add(materiel);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        ConnexionSQL.finalise();
        return listMateriel;
    }

    @Override
    public String toString() {
        return nomMateriel;
    }

    /**
     * @return the idMateriel
     */
    public String getIdMateriel() {
        return idMateriel;
    }

    /**
     * @param idMateriel the idMateriel to set
     */
    private void setIdMateriel(String idMateriel) {
        this.idMateriel = idMateriel;
    }

    /**
     * @return the etatMateriel
     */
    public int getEtatMateriel() {
        return etatMateriel;
    }

    /**
     * @param etatMateriel the etatMateriel to set
     */
    private void setEtatMateriel(int etatMateriel) {
        this.etatMateriel = etatMateriel;
    }

    /**
     * @return the idType
     */
    private String getIdType() {
        return idType;
    }

    /**
     * @param idType the idType to set
     */
    private void setIdType(String idType) {
        this.idType = idType;
    }

    /**
     * @return the idSalle
     */
    private String getIdSalle() {
        return idSalle;
    }

    /**
     * @param idSalle the idSalle to set
     */
    private void setIdSalle(String idSalle) {
        this.idSalle = idSalle;
    }

    /**
     * @return the nomMateriel
     */
    public String getNomMateriel() {
        return nomMateriel;
    }

    /**
     * @param nomMateriel the nomMateriel to set
     */
    private void setNomMateriel(String nomMateriel) {
        this.nomMateriel = nomMateriel;
    }
}
