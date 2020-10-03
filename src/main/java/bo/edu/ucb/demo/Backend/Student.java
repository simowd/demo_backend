package bo.edu.ucb.demo.Backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class Student implements IPrintDataById{
    public String studentId;
    public String fullName;
    public JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Student() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + this.studentId +
                ", fullName='" + this.fullName + '\'' +
                '}';
    }

    public Student(String studentId, JdbcTemplate jdbcTemplate) {
        this.studentId = studentId;
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getData() {
        List result = jdbcTemplate.query("SELECT * FROM student WHERE student_id = " + this.studentId + ";",
                new Object[]{}, (resultSet, i) -> {
                    Student student = new Student();
                    student.setStudentId(resultSet.getString(1));
                    student.setFullName(resultSet.getString(2));
                    return student;
                });
        if(!result.isEmpty()){
            Student data = (Student) result.get(0);
            return data.toString();
        }
        else{
            return "¡ID no existe!";
        }

    }
}
