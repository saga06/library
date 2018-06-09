package com.library.oc.library.webapp.action;


        import java.util.List;
        import javax.inject.Inject;

        import com.opensymphony.xwork2.ActionSupport;
        import com.library.oc.library.business.contract.ManagerFactory;
        import com.library.oc.library.model.bean.book.Book;


/**
 * Action de démo pour les appels AJAX
 */
public class DemoAjaxAction extends ActionSupport {

    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;

    // ----- Eléments en sortie
    private List<Book> listBook;


    // ==================== Getters/Setters ====================
    public List<Book> getListBook() {
        return listBook;
    }


    // ==================== Méthodes ====================
    public String execute() {
        return ActionSupport.SUCCESS;
    }


    /**
     * Action "AJAX" renvoyant la liste des books
     * @return success
     */
    public String doAjaxGetListBook() {
        listBook = managerFactory.getBookManager().getListBook();
        return ActionSupport.SUCCESS;
    }
}