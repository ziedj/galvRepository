package galv.entities;

import java.io.Serializable;
import java.util.Date;

public class Voiture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String immatriculation;
	private String couleur;
	private Date dateMiseEncirculation;
	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", immatriculation=" + immatriculation
				+ "]";
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Date getDateMiseEncirculation() {
		return dateMiseEncirculation;
	}

	public void setDateMiseEncirculation(Date dateMiseEncirculation) {
		this.dateMiseEncirculation = dateMiseEncirculation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
