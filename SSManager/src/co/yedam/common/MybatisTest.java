package co.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.DataSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.StudentVO;

public class MybatisTest {
	public static void main(String[] args) {
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession sqlSession = factory.openSession(true); // SqlSession 객체를 얻는 방법.
		// 매퍼인터페이스의 구현. => 구현클래스.
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		StudentVO student = new StudentVO();
		student.setStdNo("S2024-08");
		student.setStdName("김부식");
		student.setStdPhone("010-8888-8888");

		int cnt = mapper.deleteStudent(student.getStdNo());
		System.out.println("처리된 건수: " + cnt);
//		sqlSession.commit(); // 커밋을 하는것이 귀찮다면....

		List<StudentVO> list = mapper.studentList();
		for (StudentVO svo : list) {
			System.out.println(svo);
		}
		System.out.println("OK");
	}
}
