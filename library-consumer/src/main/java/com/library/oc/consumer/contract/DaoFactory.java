package com.library.oc.consumer.contract;

/*import org.example.demo.ticket.consumer.contract.dao.BugDao;
import org.example.demo.ticket.consumer.contract.dao.BugNiveauDao;
import org.example.demo.ticket.consumer.contract.dao.CommentaireDao;
import org.example.demo.ticket.consumer.contract.dao.EvolutionDao;
import org.example.demo.ticket.consumer.contract.dao.HistoriqueStatutDao;
import org.example.demo.ticket.consumer.contract.dao.ProjetDao;
import org.example.demo.ticket.consumer.contract.dao.TicketDao;
import org.example.demo.ticket.consumer.contract.dao.TicketStatutDao;
import org.example.demo.ticket.consumer.contract.dao.VersionDao;*/

import com.library.oc.consumer.contract.dao.UserDao;
import com.library.oc.consumer.contract.dao.BookDao;
import com.library.oc.consumer.impl.dao.BookStatutDao;


public interface DaoFactory {

   /* //----- PROJET -----
    ProjetDao getProjetDao();
    void setProjetDao(ProjetDao pProjetDao);

    //----- VERSION -----
    VersionDao getVersionDao();
    void setVersionDao(VersionDao pVersionDao);



    //----- BUG -----
    BugDao getBugDao();
    void setBugDao(BugDao pBugDao);

    //----- BUGNIVEAU -----
    BugNiveauDao getBugNiveauDao();
    void setBugNiveauDao(BugNiveauDao pBugNiveauDao);

    //----- COMMENTAIRE -----
    CommentaireDao getCommentaireDao();
    void setCommentaireDao(CommentaireDao pCommentaireDao);

    //----- EVOLUTION -----
    EvolutionDao getEvolutionDao();
    void setEvolutionDao(EvolutionDao pEvolutionDao);

    //----- HISTORIQUESTATUT -----
    HistoriqueStatutDao getHistoriqueStatutDao();
    void setHistoriqueStatutDao(HistoriqueStatutDao pHistoriqueStatutDao);
    */

    BookDao getBookDao();
    void setBookDao(BookDao pBookDao);

    BookStatutDao getBookStatutDao();
    void setBookStatutDao(BookStatutDao pBookStatutDao);



    //----- UTILISATEUR -----
    UserDao getUserDao();
    void setUserDao(UserDao pBookDao);

    //----- Book -----


}
