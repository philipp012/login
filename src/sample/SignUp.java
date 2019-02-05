package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUp {
    public TextField tfUname;
    public TextField tfEmail;
    public PasswordField pfPass;
    public PasswordField pfPassConfirm;
    public Button btSignup;
    public Button btDiscard;

    void init() {

    }

    public void signup() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Missing Data");
        if (tfUname.getText().isEmpty()) {
            alert.setHeaderText("No valid Username has been entered");
            alert.showAndWait();
        } else if (tfEmail.getText().isEmpty()) {
            alert.setHeaderText("No valid Email has been entered");
            alert.showAndWait();

        } else if (pfPass.getText().isEmpty()) {
            alert.setHeaderText("No valid Password has been entered");
            alert.showAndWait();

        } else if (pfPassConfirm.getText().isEmpty()) {
            alert.setHeaderText("Please confirm your Password");
            alert.showAndWait();

        } else if (!pfPass.getText().equals(pfPassConfirm.getText())) {
            alert.setTitle("Password Confirmation");
            alert.setHeaderText("The entered Passwords don't match");
            alert.showAndWait();
        } else {
            System.out.println("new User");
        }

    }

    public void discard() throws IOException {
        Stage stageToClose = (Stage) btDiscard.getScene().getWindow();
        stageToClose.close();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("sample.fxml" ));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        ((Controller) fxmlLoader.getController()).init();

        Stage sample = new Stage();
        sample.setTitle("Login");
        sample.setScene(scene);
        sample.setResizable(false);
        sample.show();
    }
}
