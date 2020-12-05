/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import CONSTANT.Panes;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Benjamin
 */
public class PaneEntete extends VBox
{
    
    
    private final TextField tBarreRecherche;
    private final Button bRecherche;
    private final Button bPanier;
    private final Button bBonjour;
    private final Button bLogo;
    
    private final Button[] bCategories;
    
    
    public PaneEntete()
    {
        super();
        
        //TEXTFIELD
        tBarreRecherche = new TextField("Rechercher");
        
        //BUTTON
        bLogo = new Button();
        bRecherche = new Button();
        bPanier = new Button();
        bBonjour = new Button();
        bCategories = new Button[Panes.NOMBRE_CATEGORIES_PANE_ENTETE];
        init();
    }
    
    public final void init()
    {
        //TEXTFIELD
        tBarreRecherche.setPrefWidth(Panes.BARRE_RECHERCHE_WIDTH_PANE_ENTETE);
        tBarreRecherche.setPrefHeight(Panes.BARRE_RECHERCHE_HEIGHT_PANE_ENTETE);
        tBarreRecherche.setStyle("-fx-font-size: 20");
        
        //BUTTON
        bRecherche.setStyle("-fx-background-color: #fd5300");
        
        bCategories[0] = new Button("Gros\nélectroménager");
        bCategories[1] = new Button("Cuisine\nCuisson");
        bCategories[2] = new Button("Maison\nEntretien");
        bCategories[3] = new Button("Beauté\nSanté");
        bCategories[4] = new Button("Objets\nconnecté");
        bCategories[5] = new Button("Smartphone\ntéléphonie");
        bCategories[6] = new Button("Informatique\nTablette");
        bCategories[7] = new Button("Tv Image\nSon");
        bCategories[8] = new Button("Console\nGaming");
        
        for(Button i : bCategories)
        {
            i.setStyle("-fx-background-color: #ffffff; -fx-font-weight: bold");
            i.setTextAlignment(TextAlignment.CENTER);
        }
        
        //Separator Verticale
        Separator[] separationVerticale = new Separator[Panes.NOMBRE_CATEGORIES_PANE_ENTETE-1];
        for(int i=0; i<separationVerticale.length;i++)
        {
            separationVerticale[i] = new Separator(Orientation.VERTICAL);
        }
        
        //Separator Horizontale
        Separator[] separationHorizontale = new Separator[2];
        for(int i=0; i<separationHorizontale.length;i++)
        {
            separationHorizontale[i] = new Separator(Orientation.HORIZONTAL);
            separationHorizontale[i].setMaxWidth(Panes.SEPARATOR_HORIZONTAL_WIDTH_PANE_ENTETE);
            separationHorizontale[i].setMinWidth(Panes.SEPARATOR_HORIZONTAL_WIDTH_PANE_ENTETE);
        }
        
        // Button LOGO
        Image imgLogo = new Image("http://93.3.238.99/uploads/logo-entier-patissier.png");
        ImageView viewLogo = new ImageView(imgLogo);
        bLogo.setStyle("-fx-background-color: #ffffff");
        bLogo.setGraphic(viewLogo);
        
        // Button Panier
        Image imgPanier = new Image("http://93.3.238.99/uploads/icon-panier.jpg");
        ImageView viewPanier = new ImageView(imgPanier);
        viewPanier.setPreserveRatio(true);
        bPanier.setStyle("-fx-background-color: #ffffff");
        bPanier.setGraphic(viewPanier);
        
        // Button Bonjour
        Image imgBonjour = new Image("http://93.3.238.99/uploads/icon-bonjour.jpg");
        ImageView viewBonjour = new ImageView(imgBonjour);
        viewBonjour.setPreserveRatio(true);
        bBonjour.setStyle("-fx-background-color: #ffffff");
        bBonjour.setGraphic(viewBonjour);
        
        // Button Rechercher
        Image imgRechercher = new Image("http://93.3.238.99/uploads/icon-loupe.png");
        ImageView viewRechercher = new ImageView(imgRechercher);
        viewRechercher.setPreserveRatio(true);
        bRecherche.setGraphic(viewRechercher);
        
        //FLOW PANE BAS
        FlowPane flowPaneLigneBas = new FlowPane();
        for(int i=0; i< bCategories.length; i++)
        {
            flowPaneLigneBas.getChildren().add(bCategories[i]);
            if(i<Panes.NOMBRE_CATEGORIES_PANE_ENTETE-1)
            {
                flowPaneLigneBas.getChildren().add(separationVerticale[i]);
            }
        }
        flowPaneLigneBas.setAlignment(Pos.TOP_CENTER);
        flowPaneLigneBas.setHgap(Panes.HGAP_LIGNE_BAS_PANE_ENTETE);
        
        //GRID PANE 
        GridPane gridPaneButton = new GridPane();
        GridPane gridPaneRechercher = new GridPane();
        
        gridPaneButton.add(bBonjour,0,0);
        gridPaneButton.add(bPanier,1,0);
        gridPaneButton.setHgap(Panes.GRID_PANE_BUTTON_HGAP_PANE_ENTETE);
        
        gridPaneRechercher.add(tBarreRecherche,0,0);
        gridPaneRechercher.add(bRecherche,1,0);
        gridPaneRechercher.setHgap(Panes.GRID_PANE_RECHERCHER_HGAP_PANE_ENTETE);
        gridPaneRechercher.setAlignment(Pos.CENTER);
        
        //FLOW PANE HAUT
        FlowPane flowPaneLigneHaut= new FlowPane();
        flowPaneLigneHaut.getChildren().addAll(bLogo, gridPaneRechercher, gridPaneButton);
        flowPaneLigneHaut.setHgap(Panes.HGAP_LIGNE_HAUT_PANE_ENTETE);
        flowPaneLigneHaut.setAlignment(Pos.CENTER);
        
        //PANE ENTETE
        this.getChildren().addAll(flowPaneLigneHaut, separationHorizontale[0],flowPaneLigneBas,separationHorizontale[1]);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(Panes.SPACING_VBOX_PANE_ENTETE);
    }

    public TextField gettBarreRecherche()
    {
        return tBarreRecherche;
    }

    public Button getbRecherche()
    {
        return bRecherche;
    }

    public Button getbPanier()
    {
        return bPanier;
    }

    public Button getbBonjour()
    {
        return bBonjour;
    }

    public Button getbLogo()
    {
        return bLogo;
    }

    public Button getbCategories(int index)
    {
        return bCategories[index];
    }
}