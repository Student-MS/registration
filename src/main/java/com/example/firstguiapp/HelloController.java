package com.example.firstguiapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class HelloController {
    int numberatt=5;
    String warningMessage="";
    @FXML
    private Button loginButton;
    @FXML
    private  Button regButton;
    @FXML
    private Label welcomeText;
    @FXML
    private TextField loginText;
    @FXML
    private PasswordField passwordField;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void loginSystem() throws IOException {
        numberatt--;
        if (numberatt<=0){

            loginButton.setDisable(true);
            warningMessage="Access denied !";

        }

        //https://github.com/sdjuraev/CS211LABWEEK74.git

        boolean status=false;
        File file=new File("logins.txt");
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] loginpassword=scanner.nextLine().split(" ");
                if (loginpassword[0].equals(loginText.getText())&&loginpassword[1].equals(passwordField.getText())){
                    System.out.println("Login successful");
                    status=true;
                }
            }
            if (!status){
                Alert alert=new Alert(Alert.AlertType.ERROR,"Login or password incorrect");
                alert.setTitle("Login error");
                alert.setContentText(warningMessage+" \nLogin or password incorrect. You have "+numberatt+" attempts");
                alert.show();
            }

        }
        else {
            file.createNewFile();
        }
    }
    @FXML
    private void showRegWindow() throws IOException {
        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registrationform.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Registration form");
        stage.setAlwaysOnTop(true);
        stage.show();

    }

}