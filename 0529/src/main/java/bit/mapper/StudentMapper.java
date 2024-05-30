package bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import bit.entity.Student;


@Mapper
public interface StudentMapper {
	
	List<Student> getStudentList();
	
	Student getStudentById(int idx);
	
    public void studentDelete(int idx);
    
    public void studentUpdate(Student stu);
    
    public void addStudent(Student student);
    
    public List<Student> searchStudentByName(String name);

}
