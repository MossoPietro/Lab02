/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private TextField txtTesto;
    
    private AlienDictionary dizionario;

    @FXML
    void doReset(ActionEvent event) {
    	dizionario.reset();
    	txtRisultato.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String input;
    	
    	input = txtTesto.getText().toLowerCase();
    	if (input.equals("")) {
    		txtRisultato.setText("Inserire delle parole");
    		return;
    	}
    	
    	//per separare l'input, potrei utilizzare uno StringTokenizer
    	
    	String inputSeparato[] = input.split(" ");
    	
    	if (inputSeparato.length == 1) {
    		String parolaAliena = inputSeparato[0];
    		
    		if (!parolaAliena.matches("[a-zA-Z]+")) {
    			txtRisultato.setText("Inserire solo caratteri alfabetici");
        		return;
    		}
    		
    		String traduzione = dizionario.translate(parolaAliena);
    		if (traduzione == null) {
    			txtRisultato.setText("La parola digitata non ha ancora una traduzione!");
    			return;
    		}
    		txtRisultato.setText(traduzione);
    		
    	} else if (inputSeparato.length == 2) {
    		String parolaAliena = inputSeparato[0];
    		String traduzione = inputSeparato[1];
    		
    		if (!parolaAliena.matches("[a-zA-Z]+") || !traduzione.matches("[a-zA-Z]+")) {
    			txtRisultato.setText("Inserire solo caratteri alfabetici");
        		return;
    		}
    		
    		dizionario.addWord(parolaAliena, traduzione);
    		txtRisultato.setText("La parola '" + parolaAliena + "' è stata aggiunta con traduzione '" + traduzione + "'.");
    	}
    	
    	
    }

    @FXML
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        
        dizionario = new AlienDictionary();
    }

}

