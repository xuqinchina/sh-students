package action;

import com.opensymphony.xwork2.ModelDriven;
import entity.Students;
import service.StudentsDao;
import service.impl.StudentsDaoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by NamNicer on 2017/5/11.
 */
public class StudentsAction extends SuperAction implements ModelDriven<Students>{
    private static  final long serialVersionUID=1L;
    private  Students students = new Students();
    //查询所有学生
    public String query(){
        StudentsDao studentsDao = new StudentsDaoImpl();
        List<Students> list =studentsDao.queryAllStudents();
        //放入session里面
        if(list!=null&&list.size()>0){
            session.setAttribute("students_list",list);
        }
            return "query_success";
    }
    //删除学生
    public String delete(){
        StudentsDao studentsDao = new StudentsDaoImpl();
        String sid =request.getParameter("sid");
        studentsDao.deleteStudents(sid);
        return "delete_success";
    }
    //添加学生
    public String add() {
        /*String birthday = request.getParameter("birthday");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=simpleDateFormat.parse(birthday);*/
        StudentsDao  studentsDao = new StudentsDaoImpl();
        studentsDao.addStudents(students);
        return "add_success";
    }
    //修改学生资料
    public String modify(){
        StudentsDao studentsDao = new StudentsDaoImpl();
        String sid = request.getParameter("sid");
        Students s = studentsDao.queryStudentsBySid(sid);
        session.setAttribute("modify_students",s);
        return "modify_success";
    }
    public String save(){
        StudentsDao studentsDao = new StudentsDaoImpl();
        studentsDao.updateStudents(students);
        return "save_success";
    }
    public String select(){
        String sname = request.getParameter("sname");
        StudentsDao studentsDao = new StudentsDaoImpl();
        studentsDao.selectStudents(sname);
        List<Students> list = studentsDao.selectStudents(sname);
        //放入session里面
        if(list!=null&&list.size()>0){
            session.setAttribute("select_list",list);
        }
        return "select_success";
    }

    @Override
    public Students getModel() {
        return this.students;//利用模型驱动获取对象
    }
}
