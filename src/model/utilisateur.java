package model;

public class utilisateur {
	private int id;
	private String nom;
	private String pseudo;
	private String motdepasse;
	private String telephone;
	private String role;
	private int statue;
	public utilisateur(int id, String nom, String pseudo, String motdepasse, String telephone, String role,
			int statue) {
		super();
		this.id = id;
		this.nom = nom;
		this.pseudo = pseudo;
		this.motdepasse = motdepasse;
		this.telephone = telephone;
		this.role = role;
		this.statue = statue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getStatue() {
		return statue;
	}
	public void setStatue(int statue) {
		this.statue = statue;
	}
	@Override
	public String toString() {
		return "utilisateur [id=" + id + ", nom=" + nom + ", pseudo=" + pseudo + ", motdepasse=" + motdepasse
				+ ", telephone=" + telephone + ", role=" + role + ", statue=" + statue + "]";
	}
	
}
