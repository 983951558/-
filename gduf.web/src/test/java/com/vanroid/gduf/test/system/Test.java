package com.vanroid.gduf.test.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.vanroid.gduf.entity.Circle;
import com.vanroid.gduf.entity.ImagePath;


public class Test {
	@org.junit.Test
	public void test() {
		ApplicationContext act = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HibernateTemplate ht = (HibernateTemplate) act
				.getBean("hibernateTemplate");
		//Circle c=new Circle();c.setTid(27);
		Circle circle=ht.get(Circle.class, 27);
		List<ImagePath> list=circle.getImages();
		System.out.println(list.size());
//		CircleDao cd=(CircleDao) act.getBean("circleDao");
//		List<Circle> list=cd.queryCircles(0, 5);
//		for(Circle c:list){
//			System.out.println(c.getTid());
//		}
		
		//Circle c=ht.get(Circle.class, 4);
	//	System.out.println(c.getImages().size());
		
	}
}
