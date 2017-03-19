package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
    
    AlienDictionary dizionario = new AlienDictionary();
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String stringa = txtWord.getText();
    	int lun = stringa.split(" ").length;
    	
    	if( lun == 2)
    		dizionario.addWord(stringa);
    	if(lun == 1)
    		txtResult.setText(dizionario.translateWord(stringa));
    	
    	/*boolean nuovaParola = false;
    	int i = 0;
    	int j = 0;
    	int k = 0;
    	
    	for(int z=0; z<stringa.length();z++){
    		if((!Character.isLetter(stringa.charAt(z)) && (!Character.isSpaceChar(stringa.charAt(z)))) || (Character.isSpaceChar(stringa.charAt(z)) && nuovaParola == true)){
    			txtResult.setText("Inserito carattere non valido");
    			return;
    		}
    		if(stringa.charAt(z)== ' '){
    			nuovaParola = true;
    			i = z;
    		}
    	}
    	
    	if(nuovaParola == true){
    		for(j = 0 ; j<dizionario.size();j++)
    			if(dizionario.get(j).getParola().toLowerCase().compareTo(stringa.substring(0, i).toLowerCase())==0){
    				dizionario.get(j).setTraduzione(stringa.substring(i+1, stringa.length()));
    				break;
    			}
    		
    		if(j == dizionario.size())
    			dizionario.add(new Word(stringa.substring(0, i),stringa.substring(i+1, stringa.length())));
    	}
    	
    	if(nuovaParola == false)
    		for(k=0; k<dizionario.size(); k++)
    			if(stringa.toLowerCase().compareTo(dizionario.get(k).getParola().toLowerCase())==0){
    				txtResult.setText(dizionario.get(k).getTraduzione());
    				break;
    			}
    	if(k == dizionario.size())
    		txtResult.setText("Parola non trovata.");*/
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    }
    
}
