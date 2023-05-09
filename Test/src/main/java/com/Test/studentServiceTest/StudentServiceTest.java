package com.Test.studentServiceTest;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class StudentServiceTest {

	@Autowired
	StudentService studentService;
	
	@MockBean
	private StudentRepository studentRepository;
	
	@BeforeEach
	void setup() {
		Optional<StudentEntity> student = Optional.of(new StudentEntity(1, "abc", 100, "dlh"));
		Mockito.when(studentRepository.findById(1)).thenReturn(student);
	}

	@Test
	public void testGetStudentById() {
		String student_name = "abc";
		StudentEntity student = studentService.getStudentById(1);
		assertEquals(student_name, student.getName());
	}

}
