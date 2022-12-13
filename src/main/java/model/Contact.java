package model;

public class Contact {
	private int reference;
	private String nom,adresseIp;
	public Contact() {};
	public void setReference(int reference) {
		this.reference = reference;
	}
	public Contact(int reference, String nom, String adresseIp) {
		super();
		this.reference = reference;
		this.nom = nom;
		this.adresseIp = adresseIp;
	}
	public Contact(String nom, String adresseIp) {
		this.nom = nom;
		this.adresseIp = adresseIp;
	}
	public int getReference() {
		return reference;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresseIp() {
		return adresseIp;
	}
	public void setAdresseIp(String adresseIp) {
		this.adresseIp = adresseIp;
	}
	@Override
	public String toString() {
		return "Contact [reference=" + reference + ", nom=" + nom + ", adresseIp=" + adresseIp + "]";
	}
	
	
}
