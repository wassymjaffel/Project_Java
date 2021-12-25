package model;

public class categorie {
	private int id;
	private String nom;
	private String description;
	private String statue;
	public categorie(int id, String nom, String description, String statue) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatue() {
		return statue;
	}
	public void setStatue(String statue) {
		this.statue = statue;
	}
	@Override
	public String toString() {
		return "categorie [id=" + id + ", nom=" + nom + ", description=" + description + ", statue=" + statue + "]";
	}
	
}
