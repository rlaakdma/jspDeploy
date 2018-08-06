package kr.or.ddit.student.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVo;

public interface StudentServiceInf {
	
	/**
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 학생 정보를 조회한다.
	 */
	List<StudentVo> selectAllStudents();
	
	/**
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param id
	 * @return
	 * Method 설명 : 학생 정보 조회
	 */
	StudentVo getStudent(int id);
	
	/**
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param studentvo
	 * @return
	 * Method 설명 : 학생 정보 조회
	 */
	StudentVo getStudent(StudentVo studentvo);
	
	/**
	 * Method : getStudentPageList
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 학생 페이지 리스트 조회
	 */
	Map<String, Object> getStudentPageList(Map<String, Integer> map);
	
	/**
	 * Method : StudentUpdate
	 * 최초작성일 : 2018. 7. 17.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param studentVo
	 * @return
	 * Method 설명 : 학생 정보 업데이트
	 */
	int StudentUpdate(StudentVo studentVo);
}