package com.vanroid.gduf.dao.impl;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vanroid.gduf.dao.impl.jwc.CourseDaoImpl;
import com.vanroid.gduf.entity.ClassBean;
import com.vanroid.gduf.entity.Course;
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")*/
public class Testa {
	/*@Autowired
	private CourseDaoImpl cdi;*/
	@Test
	public void test() {
		ClassPathXmlApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
		CourseDaoImpl cdi=(CourseDaoImpl) act.getBean("courseDao");
		Course c=new Course();
		Set<ClassBean> classes=new HashSet<ClassBean>();
		ClassBean c1=new ClassBean();
		c1.setTitle("北教");
		ClassBean c2=new ClassBean();
		c1.setTitle("7栋");
		classes.add(c1);
		classes.add(c2);
		
		c.setXq(1);
		c.setClasses(classes);
		cdi.add(c);	
	}
	/*public CourseDaoImpl getCdi() {
		return cdi;
	}
	public void setCdi(CourseDaoImpl cdi) {
		this.cdi = cdi;
	}
	*/
}
