package com.library.oc.library.business.impl.manager;

import java.util.List;
import javax.inject.Named;

import com.library.oc.library.business.contract.manager.UserManager;
import com.library.oc.library.model.bean.user.User;
import com.library.oc.library.model.exception.NotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCrypt;



@Named
public class UserManagerImpl extends AbstractManager implements UserManager {


    @Override
    public List<User> getListUser(Object pId) {
        { return getDaoFactory().getUserDao().readAll(); } }


    @Override
    public User getUser(Integer pId) throws NotFoundException {
        return getDaoFactory().getUserDao().read(pId);
    }


    @Override
    public User getEmailUser(String email)
    {
        User user = new User();
        try{
            user = getDaoFactory().getUserDao().findByEmail(email);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public String hashPassword(String password)
    {
        String salt = BCrypt.gensalt();
        String passwordHash = BCrypt.hashpw(password, salt);
        return passwordHash;
    }

    @Override
    public boolean validateCredentials(User user, String password)
    {
        boolean passwordChecked = false;
        if(user.getPass() == null || !user.getPass().startsWith("$2a$")){
            throw new IllegalArgumentException("Le hash n'est pas valide");
        }

        passwordChecked = BCrypt.checkpw(password, user.getPass());

        return passwordChecked;
    }

    @Override
    public Integer getNbUser() {
        return getDaoFactory().getUserDao().getNbUser();
    }


}
