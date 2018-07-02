package com.library.oc.consumer.impl.dao;


        import java.util.List;

        import javax.inject.Inject;
        import javax.inject.Named;

        import com.library.oc.consumer.contract.dao.UserDao;
        import com.library.oc.consumer.rowmapper.UserRM;
        import com.library.oc.library.model.bean.user.User;
        import org.springframework.jdbc.core.JdbcTemplate;

@Named
public class UserDaoImpl extends AbstractDao implements UserDao {


    @Inject
    UserRM userRM;


    @Override
    public boolean create(User obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public User read(int id) {
        String vSQL = "SELECT * FROM users WHERE id="+id;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<User> listUser = jdbcTemplate.query(vSQL, userRM);
        User user = listUser.get(0);

        return user;
    }

    @Override
    public User read(String code) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> readAll() {
        String vSQL = "SELECT * FROM users";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<User> listUser = jdbcTemplate.query(vSQL, userRM);

        return listUser;
    }

    @Override
    public List<User> readAll(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(User obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(User obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Integer getNbUser() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbrUser = vJdbcTemplate.queryForObject( "SELECT COUNT(*) FROM users", Integer.class);
        return vNbrUser;
    }

}
