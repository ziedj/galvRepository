package galv.entities;

import java.io.Serializable;
import java.util.Date;

public class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date dateDebut;
	private Date dateFin;
	private String duree;
	private Long idVehicule;
	private Long idClient;
	private String idLocation;
	private String immatriculationVoiture;
	private String cinClient;
	private Long prixUnitaire;
	private Long sommeTotale;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", dateDebut=" + dateDebut + ", duree="
				+ duree + ", idVehicule=" + idVehicule + ", idClient="
				+ idClient + "]";
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public Long getIdVehicule() {
		return idVehicule;
	}

	public void setIdVehicule(Long idVehicule) {
		this.idVehicule = idVehicule;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(String idLocation) {
		this.idLocation = idLocation;
	}

	public String getImmatriculationVoiture() {
		return immatriculationVoiture;
	}

	public void setImmatriculationVoiture(String immatriculationVoiture) {
		this.immatriculationVoiture = immatriculationVoiture;
	}

	public String getCinClient() {
		return cinClient;
	}

	public void setCinClient(String cinClient) {
		this.cinClient = cinClient;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Long getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Long prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Long getSommeTotale() {
		return sommeTotale;
	}

	public void setSommeTotale(Long sommeTotale) {
		this.sommeTotale = sommeTotale;
	}

}
