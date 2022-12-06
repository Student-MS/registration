package com.example.firstguiapp;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Registrationform {
    public PasswordField regPassw;
    public PasswordField regRepeatPassw;
    public DatePicker regbirth;
    public RadioButton regMale;
    public RadioButton regFemale;
    private Button regButton;
    @FXML
    private TextField regID;

    private PasswordField passwordField;
    private DatePicker datePicker;
    private boolean loginStatus = false;
    @FXML
    public void setRegButton() throws IOException {
        File file=new File("logins.txt");
        Scanner scanner=new Scanner(file);
        loginStatus = true;
        while (scanner.hasNext()) {
            String[] loginpassword=scanner.nextLine().split(" ");
            if (loginpassword[0].equals(regID.getText()) || Objects.equals(regID.getText(), "")){
                loginStatus = false;
            }
        }
        if (!loginStatus){
            System.out.println("This login is not available!");
        }
        else if (!regPassw.getText().equals(regRepeatPassw.getText()) || regRepeatPassw.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Passwords must be same!");
            alert.setTitle("Passwords must be same!");
            alert.setContentText("Passwords must be same!");
            alert.showAndWait();
            System.out.println("Passwords must be same!");
        }
        else if (regbirth.getValue() == null) System.out.println("Set date of birth!");
        else {
            FileWriter write = new FileWriter("logins.txt", true);
            write.append(regID.getText()).append(" ");
            write.append(regPassw.getText()).append(" ");
            write.append(regbirth.getValue().toString()).append("\n");
            write.close();
            System.out.println("Successfully registered!");
            System.out.println(regID.getText());
            System.out.println(regPassw.getText());
            System.out.println(regbirth.getValue());
        }
    }
}
