package com.mycompany.inventaris.view;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class UserPage extends StackPane {

    public UserPage() {
        initializeUI();
    }

    private void initializeUI() {

        // ===== BACKGROUND SHAPES =====
        Pane bg = new Pane();

        Circle topRed = new Circle(170, Color.web("#931717"));
        topRed.setLayoutX(500);
        topRed.setLayoutY(-40);

        Circle smallBlue = new Circle(35, Color.web("#3C4C79"));
        smallBlue.setLayoutX(300);
        smallBlue.setLayoutY(140);

        Circle topRight = new Circle(150, Color.web("#A42323"));
        topRight.setLayoutX(1250);
        topRight.setLayoutY(40);

        bg.getChildren().addAll(topRed, smallBlue, topRight);


        // ===== NAVBAR =====
        BorderPane navbar = new BorderPane();
        navbar.setStyle("-fx-padding: 25 60; -fx-font-family: 'Poppins';");

        ImageView logo = new ImageView(
                new Image(getClass().getResourceAsStream("/assets/logoAsa.png"))
        );
        logo.setFitHeight(80);
        logo.setPreserveRatio(true);
        navbar.setLeft(logo);

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


        // ===== TEXT CONTENT =====
        Label hello = new Label("Hello, User !!");
        hello.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #334155;");

        Label title = new Label("Daftar Barang");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #1e293b;");

        VBox header = new VBox(hello, title);
        header.setSpacing(8);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setStyle("-fx-padding: 20 60 10 60;");


        // ===== TABLE =====
        TableView<String> table = new TableView<>();
        table.setPrefWidth(1000);

        TableColumn<String, String> noCol = new TableColumn<>("No.");
        noCol.setPrefWidth(60);

        TableColumn<String, String> idCol = new TableColumn<>("ID Barang");
        idCol.setPrefWidth(200);

        TableColumn<String, String> nameCol = new TableColumn<>("Nama Barang");
        nameCol.setPrefWidth(300);

        TableColumn<String, String> catCol = new TableColumn<>("Kategori Barang");
        catCol.setPrefWidth(250);

        TableColumn<String, Void> actionCol = new TableColumn<>("Action");
        actionCol.setPrefWidth(160);
        actionCol.setStyle("-fx-alignment: CENTER;");

        actionCol.setCellFactory(col -> new TableCell<>() {
            private final Button btn = new Button("Detail");

            {
                btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #B91C1C; -fx-font-weight: bold;");
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        });

        table.getColumns().addAll(noCol, idCol, nameCol, catCol, actionCol);


        // ===== WRAP TABLE WITH SPACING =====
        HBox tableWrapper = new HBox(table);
        tableWrapper.setAlignment(Pos.CENTER);
        tableWrapper.setStyle("-fx-padding: 10 60 40 60;"); // ✅ spacing kanan-kiri


        // ===== CONTENT STACK =====
        VBox content = new VBox(navbar, header, tableWrapper);
        content.setSpacing(10);
        content.setAlignment(Pos.TOP_CENTER);

        this.getChildren().addAll(bg, content);
    }
}
