package beans;

public class Utilisateur {

    private String login;
    private String motDePasse;
    //private String nom;

    public void setLogin(String login) {
	this.login = login;
    }
    public String getLogin() {
	return login;
    }

    public void setMotDePasse(String motDePasse) {
	this.motDePasse = motDePasse;
    }
    public String getMotDePasse() {
	return motDePasse;
    }
/*
    public void setNom(String nom) {
	this.nom = nom;
    }
    public String getNom() {
	return nom;
    }*/
}