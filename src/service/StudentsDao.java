package service;

import entity.Students;

import java.util.List;

/**
 * Created by NamNicer on 2017/5/11.
 */
public interface StudentsDao {
    //查询所有学生资料
     public  List<Students> queryAllStudents();
    //根据学生编号查找学生资料
    public Students queryStudentsBySid(String sid);
    //添加学生资料
    public boolean addStudents(Students s);
    //修改学生资料
    public boolean updateStudents(Students s);
    //删除学生资料
    public boolean deleteStudents(String sid);
    //模糊查找某一个学生
    public List<Students> selectStudents(String sname);
}
