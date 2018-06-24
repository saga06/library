package com.library.oc.library.business.impl.manager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

import com.library.oc.consumer.contract.dao.DaoFactory;
import org.apache.commons.lang3.StringUtils;

import com.library.oc.library.business.contract.manager.AuthorManager;
import com.library.oc.library.model.bean.author.Author;
import com.library.oc.library.model.exception.NotFoundException;


@Named
public class AuthorManagerImpl extends AbstractManager implements AuthorManager {
    private DaoFactory daoFactory;



    @Override
    public Author getAuthor(Integer pId) throws NotFoundException {

        // Je n'ai pas codé la DAO, je mets juste un code pour le cours...
        if (pId < 0) {
            throw new NotFoundException("Author non trouvé : ID=" + pId);
        }
        Author vAuthor = newAuthor(pId);
        return vAuthor;
    }


    @Override
    public Author getAuthor(String pLogin, String pPassword) throws NotFoundException {
        if (StringUtils.equals(pLogin, "joe") && StringUtils.equals(pPassword, "joe")) {
            return newAuthor(0);
        }
        throw new NotFoundException("Aucun author correspondant au couple login/password fourni.");
    }


    @Override
    public List<Author> getListAuthor() {

        List<Author> authors = new ArrayList<Author>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT author_name FROM author;");


            // Récupération des données
            // On récupère un résultat brut de la bdd difficilement manipulable, donc on en extrait les donnés pour les stocker de manière plus propre et facile à manipuler grace au while
            while (resultat.next()) {
                String name = resultat.getString("author_name");


                // On créé un java bean et on lui définit un nom et un prénom correspond à ceux que l'on vient de récupérer dans la bdd
                Author author = new Author();
                author.setNom(name);


                // on ajoute cet objet à un array (ou liste) grace à la méthode add.
                authors.add(author);
                // ensuite on boucle encore et encore grace au while jusqu'à tout récupérer
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return authors;

    }


    /**
     * Crée une instance d'{@link Author}
     * @param pId -
     * @return Author
     */

    public void ajouter(Author author) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            //On récupère l'objet daoFactory.getConnection(), qui représente la connexion,
            // Ainsi on n'a pas besoin de refaire la connexion systématiquement
            // On récupère la connexion qui a déjà été faite en amont dans la factory
            preparedStatement = connexion.prepareStatement("INSERT INTO author( author_name) VALUES(?);");
            preparedStatement.setString(1, author.getNom());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Author newAuthor(Integer pId) {
        final String[] vPrenoms = {
            "Joe", "William", "Jack", "Averell"
        };
        Author vAuthor = new Author(pId);
        vAuthor.setPrenom(vPrenoms[Math.abs(pId) % vPrenoms.length]);
        vAuthor.setNom("Dalton");
        return vAuthor;
    }

}
