import Entity.Users;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

/**
 * Класс, для старта программы
 */
public class Main extends Application{
    public static void main(String[] args) {
        launch(args);

    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/startpageView.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Приемная комиссия");
        stage.show();
    }

}
