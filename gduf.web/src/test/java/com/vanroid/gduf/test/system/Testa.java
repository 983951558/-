package com.vanroid.gduf.test.system;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vanroid.gduf.dao.jwc.CourseDao;
import com.vanroid.gduf.entity.Course;
import com.vanroid.gduf.service.jwc.CourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Testa {
	@Autowired
	private CourseService courseService;
	@Autowired
	private CourseDao courseDao;
	@org.junit.Test
	public void test() throws ClientProtocolException, IOException {
		Course course = new Course("1", "1", 1);
		Course course2=courseService.getCourseInfo(course, null);
		courseDao.queryExistInDb(course);
	}
}
