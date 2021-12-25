package model;

public class produit {
	 private int id;
	 private String nom;
	 private String description;
	 private String qte;
	 private String prix;
	 private String status;
	 private categorie id_categorie;
	public produit(int id, String nom, String description, String qte, String prix, String status,
			categorie id_categorie) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.qte = qte;
		this.prix = prix;
		this.status = status;
		this.id_categorie = id_categorie;
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
	public String getQte() {
		return qte;
	}
	public void setQte(String qte) {
		this.qte = qte;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public categorie getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(categorie id_categorie) {
		this.id_categorie = id_categorie;
	}
	@Override
	public String toString() {
		return "produit [id=" + id + ", nom=" + nom + ", description=" + description + ", qte=" + qte + ", prix=" + prix
				+ ", status=" + status + ", id_categorie=" + id_categorie + "]";
	}
	 
}
