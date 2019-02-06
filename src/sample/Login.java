package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    public Button btLogou;

    void init() {

    }

    public void logOut() throws IOException {
        Stage stageToClose = (Stage) btLogou.getScene().getWindow();
        stageToClose.close();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        ((Controller) fxmlLoader.getController()).init();

        Stage sample = new Stage();
        sample.setTitle("Login");
        sample.setScene(scene);
        sample.setResizable(false);
        sample.show();
    }
}
