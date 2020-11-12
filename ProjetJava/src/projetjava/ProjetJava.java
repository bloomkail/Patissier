/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import java.awt.Image;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import java.lang.Object;
import org.bouncycastle.util.encoders.Hex;

/**
 *
 * @author Benjamin
 */
public class ProjetJava extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button nom = new Button();
        Button prenom = new Button();
        
        nom.setText("Nom");
        nom.setOnAction((ActionEvent event) -> {
            System.out.println("\n Nom : ");
            getBDDNom();
        });
        
        prenom.setText("Prenom");
        prenom.setOnAction((ActionEvent event) -> {
            System.out.println("\n Prenom : ");
            getBDDPrenom();
        });
        
        FlowPane root = new FlowPane();
        
        root.getChildren().add(nom);
        root.getChildren().add(prenom);
       
        
        Scene scene = new Scene(root, 500, 250);
        //scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        
        BackgroundImage myBI= new BackgroundImage(new javafx.scene.image.Image("http://93.3.238.99/index.jpg"),
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);
        //then you set to your node
        root.setBackground(new Background(myBI));
        //then you set to your node
        root.setBackground(new Background(myBI));
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBBConnexion();
        
         
        Utilisateur test = new Utilisateur("benji@test3.com");
        UtilisateurDAO DAO = new UtilisateurDAO();
        System.out.println(test.toString());
        test=DAO.create(test,"Truc");
        System.out.println(test.toString());
        test.setNom("Arnaud");
        test.setPrenom("Mathias");
        test = DAO.update(test);
        
        System.out.println(test.toString());
        
        launch(args);
        
       
        
       
    }
    
    public static void DBBConnexion() 
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://93.3.238.99:3307/patissier","PROJET","Azertyu12!");
            System.out.println("SUCESS");
            con.close();
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
            Logger.getLogger(ProjetJava.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fail class not found ");
        } catch (SQLException ex) {
            Logger.getLogger(ProjetJava.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fail SQL");
        }
    }
    
    public static void getBDDNom()
    {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://93.3.238.99:3307/patissier","PROJET","Azertyu12!");
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM utilisateurs");
            while (res.next()) 
            {
                String name = res.getString("nom");
                System.out.println(name);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetJava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void getBDDPrenom()
    {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://93.3.238.99:3307/patissier","PROJET","Azertyu12!");
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT nom,prenom FROM utilisateurs");
            while (res.next()) 
            {
                String name = res.getString("prenom");
                System.out.println(name);
                
                
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetJava.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}