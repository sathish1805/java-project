package hibernateDemo.hibernateCRUD;

import org.hibernate.mapping.List;

import net.first.hibernate.dao.StudentDao;
import net.first.hibernate.model.Student;

public class App 
{
    public static void main( String[] args )
    {
    	StudentDao studentDao = new StudentDao();
		Student student = new Student( "Amrin", "Fadatare", "Amrinfadatare@javaguides.com");
		studentDao.saveStudent(student);
		
		studentDao.insertStudent();
		
		// update student
		Student student1 = new Student( "aysha", "Fadatare", "armanfadatare@javaguides.com");
		studentDao.updateStudent(student1);
		
		// get students
		List<Student> students = studentDao.getStudents();
		students.forEach(s -> System.out.println(s.getFirstName()));
		
		// get single student
		Student student2 = studentDao.getStudent(1);
		System.out.println(student2.getFirstName());
		
		// delete student
		studentDao.deleteStudent(1);
	//studentDao.deleteStudent(Student.getId());
	
    }
}
