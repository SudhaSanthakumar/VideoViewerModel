package com.youtube.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.youtube.model.Channel;
import com.youtube.model.Comment;
import com.youtube.model.History;
import com.youtube.model.Reply;
import com.youtube.model.Tag;
import com.youtube.model.User;
import com.youtube.model.Video;
import com.youtube.service.VideoDao;

@Repository
public class VideoService {
	
	@Autowired
	private HibernateTemplate hibTemplate;
	
	@Autowired
	private VideoDao videoDao;
	
	
	public List<Video> getVideos(){
		
		return videoDao.getVideos();
		
	}
	
	public List<Video> getVideosByTagName(String tagName){
			
			return videoDao.getVideosByTagName(tagName);
			
		}
	
	
	public void insertVideo(String filename, String tags, String channelName, String videoName) {
		
			videoDao.insertVideo(filename, tags, channelName, videoName);
	}
	
		public void insertChannel() {
		
		
		
		Channel c1=new Channel("channel1");
		Session session=this.hibTemplate.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(c1);
		session.getTransaction().commit();
	}
		public void insertTag(String tagName) {
			
			Tag tag1=new Tag(tagName);
			Session session=this.hibTemplate.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.save(tag1);
			session.getTransaction().commit();
		}
		public void insertUser() {
			
			User u=new User("Sam","aaaa");
			
			Session session=this.hibTemplate.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.save(u);
			session.getTransaction().commit();
		}
		public void insertComment() {
			
			
			Session session=this.hibTemplate.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Video video = session.get(Video.class,1);
			Comment c=new Comment("first comment",video);
			session.save(c);
			session.getTransaction().commit();
		}
		
		public void addReply() {
			
			
			Session session=this.hibTemplate.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Comment c = session.get(Comment.class,1);
			Reply r=new Reply("Reply1",c);
			session.save(r);
			session.getTransaction().commit();
		}
		
		
		public void insertHistory() {
			
			
			Session session=this.hibTemplate.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Video video = session.get(Video.class,1);
			User u=session.get(User.class, 1);
			History h=new History(video.getVideoId(),u.getUserId(),new Date());
			session.save(h);
			session.getTransaction().commit();
		}
		
		
		
		public Video getVideo(String fileName) {
			
			
			return videoDao.getVideo(fileName);
		
		//	Video v=(Video) this.hibTemplate.findByCriteria(DetachedCriteria.forClass(Video.class)
		//		     .add( Restrictions.like("fileName", "%"+fileName+"%") )).get(0);
		//	v.setViews(v.getViews()+1);
		//	
		//
		//	this.hibTemplate.update(v);
		//	return v;
		}
		
		public List<Video> getRelatedVideos(String fileName) {
			return videoDao.getVideos(fileName);
		}
		
		public Video updateVideoForLikes(String fileName) {
			return videoDao.updateVideoForLikes(fileName);
		}
		
			
}
