/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.DAO.utilisateur.Utilisateur;
import MODEL.DAO.utilisateur.UtilisateurDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Benjamin
 */
public class SubmitCreationCompte  implements EventHandler<ActionEvent>
{

    private View fenetre;
    private UtilisateurDAO DAO;
    private Utilisateur user;
    public SubmitCreationCompte(View fenetre, UtilisateurDAO DAO)
    {
        super();
        this.fenetre=fenetre;
        this.DAO = DAO;
        this.user=new Utilisateur();
    }

    @Override
    public void handle(ActionEvent event) 
    {
        
        if(event.getSource()== fenetre.getSubmitNouveauCompte())
        {
            System.out.println(fenetre.getUtilisateur().getText());
            System.out.println(fenetre.getMotDePasse().getText());

            this.user.setEmail(fenetre.getUtilisateur().getText());

            fenetre.setUser(DAO.create(user, fenetre.getMotDePasse().getText()));
            System.out.println("NEW User");
            System.out.println(fenetre.getUser().toString());

            fenetre.getPrimaryStage().setScene(fenetre.getInitStage());
        }
    }
}