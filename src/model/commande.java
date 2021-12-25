package model;

public class commande {
	private int id;
	private String total;
	private String statue;
	private utilisateur id_agent;
	public commande(int id, String total, String statue, utilisateur id_agent) {
		super();
		this.id = id;
		this.total = total;
		this.statue = statue;
		this.id_agent = id_agent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getStatue() {
		return statue;
	}
	public void setStatue(String statue) {
		this.statue = statue;
	}
	public utilisateur getId_agent() {
		return id_agent;
	}
	public void setId_agent(utilisateur id_agent) {
		this.id_agent = id_agent;
	}
	@Override
	public String toString() {
		return "commande [id=" + id + ", total=" + total + ", statue=" + statue + "]";
	}
	
	
	
	

}
