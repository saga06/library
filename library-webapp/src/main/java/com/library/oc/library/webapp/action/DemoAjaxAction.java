package com.library.oc.library.webapp.action;


        import java.util.List;
        import javax.inject.Inject;

        import com.opensymphony.xwork2.ActionSupport;
        import com.library.oc.library.business.contract.ManagerFactory;
        import com.library.oc.library.model.bean.projet.Projet;


/**
 * Action de démo pour les appels AJAX
 */
public class DemoAjaxAction extends ActionSupport {

    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;

    // ----- Eléments en sortie
    private List<Projet> listProjet;


    // ==================== Getters/Setters ====================
    public List<Projet> getListProjet() {
        return listProjet;
    }


    // ==================== Méthodes ====================
    public String execute() {
        return ActionSupport.SUCCESS;
    }


    /**
     * Action "AJAX" renvoyant la liste des projets
     * @return success
     */
    public String doAjaxGetListProjet() {
        listProjet = managerFactory.getProjetManager().getListProjet();
        return ActionSupport.SUCCESS;
    }
}