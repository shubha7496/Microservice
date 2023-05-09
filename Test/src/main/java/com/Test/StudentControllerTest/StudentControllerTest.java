package com.Test.StudentControllerTest;

import org.springframework.beans.factory.annotation.Autowired;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

	private StudentEntity student;

	@BeforeEach
	void setup() {
		student = new StudentEntity(1, "abc", 101, "hyd");
	}

	@Test
	void testSaveStudent() throws Exception {
		StudentEntity studentEntity = new StudentEntity(1, "abc", 101, "hyd");
		Mockito.when(studentService.addStudent(studentEntity)).thenReturn(student);
		mockMvc.perform(MockMvcRequestBuilders.post("/student/")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n" + 
						"  \"id\": 1,\r\n" + 
						"  \"name\": \"abc\",\r\n" + 
						"  \"rollNo\": 101,\r\n" + 
						"  \"address\": \"hyd\"\r\n" + 
						"}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
