package it.polito.tdp.alien;

public class Word {
	
	private String parola;
	private String traduzione;
	
	public Word(String parola, String traduzione) {
		this.parola = parola;
		this.traduzione = traduzione;
	}

	public String getParola() {
		return parola;
	}

	public String getTraduzione() {
		return traduzione;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public void setTraduzione(String traduzione) {
		this.traduzione = traduzione;
	}

	@Override
	public boolean equals(Object arg0) {
		String altra = ((Word)arg0).getParola();
		
		if(parola.toLowerCase().compareTo(altra.toLowerCase())==0)
			return true;
		else
			return false;
	}
	
	

}
