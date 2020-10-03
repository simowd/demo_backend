package bo.edu.ucb.demo.Backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * http://localhost:8080/mi_ruta/
 *
 * http://localhost:8080/mi_ruta/dos
 * HOLA MUNDO
 * Esta clase no tiene HighCohesion, porque mezcla lógica de presetación API con Acceso a Datos.
 * Esta clase no tiene Loose Coupling. Por ende esta fuertemente acoplada.
 *
 */

@RestController
@RequestMapping("/mi_ruta")
public class HelloWorld {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello() {
        return "HOLA MUNDO";
    }

    @RequestMapping(value = "/dos", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String helloTwo() {
        return "DOS HOLA";
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String findStudent()
    {
        IPrintDataById student = new Student("10", jdbcTemplate);
        return student.getData();
    }
    @GetMapping("/students/{id}")
    public String getEmployeesById(@PathVariable String id){
        IPrintDataById student = new Student(id,jdbcTemplate);
        return student.getData();
    }
}
