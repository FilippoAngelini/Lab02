package it.polito.tdp.alien;

import java.util.ArrayList;

public class WordEnhanced extends Word{
	
	private ArrayList <String> traduzioni = new ArrayList <String>();

	public WordEnhanced(String parola, String traduzione) {
		super(parola, traduzione);
		traduzioni.add(traduzione);
	}

	@Override
	public String getTraduzione() {
		
		String ris = "";
		
		for(String s : traduzioni)
			ris += s + "\n";
		
		return ris;
	}

	@Override
	public void setTraduzione(String traduzione) {
		
		boolean giaInserita = false;
		
		for(int i =0; i<traduzioni.size();i++)
			if(traduzioni.get(i).compareTo(traduzione)==0){
				giaInserita = true;
				break;
			}
		
		if(!giaInserita)
			traduzioni.add(traduzione);
	}
	
	

}
