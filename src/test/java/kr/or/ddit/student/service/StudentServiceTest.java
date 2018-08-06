package kr.or.ddit.student.service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;

public class StudentServiceTest {
	
	// @Before --> @Test --> @After
	
	// 테스트 메소드 안에 중복되는 내용 : StudentDao 구현체에 대한 생성 로직
	// --> @Before 어노테이션이 붙은 setup 메소드에 위임
	// 모든 테스트 메서드에서 StudentDao 객체를 참조할 수 있게끔 클래스 변수로 생성할 필요가 있고
	// 클래스 변수를 setup메서드에서 초기화하는 로직이 필요
	// 테스트 메소드에서 StudentDao를 생성하는 로직은 삭제
	
	public StudentServiceInf studentService;
	
	@Before
	public void setup(){
		studentService = new StudentService();
	}

	@Test
	public void selectAllStudents() {
		/***Given***/
		/***When***/
		List<StudentVo> studentList = studentService.selectAllStudents();
		for(StudentVo vo : studentList)
			System.out.println(vo);

		/***Then***/
		assertEquals(25, studentList.size());
	}
	
	@Test
	public void getStudentTestById(){
		/***Given***/
		int id = 1;

		/***When***/
		StudentVo studentVo = studentService.getStudent(id);
		System.out.println(studentVo);

		/***Then***/
		assertEquals(id, studentVo.getId());
		assertEquals("김마음", studentVo.getName());		
	}
	
	@Test
	public void getStudentTestByVo(){
		/***Given***/
		StudentVo paramVo = new StudentVo();
		int id = 1;
		paramVo.setId(id);

		/***When***/
		StudentVo studentVo = studentService.getStudent(paramVo);
		System.out.println(studentVo);
		
		/***Then***/
		assertEquals(id, studentVo.getId());
		assertEquals("김마음", studentVo.getName());			
	}
	
	/**
	 * Method : getStudentPageList
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC18
	 * 변경이력 :
	 * Method 설명 : 학생 페이지 리스트 조회
	 */
	@Test
	public void getStudentPageList(){
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page",2);
		map.put("pageSize",10);
		
		/***When***/
		Map<String, Object> resultMap = studentService.getStudentPageList(map);
		
		// 학생 페이지 리스트
		List<StudentVo> pageList = (List<StudentVo>) resultMap.get("pageList");

		// 학생 전체 건수
		int totCnt = (int) resultMap.get("totCnt");

		/***Then***/
		assertEquals(10, pageList.size()); // 학생 페이지 리스트 건수에 대한 검증
		assertEquals(25, totCnt);		   // 학생 전체 건수에 대한 검증
	}
	
	/**
	 * Method : calculatePageNavi
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC18
	 * 변경이력 :
	 * Method 설명 : 전체 건수를 인자로 페이지 네비게이션 사이즈를 구하는 테스트
	 */
	@Test
	public void calculatePageNavi(){
		/***Given***/
		int totCnt = 25;
		int pageSize = 10;
		
		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지
		
		if (mod > 0)
			cnt++;		

		/***When***/
		double naviSize = (totCnt/pageSize);
		System.out.println(Math.ceil(2.5d));
		System.out.println(Math.ceil((totCnt / pageSize)));
		System.out.println(Math.floor((totCnt / pageSize)));
		/***Then***/
	}
	
	@Test
	public void studentUpdate(){
		/***Given***/
		StudentVo studentVo = new StudentVo();
		studentVo.setId(2);
		studentVo.setName("강병관");
		studentVo.setAddr1("대전광역시 중구 중앙로 76");
		studentVo.setAddr2("영민빌딩 2층 대덕인재개발원");
		studentVo.setZipcd("34940");
		studentVo.setPic("sally.png");
		studentVo.setPicpath("D:\\A_TeachingMaterial\\7.JspSpring\\fileUpload");
		studentVo.setPicname("8a467c65-93a3-4b89-9a14-6e593cb18f0f");

		/***When***/
		int updateCnt = studentService.StudentUpdate(studentVo);

		/***Then***/
		assertEquals(1,updateCnt);
	}
}