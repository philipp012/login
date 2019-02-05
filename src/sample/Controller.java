package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public PasswordField pfPassword;
    public TextField tfUsername;
    public ImageView imUser;
    public Button loginbt;
    public Button signupbt;


    public void btSignup() throws IOException {
        Stage stageToClose = (Stage) signupbt.getScene().getWindow();
        stageToClose.close();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("signUp.fxml" ));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        ((SignUp) fxmlLoader.getController()).init();

        Stage signup = new Stage();
        signup.setTitle("Sign up");
        signup.setScene(scene);
        signup.setResizable(false);
        signup.show();
    }

    public void btLogin() throws IOException {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Missing Data");
        if (!tfUsername.getText().isEmpty()) {
            if (!pfPassword.getText().isEmpty()) {
                if (tfUsername.getText().equals("philipp") && pfPassword.getText().equals("1234")) {
                    Stage stageToClose = (Stage) loginbt.getScene().getWindow();
                    stageToClose.close();
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("login.fxml" ));
                    Scene scene = new Scene(fxmlLoader.load(), 400, 500);
                    ((Login) fxmlLoader.getController()).init();

                    Stage stage = new Stage();
                    stage.setTitle("Logged in");
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.show();
                } else {
                    alert.setHeaderText("Wrong Username or Password");
                    alert.showAndWait();
                }
            } else {
                alert.setHeaderText("No valid Password has been entered");
                alert.setContentText("Please the Password for the Account you want to log into");

                alert.showAndWait();
            }
        } else {
            alert.setHeaderText("No valid Username has been entered");
            alert.setContentText("Please specify into which Account you want to log in");

            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Image image = new Image(new FileInputStream("/home/philipp/login/src/sample/userIcon.png"));
            imUser.setImage(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void init() {
    }
}

