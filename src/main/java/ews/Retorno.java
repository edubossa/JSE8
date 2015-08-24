package ews;

public class Retorno {

	private String remetente;
	private String destinatario;

	public Retorno(String remetente, String destinatario) {
		this.remetente = remetente;
		this.destinatario = destinatario;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	@Override
	public String toString() {
		return "Retorno [remetente=" + remetente + ", destinatario=" + destinatario + "]";
	}

}