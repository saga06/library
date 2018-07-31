package com.library.oc.consumer.impl.dao;


        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.util.List;

        import javax.inject.Inject;
        import javax.inject.Named;

        import com.library.oc.consumer.contract.dao.UserDao;
        import com.library.oc.consumer.impl.rowmapper.UserRM;
        import com.library.oc.library.model.bean.user.User;
        import org.springframework.dao.EmptyResultDataAccessException;
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
        String vSQL = "SELECT * FROM users WHERE user_id="+id;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<User> listUser = jdbcTemplate.query(vSQL, userRM);
        User user = listUser.get(0);

        return user;
    }

/*@Override
    public User validate(String login, String password) {

    boolean status=false;
    JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

    PreparedStatement ps=
            ("select * from users where user_email=? and user_pass=?");

    List<User> listUser = jdbcTemplate.query(ps, userRM);

    PreparedStatement ps= con.prepareStatement(
            "select * from users where user_email=? and user_pass=?");
    ps.setString(1,login);
    ps.setString(2,password);

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

    ResultSet rs = jdbcTemplate.query(ps, userRM);;
    status=rs.next();
}catch(Exception e){e.printStackTrace();}
 return status;*/


/*



    User user = jdbcTemplate.query(vSQL, userRM);
        User vUser = listUser.get(0);

        return vUser;
    }
*/


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
    public User findByEmail(String email) {
        String vSQL = "SELECT * FROM users WHERE user_email='" + email + "'";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        List<User> listUser = jdbcTemplate.query(vSQL, userRM);
        User user = listUser.get(0);

        return user;
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
