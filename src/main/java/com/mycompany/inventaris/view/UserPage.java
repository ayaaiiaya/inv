package com.mycompany.inventaris.view;

import com.mycompany.inventaris.dao.BarangDAO;
import com.mycompany.inventaris.model.Barang;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class UserPage extends StackPane {

    private TableView<Barang> table;

    public UserPage() {
        initializeUI();
    }

    private void initializeUI() {

        // ========== BACKGROUND SHAPES ==========
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


        // ========== NAVBAR ==========
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
        menu.setStyle("-fx-font-size: 16px; -fx-text-fill: #334155; -fx-font-weight: bold;");
        menu.setAlignment(Pos.CENTER);
        navbar.setCenter(menu);


        // ========== HEADER ==========
        Label hello = new Label("Hello, User !!");
        hello.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #334155;");

        Label title = new Label("Daftar Barang");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #1e293b;");

        VBox header = new VBox(hello, title);
        header.setSpacing(8);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setStyle("-fx-padding: 20 60 10 60;");


        // ========== TABLEVIEW ==========
        table = new TableView<>();
        table.setPrefWidth(1000);

        // Kolom nomor otomatis (index + 1)
        TableColumn<Barang, Number> noCol = new TableColumn<>("No.");
        noCol.setPrefWidth(60);
        noCol.setCellValueFactory(col ->
                new ReadOnlyObjectWrapper<>(table.getItems().indexOf(col.getValue()) + 1)
        );

        TableColumn<Barang, String> idCol = new TableColumn<>("ID Barang");
        idCol.setPrefWidth(200);
        idCol.setCellValueFactory(new PropertyValueFactory<>("idBarang"));

        TableColumn<Barang, String> nameCol = new TableColumn<>("Nama Barang");
        nameCol.setPrefWidth(300);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nama"));

        TableColumn<Barang, String> catCol = new TableColumn<>("Kategori");
        catCol.setPrefWidth(250);
        catCol.setCellValueFactory(new PropertyValueFactory<>("kategori"));

        // Kolom tombol Detail
        TableColumn<Barang, Void> actionCol = new TableColumn<>("Action");
        actionCol.setPrefWidth(160);
        actionCol.setStyle("-fx-alignment: CENTER;");

        actionCol.setCellFactory(col -> new TableCell<>() {
            private final Button btn = new Button("Detail");

            {
                btn.setStyle("-fx-background-color: transparent; -fx-text-fill: #B91C1C; "
                        + "-fx-font-size: 14px; -fx-font-weight: bold;");
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        });

        table.getColumns().addAll(noCol, idCol, nameCol, catCol, actionCol);

        // Load Data Dari DB
        table.setItems(BarangDAO.getAll());

        // Wrapper supaya tidak nempel kiri-kanan
        HBox tableWrapper = new HBox(table);
        tableWrapper.setAlignment(Pos.CENTER);
        tableWrapper.setStyle("-fx-padding: 10 60 40 60;");


        // ========== LAYOUT UTAMA ==========
        VBox content = new VBox(navbar, header, tableWrapper);
        content.setSpacing(10);
        content.setAlignment(Pos.TOP_CENTER);

        this.getChildren().addAll(bg, content);
    }
}
