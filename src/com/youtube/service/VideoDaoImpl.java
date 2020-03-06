package com.youtube.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.youtube.model.Channel;
import com.youtube.model.Tag;
import com.youtube.model.Video;

@Service
@Transactional (propagation = Propagation.REQUIRED)
public class VideoDaoImpl implements VideoDao{
	
	@Autowired
	private HibernateTemplate hibTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired 
	private HibernateTransactionManager tm;

	@Override
	public List<Video> getVideos() {
		
		return (List<Video>) hibTemplate.findByCriteria(DetachedCriteria.forClass(Video.class));
	}

	@Override
	public Video getVideo(String fileName) {
		Session session=this.hibTemplate.getSessionFactory().getCurrentSession();
	
		
		
			Video v=(Video) session.createCriteria(Video.class)
				     .add( Restrictions.like("fileName", "%"+fileName+"%") ).uniqueResult();
			
		
		session.update(v);
		
		return v;
	}

	@Override
	public List<Video> getVideos(String fileName) {
		Session session=this.hibTemplate.getSessionFactory().getCurrentSession();
		
			List<Video> vv=(List<Video>) session.createCriteria(Video.class)
				     .add( Restrictions.like("fileName", "%"+fileName+"%") ).list();
		
			Video v=vv.get(0);
			List<Video> rVideos=new ArrayList<Video>();
			List<Tag> tags=v.getTags();
			
			
			for(Tag t:tags) {
				
				Criteria videCrit=session.createCriteria(Video.class);
				Criteria tagcrit=videCrit.createCriteria("tags");
				tagcrit.add( Restrictions.like("tagId", t.getTagId()) );
				List<Video> vList=(List<Video>) videCrit.list();
					     
				rVideos.addAll(vList);
				
			}
		
			
				
			
		
		
	
		return rVideos;
	}

	@Override
	public List<Video> getVideosByTagName(String tagName) {
		Session session=this.hibTemplate.getSessionFactory().getCurrentSession();
		
		Tag tag=session.get(Tag.class, tagName);
		Query query=session.createQuery("from video where id=?");
		query.setParameter(1, tag.getTagId());
		List<Video> videos=query.getResultList();
		
		return videos;
	}

	@Override
	public Video updateVideoForLikes(String fileName) {
		Session session=this.hibTemplate.getSessionFactory().getCurrentSession();
		
		
		Video v=(Video) session.createCriteria(Video.class)
			     .add( Restrictions.like("fileName", "%"+fileName+"%") ).uniqueResult();
		v.setLikes(v.getLikes()+1);
		
		session.update(v);
		
		return v;
	}

	@Override
	public void insertVideo(String filename, String tags, String channelName, String videoName) {
		Session session=this.hibTemplate.getSessionFactory().getCurrentSession();
		
		List<Tag> tt=new ArrayList<Tag>();
		
		String[] tag=tags.split(" ");
		for(String t:tag) {
			Tag n=(Tag) session.createCriteria(Tag.class)
				     .add( Restrictions.like("tagName", "%"+t+"%") ).uniqueResult();;
				System.out.println("tag "+n.getTagName());    

			if (n!=null)
				tt.add(n);
			else
				tt.add(new Tag(t));
		}
		
		Channel channel1=(Channel) session.createCriteria(Channel.class)
				
			     .add( Restrictions.like("channelName", "%"+channelName+"%") ).uniqueResult();
		System.out.println("channel "+channel1.getChannelName()); 
		String nf="/"+filename+"/"+filename+"-720.mp4";
		Video v=new Video(videoName,new Date(),tt,channel1,nf);
		
		
		session.save(v);
	
		
	}
	
	

}
