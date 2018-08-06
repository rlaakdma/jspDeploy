package kr.or.ddit.student.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

public class StudentDao implements StudentDaoInf {
	
//	private static StudentDao stuDao = new StudentDao();
//	
//	public static StudentDao getInstance(){
//		if(stuDao==null){
//			stuDao = new StudentDao();
//		}
//		return stuDao;
//	}

	private SqlSessionFactory sqlSessionFactory =
			SqlMapSessionFactory.getSqlSessionFactory();
	/**
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 학생 정보를 조회한다.
	 */
	@Override
	public List<StudentVo> selectAllStudents() {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.selectAllStudents");
		session.close();
		
		return studentList;
	}
	
	/**
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param id
	 * @return
	 * Method 설명 : 학생 정보 조회
	 */
	@Override
	public StudentVo getStudent(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo studentVo = session.selectOne("student.getStudentTestById",id);
		session.close();
		return studentVo;
	}

	/**
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param studentvo
	 * @return
	 * Method 설명 : 학생 정보 조회
	 */
	@Override
	public StudentVo getStudent(StudentVo studentvo) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo studentVo = session.selectOne("student.getStudentTestByVo",studentvo);
		session.close();
		return studentVo;
	}

	/**
	 * Method : getStudentPageList
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 학생 페이지 리스트 조회
	 */
	@Override
	public List<StudentVo> getStudentPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.getStudentPageList",map);
		session.close();
		return studentList;
	}

	/**
	 * Method : getStudentTotCnt
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : PC18
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 건수
	 */
	@Override
	public int getStudentTotCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.selectOne("student.getStudentTotCnt");
		session.close();
		return cnt;
	}

	@Override
	public int StudentUpdate(StudentVo studentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int updateCnt = session.update("student.studentUpdate",studentVo);
		session.commit();
		session.close();
		return updateCnt;
	}	
}