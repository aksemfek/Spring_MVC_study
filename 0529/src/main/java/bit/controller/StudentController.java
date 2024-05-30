package bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bit.entity.Student;
import bit.mapper.StudentMapper;


@RequestMapping("/main")
@RestController
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/list")
    public List<Student> mainPage() {
        List<Student> students = studentMapper.getStudentList();
        return students ;
    }
    
    @GetMapping("/student/{idx}")
    public Student getStudentDetails(@PathVariable("idx") int idx) {
        return studentMapper.getStudentById(idx);
    }
    
    @DeleteMapping("/delete/{idx}")
	public void studentDelete(@PathVariable("idx") int idx) {
    	studentMapper.studentDelete(idx);
	}
    
    @PutMapping("/update/{idx}")
    public void studentUpdate(@RequestBody Student stu) {
        studentMapper.studentUpdate(stu);
    }
    
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        try {
            studentMapper.addStudent(student);
            return "학생 정보가 성공적으로 등록되었습니다.";
        } catch (Exception e) {
            return "학생 정보 등록 중 오류가 발생했습니다.";
        }
    }
    
    @GetMapping("/search/{name}")
    public List<Student> searchStudent(@PathVariable("name") String name) {
        return studentMapper.searchStudentByName(name);
    }


}
