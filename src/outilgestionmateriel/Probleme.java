/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outilgestionmateriel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
/**
 *
 * @author FROSINI
 */
public class Probleme {
    
    private String idProbleme;
    private Date dateProbleme;
    private String etatProbleme;
    private String Note_Probleme;
    private String idUtilisateur;
    private String idUtilisateurAdmin;
    private String codeMateriel;
    
    public Probleme(String idProbleme, Date dateProbleme, String etatProbleme, String Note_Probleme, String idUtilisateur, String idUtilisateurAdmin, String codeMateriel){
        this.idProbleme = idProbleme;
        this.dateProbleme = dateProbleme;
        this.etatProbleme = etatProbleme;
        this.Note_Probleme = Note_Probleme;
        this.idUtilisateur = idUtilisateur;
        this.idUtilisateurAdmin = idUtilisateurAdmin;
        this.codeMateriel = codeMateriel;
    }
    
    public void CreateProbleme(String idProbleme,Date dateProbleme,String etatProbleme,String noteProblem, String codeMateriel) throws SQLException{
        ConnexionSQL.initConn();
        String query = "INSERT INTO probleme (`Id_Probleme`, `Date_Probleme`, `Etat_Probleme`, `Note_Problem`, `Id_Utilisateur`, `Id_Utilisateur_Admin`, `Code_Materiel`)"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        String idUtilisateurAdmin = "";
        try{
            PreparedStatement stmt = ConnexionSQL.conn.prepareStatement(query);

            stmt.setString(1,idProbleme);
            stmt.setDate(2, (java.sql.Date) dateProbleme);
            stmt.setString(3,etatProbleme);
            stmt.setString(4,noteProblem);
            stmt.setString(5,Session.UTIL_CONN.getIdUtilisateur());
            stmt.setString(6,idUtilisateurAdmin);
            stmt.setString(7,codeMateriel);
            int res = stmt.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        };
        ConnexionSQL.finalise();
    }
    
    public void UpdateProbleme(String idProbleme,String etatProbleme) throws SQLException{
        ConnexionSQL.initConn();
        String query = "UPDATE salle SET  `Etat_Probleme`= ?, `Id_Utilisateur_Admin`= ?, WHERE Id_Probleme = ?";
        try{
            PreparedStatement stmt = ConnexionSQL.conn.prepareStatement(query);

            stmt.setString(1,etatProbleme);
            stmt.setString(2,Session.UTIL_CONN.getIdUtilisateur());
            stmt.setString(3,idProbleme);
            
            
            
            
            int res = stmt.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        };
        ConnexionSQL.finalise();
    }
    

    /**
     * @return the idProbleme
     */
    private String getIdProbleme() {
        return idProbleme;
    }

    /**
     * @param idProbleme the idProbleme to set
     */
    private void setIdProbleme(String idProbleme) {
        this.idProbleme = idProbleme;
    }

    /**
     * @return the dateProbleme
     */
    private Date getDateProbleme() {
        return dateProbleme;
    }

    /**
     * @param dateProbleme the dateProbleme to set
     */
    private void setDateProbleme(Date dateProbleme) {
        this.dateProbleme = dateProbleme;
    }

    /**
     * @return the etatProbleme
     */
    private String getEtatProbleme() {
        return etatProbleme;
    }

    /**
     * @param etatProbleme the etatProbleme to set
     */
    private void setEtatProbleme(String etatProbleme) {
        this.etatProbleme = etatProbleme;
    }

    /**
     * @return the Note_Probleme
     */
    private String getNote_Probleme() {
        return Note_Probleme;
    }

    /**
     * @param Note_Probleme the Note_Probleme to set
     */
    private void setNote_Probleme(String Note_Probleme) {
        this.Note_Probleme = Note_Probleme;
    }

    /**
     * @return the idUtilisateur
     */
    private String getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * @param idUtilisateur the idUtilisateur to set
     */
    private void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    /**
     * @return the idUtilisateurAdmin
     */
    private String getIdUtilisateurAdmin() {
        return idUtilisateurAdmin;
    }

    /**
     * @param idUtilisateurAdmin the idUtilisateurAdmin to set
     */
    private void setIdUtilisateurAdmin(String idUtilisateurAdmin) {
        this.idUtilisateurAdmin = idUtilisateurAdmin;
    }

    /**
     * @return the codeMateriel
     */
    private String getCodeMateriel() {
        return codeMateriel;
    }

    /**
     * @param codeMateriel the codeMateriel to set
     */
    private void setCodeMateriel(String codeMateriel) {
        this.codeMateriel = codeMateriel;
    }
}
