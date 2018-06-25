package com.library.oc.library.webapp.action;

import com.library.oc.library.business.contract.ManagerFactory;
import com.library.oc.library.model.bean.user.User;
import com.library.oc.library.model.exception.NotFoundException;
import com.library.oc.library.webapp.WebappHelper;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Action de gestion de la connexion/déconnexion d'un user
 */
public class LoginAction extends ActionSupport implements SessionAware, ServletRequestAware {


    // ==================== Attributs ====================
    // ----- Paramètres en entrée
    private String login;
    private String password;

    // ----- Eléments Struts
    private Map<String,Object> session;
    private HttpServletRequest servletRequest;

    @Inject
    private ManagerFactory managerFactory;


    // ==================== Getters/Setters ====================
    public String getLogin() {
        return login;
    }
    public void setLogin(String pLogin) {
        login = pLogin;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String pPassword) {
        password = pPassword;
    }


    // ==================== Méthodes ====================
    /**
     * Action permettant la connexion d'un user
     * @return input / success
     */
    public String doLogin() {
        String vResult = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(login, password)) {
            try {
                User vUser
                        = managerFactory.getUserManager()
                        .getUser(login, password);

                // Ajout de l'user en session
                this.session.put("user", vUser);

                vResult = ActionSupport.SUCCESS;
            } catch (NotFoundException pEx) {
                this.addActionError("Identifiant ou mot de passe invalide !");
            }
        }
        return vResult;
    }


    /**
     * Action de déconnexion d'un user
     * @return success
     */
    public String doLogout() {
        // Suppression de l'user en session
        this.servletRequest.getSession().invalidate();

        return ActionSupport.SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;

    }

    @Override
    public void setServletRequest(HttpServletRequest pRequest) {
        this.servletRequest = pRequest;
    }

}