package com.Test.StudentRepositoryTest;

import org.springframework.beans.factory.annotation.Autowired;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setup() {
		StudentEntity studentEntity = new StudentEntity(44, "abc", 9999, "dlh");
		entityManager.persist(studentEntity);
	}

	@Test
	public void findByStudentId() {
		StudentEntity student = studentRepository.findById(44).get();
		assertEquals("abc", student.getName());
	}

}
Footer
