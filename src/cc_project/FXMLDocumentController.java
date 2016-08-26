/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc_project;

import cc_project.validations.keywords;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author hii
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextArea text;

    File file;
    FileChooser fileChooser = new FileChooser();
  Stage temp_stg = new Stage();
    @FXML
    private MenuItem New;
    @FXML
    private MenuItem open;
    @FXML
    private MenuItem Save;
    @FXML
    private TextArea error_box;
    @FXML
    private void handleButtonAction(ActionEvent event) throws FileNotFoundException {
        System.out.println("You clicked me!");
        label.setText("Hello World!");

        fileChooser.setTitle("Open Resource File");
        // stg.show();
        file = fileChooser.showOpenDialog(temp_stg);
        System.out.println(file);
        fileSetToText(file);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            keywords k = new keywords();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void fileSetToText(File file) throws FileNotFoundException {
        Scanner in = new Scanner(file);
        String input = "";
        while (in.hasNext()) {

            input += in.next();
            System.out.println(input);
        }

        text.setText(input);

        in.close();
    }

    @FXML
    private void saveAction(ActionEvent event) throws FileNotFoundException {

        String input = text.getText();
        if (file == null) {
            file = fileChooser.showSaveDialog(temp_stg);
        }
        PrintWriter write = new PrintWriter(file);
        write.print(input);

        write.close();

    }

    @FXML
    private void newFile(ActionEvent event) {
        
        text.setText("");
    }

}
