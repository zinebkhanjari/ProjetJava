
package metier;

public class Adherent {
	private int idAd;
	private String nomAd;
	private String prenomAd;
	static String emailAd;
	private String telAd;
	private String niveauAd;
	
	public Adherent() {
		
	}
	public Adherent(int idAd) {
		this.idAd=idAd;
		
	}
	
	public static String getEmailAd() {
		return emailAd;
	}

	public String getTelAd() {
		return telAd;
	}
	public void setTelAd(String telAd) {
		this.telAd = telAd;
	}
	public static void setEmailAd(String emailAd) {
		Adherent.emailAd = emailAd;
	}
	public Adherent(String nomAd, String prenomAd, String emailAd, String telAd, String niveauAd) {
		super();
		this.nomAd = nomAd;
		this.prenomAd = prenomAd;
		this.emailAd = emailAd;
		this.telAd = telAd;
		this.niveauAd = niveauAd;
	}
	public int getIdAd() {
		return idAd;
	}
	public void setIdAd(int idAd) {
		this.idAd = idAd;
	}
	public String getNomAd() {
		return nomAd;
	}
	public void setNomAd(String nomAd) {
		this.nomAd = nomAd;
	}
	public String getPrenomAd() {
		return prenomAd;
	}
	public void setPrenomAd(String prenomAd) {
		this.prenomAd = prenomAd;
	}
	public String getNiveauAd() {
		return niveauAd;
	}
	public void setNiveauAd(String niveauAd) {
		this.niveauAd = niveauAd;
	}
   
}
