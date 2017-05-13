package action;

import com.opensymphony.xwork2.ModelDriven;
import entity.Users;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages;
import org.apache.struts2.interceptor.validation.SkipValidation;
import service.UsersDao;
import service.impl.UsersDaoImpl;

/**
 * Created by NamNicer on 2017/5/11.
 */
public class UsersAction extends SuperAction implements ModelDriven<Users> {
    private static  final long serialVersionUID=1L;
    private  Users users = new Users();
    //用户登陆
    public String login() {
        UsersDao usersDao = new UsersDaoImpl();//体现多态
        if (usersDao.UserLogin(users)) {
            //在session中保存登陆成功的用户名
            session.setAttribute("loginUserName", users.getUsername());
            return "login_success";
        } else {
            return "login_fail";
        }
    }

    @SkipValidation
    //用户注销
    public String logout(){
        if(session.getAttribute("loginUserName")!=null){
            session.removeAttribute("loginUserName");
        }
        return "logout_success";
    }

    @Override
    //表单验证
    public void validate() {
        if("".equals(users.getUsername().trim())||users.getUsername()==null){

            this.addFieldError("usernameError","用户名不能为空！");
        }
        if(users.getPassword().length()<6||users.getPassword()==null){

            this.addFieldError("passwordError","密码长度不足六位！");
        }
    }
    @Override
    public Users getModel() {
        return this.users;
    }
}
