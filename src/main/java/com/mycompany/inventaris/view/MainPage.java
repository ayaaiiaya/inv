package com.mycompany.inventaris.view;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MainPage extends StackPane {

    private Stage stage;
    public MainPage(Stage stage) {
        this.stage = stage;
        initializeUI();
    }

    private void initializeUI() {

        // ====== BACKGROUND SHAPES ======
        Pane bgShapes = new Pane();

        Circle topLeft = new Circle(170, Color.web("#931717"));
        topLeft.setLayoutX(500);
        topLeft.setLayoutY(-40);

        Circle smallBlue = new Circle(35, Color.web("#3C4C79"));
        smallBlue.setLayoutX(650);
        smallBlue.setLayoutY(140);

        Circle topRight = new Circle(150, Color.web("#A42323"));
        topRight.setLayoutX(1250);
        topRight.setLayoutY(40);

        Circle bottomLeft = new Circle(230, Color.web("#A42323"));
        bottomLeft.setLayoutX(180);
        bottomLeft.setLayoutY(750);

        bgShapes.getChildren().addAll(topLeft, smallBlue, topRight, bottomLeft);


        // ====== NAVBAR ======
        BorderPane navbar = new BorderPane();
        navbar.setStyle("-fx-padding: 25 60; -fx-background-color: transparent; -fx-font-family: 'Poppins';");

        // LOGO (kiri)
        ImageView logo = new ImageView(
                new Image(getClass().getResourceAsStream("/assets/logoAsa.png"))
        );
        logo.setFitHeight(70);
        logo.setPreserveRatio(true);
        navbar.setLeft(logo);

        // MENU (tengah)
        HBox menu = new HBox(
                new Label("Home"),
                new Label("About"),
                new Label("Guide"),
                new Label("Contact")
        );
        menu.setSpacing(40);
        menu.setStyle("-fx-font-size: 16px; -fx-text-fill: #334155; -fx-font-weight: bold; -fx-padding: 0 0 0 300; -fx-font-family: 'Poppins';");
        menu.setAlignment(Pos.CENTER);
        navbar.setCenter(menu);

        // ====== HERO TEXT ======
        Label title = new Label("Sistem Inventaris Barang Kampus");
        title.setStyle(
            "-fx-font-size: 32px; -fx-font-weight: bold; -fx-text-fill: #334155; -fx-font-family: 'Poppins';"
        );

        Label subtitle = new Label(
                "Kelola dan pantau aset kampus secara\n" +
                "efisien, cepat, dan terintegrasi."
        );
        subtitle.setStyle(
            "-fx-font-size: 18px; -fx-font-weight: normal; -fx-text-fill: #black; -fx-font-family: 'Poppins';"
        );

        subtitle.setLineSpacing(4);

        Button userBtn = new Button("User");
        userBtn.setStyle(
            "-fx-background-color: #A42323; -fx-text-fill: white; -fx-padding: 10 38; -fx-background-radius: 20; -fx-font-family: 'Poppins';"
        );
        userBtn.setOnAction(e -> goToUserPage());

        Button adminBtn = new Button("Admin");
        adminBtn.setStyle(
            "-fx-background-color: #2C3A63; -fx-text-fill: white; -fx-padding: 10 38; -fx-background-radius: 20; -fx-font-family: 'Poppins';"
        );

        HBox buttons = new HBox(userBtn, adminBtn);
        buttons.setSpacing(20);

        VBox leftContent = new VBox(title, subtitle, buttons);
        leftContent.setSpacing(25);
        leftContent.setAlignment(Pos.CENTER_LEFT);


        // ====== HERO IMAGE ======
        ImageView heroImage = new ImageView(
                new Image(getClass().getResourceAsStream("/assets/logoInv.png"))
        );
        heroImage.setFitWidth(420);
        heroImage.setPreserveRatio(true);

        HBox hero = new HBox(leftContent, heroImage);
        hero.setSpacing(80);
        hero.setAlignment(Pos.CENTER);
        hero.setStyle("-fx-padding: 60 80;");

        VBox content = new VBox(navbar, hero);
        content.setAlignment(Pos.TOP_CENTER);


        // ====== ADD TO STACKPANE ======
        this.getChildren().addAll(bgShapes, content);
    }
     private void goToUserPage(){
       Scene newScene = new Scene(new UserPage(), 1280, 720);
       stage.setScene(newScene);
     }
        
}
