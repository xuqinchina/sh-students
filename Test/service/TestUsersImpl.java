package service;

import entity.Users;
import org.junit.Assert;
import org.junit.Test;
import service.impl.UsersDaoImpl;

/**
 * Created by NamNicer on 2017/5/11.
 */
public class TestUsersImpl {
    @Test
    public void TestUsersLogin(){
        Users u = new Users(16,"HeyBImfrag","15001731802");
        UsersDao usersDao = new UsersDaoImpl();
        Assert.assertEquals(true,usersDao.UserLogin(u));
    }
}
