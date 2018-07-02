package com.library.oc.consumer.impl.dao;


import com.library.oc.consumer.contract.dao.DaoFactory;
import com.library.oc.consumer.contract.dao.UserDao;

import javax.inject.Inject;
import javax.inject.Named;

@Named("daoFactory")
public class DaoFactoryImpl implements DaoFactory {

 /*   @Inject
    ProjetDao projetDaoImpl;
    @Inject
    VersionDao versionDaoImpl;
    @Inject
    BugDao bugDaoImpl;
    @Inject
    BugNiveauDao bugNiveauDaoImpl;
    @Inject
    CommentaireDao commentaireDaoImpl;
    @Inject
    EvolutionDao evolutionDaoImpl;
    @Inject
    HistoriqueStatutDao historiqueStatutDaoImpl;
    @Inject
    TicketDao ticketDaoImpl;
    @Inject
    TicketStatutDao ticketStatutDaoImpl;*/
    @Inject
     UserDao userDaoImpl;

    /*    //----- PROJET -----
        @Override
        public void setProjetDao(ProjetDao pProjetDao) {
            this.projetDaoImpl = pProjetDao;
        }
        @Override
        public ProjetDao getProjetDao() {
            return projetDaoImpl;
        }
        //----- VERSION -----
        @Override
        public void setVersionDao(VersionDao pVersionDao) {
            this.versionDaoImpl = pVersionDao;
        }
        @Override
        public VersionDao getVersionDao() {
            return versionDaoImpl;
        }*/



      /*  //----- BUG -----
        @Override
        public void setBugDao(BugDao pBugDao) {
            this.bugDaoImpl = pBugDao;
        }
        @Override
        public BugDao getBugDao() {
            return bugDaoImpl;
        }
        //----- BUG NIVEAU -----
        @Override
        public void setBugNiveauDao(BugNiveauDao pBugNiveauDao) {
            this.bugNiveauDaoImpl = pBugNiveauDao;
        }
        @Override
        public BugNiveauDao getBugNiveauDao() {
            return bugNiveauDaoImpl;
        }
        //----- COMMENTAIRE -----
        @Override
        public void setCommentaireDao(CommentaireDao pCommentaireDao) {
            this.commentaireDaoImpl = pCommentaireDao;
        }
        @Override
        public CommentaireDao getCommentaireDao() {
            return commentaireDaoImpl;
        }
        //----- EVOLUTION -----
        @Override
        public void setEvolutionDao(EvolutionDao pEvolutionDao) {
            this.evolutionDaoImpl = pEvolutionDao;
        }
        @Override
        public EvolutionDao getEvolutionDao() {
            return evolutionDaoImpl;
        }
        //----- HISTORIQUE STATUT -----
        @Override
        public void setHistoriqueStatutDao(HistoriqueStatutDao pHistoriqueStatutDao) {
            this.historiqueStatutDaoImpl = pHistoriqueStatutDao;
        }
        @Override
        public HistoriqueStatutDao getHistoriqueStatutDao() {
            return historiqueStatutDaoImpl;
        }
        //----- TICKET -----
        @Override
        public void setTicketDao(TicketDao pTicketDao) {
            this.ticketDaoImpl = pTicketDao;
        }
        @Override
        public TicketDao getTicketDao() {
            return ticketDaoImpl;
        }
        //----- TICKET STATUT -----
        @Override
        public void setTicketStatutDao(TicketStatutDao pTicketStatutDao) {
            this.ticketStatutDaoImpl = pTicketStatutDao;
        }
        @Override
        public TicketStatutDao getTicketStatutDao() {
            return ticketStatutDaoImpl;
        }*/



        //----- UTLISATEUR -----
        @Override
        public UserDao getUserDao() {
            return userDaoImpl;
        }


        @Override
        public void setUserDao(UserDao pUserDao) {
            userDaoImpl = pUserDao;

        }
}

