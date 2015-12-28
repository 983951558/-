

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vanroid.gduf.dao.circle.CommentDao;
import com.vanroid.gduf.entity.Circle;
import com.vanroid.gduf.entity.Comment;
import com.vanroid.gduf.entity.ImagePath;
import com.vanroid.gduf.entity.User;
import com.vanroid.gduf.service.circle.CircleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestCircleService {
	Circle c;

	public TestCircleService() {
		// TODO 自动生成的构造函数存根
		c = new Circle();
		User u1 = new User();
		u1.setId(1);
		User u2 = new User();
		u2.setId(2);
		c.setContent("我今天捡到一百块钱");
		c.setCreateTime(new Date());
		c.setSender(u1);
		ImagePath ip1 = new ImagePath();
		ip1.setPath("1111");
		ip1.setTid(c);
		ImagePath ip2 = new ImagePath();
		ip2.setPath("2222");
		ip2.setTid(c);
		List<ImagePath> images = new ArrayList<ImagePath>();
		images.add(ip1);
		images.add(ip2);
		/*
		 * List<Comment> cs=new ArrayList<Comment>(); Comment c1=new
		 * Comment();c1.setCtime(new Date()); cs.add(c1); c.setComments(cs);
		 */
		c.setImages(images);

	}

	@Autowired
	private CircleService circleService;
	@Autowired
	private CommentDao commentDao;

	@Test
	public void testAddCircle() {

		circleService.addCircle(c);
	}

	@Test
	public void testDeleteCircle() {
		
		circleService.deleteCircle(49);
	}

	@Test
	public void testQueryCircles() {
		List<Circle> list = circleService.queryCircles(0, 3);
		int i = 0;
		for (Circle circle : list) {
			System.out.println(circle.getImages().get(0).getPath());
			System.out.println(circle.getComments().size());

		}
	}

	@Test
	public void testAddComment() {
		Comment comment = new Comment();
		User u1=new User();u1.setId(1);
		comment.setReceiver(u1);
		User u2=new User();u2.setId(1);
		comment.setSender(u2);
		Circle c=new Circle();
		c.setTid(53);
		comment.setTid(c);
		circleService.addComment(comment);
	}
	@Test
	public void testDeleteComment(){
		circleService.deleteComment(35);
	}
	@Test
	public void testIsSupported(){
		Comment comment = new Comment();
		comment.setText("");
		User u1=new User();u1.setId(2);
		comment.setSender(u1);
		Circle c=new Circle();
		c.setTid(53);
		comment.setTid(c);
		boolean i=circleService.isSupported(comment);
		System.out.println("存不存在"+i);
	}
	public CircleService getCircleService() {
		return circleService;
	}

	public void setCircleService(CircleService circleService) {
		this.circleService = circleService;
	}

}
