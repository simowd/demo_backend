package bo.edu.ucb.demo.Backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

public class Student implements IPrintDataById{
    public Integer studentId;
    public String fullName;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", fullName='" + fullName + '\'' +
                '}';
    }
    public String getData(int studentId) {
        List result = jdbcTemplate.query("SELECT * FROM student WHERE student_id = 10;",
                new Object[]{}, (resultSet, i) -> {
                    Student student = new Student();
                    student.studentId =  resultSet.getInt(1);
                    student.fullName =  resultSet.getString(2);
                    return student;
                });
        Student data = (Student) result.get(0);
        String dataConverted = data.toString();
        return dataConverted;
    }
}
