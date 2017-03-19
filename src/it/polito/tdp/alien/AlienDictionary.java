package it.polito.tdp.alien;

import java.util.ArrayList;

public class AlienDictionary {
	
	private ArrayList <WordEnhanced> dizionario = new ArrayList <WordEnhanced>();
	
	public void addWord(String stringa){
		
		String parola = "";
		int i = 0;
		
		if(stringa.split(" ").length == 2 &&  controllaParola(stringa)){
			
			parola = stringa.split(" ")[0];
			
			if(dizionario.contains(new WordEnhanced(stringa.split(" ")[0],""))){
				
				for(WordEnhanced w : dizionario){
					if(parola.toLowerCase().compareTo(w.getParola().toLowerCase())==0){
						dizionario.get(i).setTraduzione(stringa.split(" ")[1]);
						break;
					}
					i++;
				}
			}
			else
				dizionario.add(new WordEnhanced (parola, stringa.split(" ")[1]));
		}
			
	}
	
	public String translateWord(String parola){
		
		int i = 0;
		
		if(dizionario.contains(new WordEnhanced (parola,""))){

			for(WordEnhanced w : dizionario){
				if(parola.toLowerCase().compareTo(w.getParola().toLowerCase())==0){
					return dizionario.get(i).getTraduzione();
				}
				i++;
			}
		}
		
		int cont = 0;
		boolean trovata = false;
		String ris = "";
		
		for(int j = 0; j < parola.length(); j++)
			if(parola.charAt(j) == '?')
					cont++;
		
		if(cont == 1)
			for(WordEnhanced w : dizionario){
				trovata = true;
				for(int j = 0; j < parola.length(); j++){
					cont = 0;
					if(w.getParola().length() == parola.length()){
						if(parola.charAt(j) == '?')
							cont++;
						if(cont > 1 || (parola.charAt(j) != '?' && w.getParola().toLowerCase().charAt(j) != parola.toLowerCase().charAt(j))){
							trovata = false;
							break;
						}
					}
					else
						trovata = false;
				}
				if(trovata == true)
					ris += "Traduzione di " + w.getParola() + ": \n" + w.getTraduzione() + "\n";
			}
		
		if(ris.compareTo("")!=0)
			return ris;
		
		return "Parola non trovata.";
		
	}
	
	private boolean controllaParola(String stringa){
		
		boolean nuovaParola = false;
		
		for(int z=0; z < stringa.length();z++){
    		if((!Character.isLetter(stringa.charAt(z)) && (!Character.isSpaceChar(stringa.charAt(z)))) || (Character.isSpaceChar(stringa.charAt(z)) && nuovaParola == true)){
    			return false;
    		}
    		if(stringa.charAt(z)== ' '){
    			nuovaParola = true;
    		}
    	}
		return true;
	}

}
