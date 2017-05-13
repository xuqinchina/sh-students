package entity;

import java.sql.Date;

/**
 * Created by NamNicer on 2017/5/11.
 */
public class Students {
    private String sid;
    private String sname;
    private String gender;
    private Date birthday;
    private String address;

    public Students() {
    }

    public Students(String sid, String sname, String gender, Date birthday, String address) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Students students = (Students) o;

        if (sid != null ? !sid.equals(students.sid) : students.sid != null) return false;
        if (sname != null ? !sname.equals(students.sname) : students.sname != null) return false;
        if (gender != null ? !gender.equals(students.gender) : students.gender != null) return false;
        if (birthday != null ? !birthday.equals(students.birthday) : students.birthday != null) return false;
        if (address != null ? !address.equals(students.address) : students.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (sname != null ? sname.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Students{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }
}
