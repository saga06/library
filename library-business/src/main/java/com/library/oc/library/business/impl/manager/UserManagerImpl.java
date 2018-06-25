package com.library.oc.library.business.impl.manager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

import com.library.oc.consumer.contract.dao.DaoFactory;
import org.apache.commons.lang3.StringUtils;
import com.library.oc.library.model.recherche.RechercheUser;
import com.library.oc.library.business.contract.manager.UserManager;
import com.library.oc.library.model.bean.user.User;
import com.library.oc.library.model.exception.NotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;



@Named
public class UserManagerImpl extends AbstractManager implements UserManager {
    private DaoFactory daoFactory;



    @Override
    public User getUser(Integer pId) throws NotFoundException {

        // Je n'ai pas codé la DAO, je mets juste un code pour le cours...
        if (pId < 0) {
            throw new NotFoundException("User non trouvé : ID=" + pId);
        }
        User vUser = newUser(pId);
        return vUser;
    }



    @Override
    public User getUser(String pLogin, String pPassword) throws NotFoundException {
        boolean result = false;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());
        int  vNbrBook = vJdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM book",
                Integer.class
        );
        return vNbrBook;

        if (StringUtils.equals(pLogin, "joe") && StringUtils.equals(pPassword, "joe")) {
            return newUser(0);
        }
        throw new NotFoundException("Aucun utilisateur correspondant au couple login/password fourni.");
    }


    @Override
    public List<User> getListUser() {

        List<User> users = new ArrayList<>();
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
                String name = resultat.getString("user_name");


                // On créé un java bean et on lui définit un nom et un prénom correspond à ceux que l'on vient de récupérer dans la bdd
                User user = newUser();
                user.setNom(name);


                // on ajoute cet objet à un array (ou liste) grace à la méthode add.
                users.add(user);
                // ensuite on boucle encore et encore grace au while jusqu'à tout récupérer
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return users;

    }


    /**
     * Crée une instance d'{@link User}
     * @param user -
     * @return User
     */

    public void ajouter(User user) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            //On récupère l'objet daoFactory.getConnection(), qui représente la connexion,
            // Ainsi on n'a pas besoin de refaire la connexion systématiquement
            // On récupère la connexion qui a déjà été faite en amont dans la factory
            preparedStatement = connexion.prepareStatement("INSERT INTO users( user_surname) VALUES(?);");
            preparedStatement.setString(1, user.getNom());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User newUser(Integer pId) {
        final String[] vPrenoms = {
            "Joe", "William", "Jack", "Averell"
        };
        User vUser = new User(pId);
        vUser.setPrenom(vPrenoms[Math.abs(pId) % vPrenoms.length]);
        vUser.setNom("Dalton");
        return vUser;
    }



}
