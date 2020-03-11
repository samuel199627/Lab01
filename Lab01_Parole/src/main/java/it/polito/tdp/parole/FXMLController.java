package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	//elenco delle parole
	Parole elenco ;
	List<String> elencoOrdinato=new LinkedList<String>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	//bottone inserisci in cui dobbiamo inserire nell'area di testo l'elenco di parole in ordine alfabetico
    	txtResult.clear();
    	String inserita=txtParola.getText();
    	if(inserita.length()==0) {
    		System.out.println("\nPAROLA VUOTA, DUNQUE NON INSERITA!");
    	}
    	else {
    		elenco.addParola(inserita);
    	}
    	String stampa="";
    	elencoOrdinato=elenco.getElenco();
    	for(String i: elencoOrdinato) {
    		stampa=stampa+"\n"+i;
    	}
    	txtResult.appendText(stampa);
    	
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	txtResult.clear();
    	elenco.reset();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
