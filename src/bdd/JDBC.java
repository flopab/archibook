package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


public class JDBC {
	
    private List<String> messages = new ArrayList<String>();
    
    
    public boolean connection(String login, String password2) {
    	try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {e.getMessage();
        }
    	
    	/* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        String utilisateur = "java";
        String motDePasse = "flopab";
        Connection connexion = null;
        ResultSet resultat = null;
        try {
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
            
            /* Requete preparee */
            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT password FROM User WHERE login = ?");
            preparedStatement.setString(1, login);
            System.out.println(preparedStatement);
            resultat = preparedStatement.executeQuery();
            
            /* Récupération des données du résultat de la requête de lecture */
            while ( resultat.next() ) {
                if (resultat.getString( "password" ).equals(password2)) {
                	return true;
                }
                return false;
            }
        }  catch (Exception e) {
            e.printStackTrace();
        } 
        return false;
    }
    
    public List<String> executerTests( HttpServletRequest request ) {
        /* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
        }

        /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        String utilisateur = "java";
        String motDePasse = "flopab";
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            connexion = DriverManager.getConnection( url, utilisateur, motDePasse );

            /* Création de l'objet gérant les requêtes */
            statement = connexion.createStatement();

            /* Exécution d'une requête de lecture */
            resultat = statement.executeQuery( "SELECT commonName, surName, school FROM User;" );
     
            /* Récupération des données du résultat de la requête de lecture */
            while ( resultat.next() ) {
                String commonName = resultat.getString( "commonName" );
                String surName = resultat.getString( "surName" );
                String school = resultat.getString( "school" );
                
                /* Formatage des données pour affichage dans la JSP finale. */
                messages.add( "Prenom = " + commonName + ", Nom = " + surName
                        + ", Ecole = " + school + "." );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 

        return messages;
    }

}