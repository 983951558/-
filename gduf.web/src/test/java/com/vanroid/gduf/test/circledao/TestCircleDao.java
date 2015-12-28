package com.vanroid.gduf.test.circledao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vanroid.gduf.dao.circle.CircleDao;
import com.vanroid.gduf.entity.Circle;
import com.vanroid.gduf.entity.CircleMes;
import com.vanroid.gduf.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestCircleDao {
	@Autowired
	private CircleDao circledao;
	@Test
	public void testAddNotifaction(){
		CircleMes cmes=new CircleMes();
		User u=new User();
		u.setId(1);
		cmes.setRecevier(u);
		cmes.setSender(u);
		cmes.setStatus("notread");
		Circle tid=new Circle();
		tid.setTid(48);
		cmes.setTid(tid);
		cmes.setMes("i love you");
		circledao.addNotifaction(cmes);
	}
	public CircleDao getCircledao() {
		return circledao;
	}
	public void setCircledao(CircleDao circledao) {
		this.circledao = circledao;
	}
	@Test
	public void testFindMyNotifaction(){
		List<CircleMes> list=circledao.findMyNotifaction(2);
		System.out.println(list.size());
	}
}
