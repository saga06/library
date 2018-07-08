package com.library.oc.library.business.impl.manager;

import java.util.List;
import javax.inject.Named;

import com.library.oc.library.business.contract.manager.UserManager;
import com.library.oc.library.model.bean.user.User;
import com.library.oc.library.model.exception.NotFoundException;


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
    public Integer getNbUser() {
        return getDaoFactory().getUserDao().getNbUser();
    }


}
