package reivax.norac.website.caches;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import reivax.norac.website.service.WebSiteEJB;

public abstract class Cache<T> {
	
	private Date lastSync = null;
	private String cacheName = "";
	
	protected WebSiteEJB webSiteEJB;
	
	public Cache(String name){
		this.cacheName = name;
		try {
			webSiteEJB = getWebSiteEJB();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private WebSiteEJB getWebSiteEJB() throws NamingException{
		Properties properties = new Properties(); 
		properties.put("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory"); 
//		properties.put("java.naming.factory.url.pkgs","=org.jboss.namingrg.jnp.interfaces"); 
		properties.put("java.naming.provider.url","localhost:1099"); 
		
	  InitialContext ctx = new InitialContext(properties);
	  // For local tests: java:global/VisitWebSiteWAR-0.0.1-SNAPSHOT/WebSiteEJB!reivax.norac.website.service.WebSiteEJB
	  // For Cloudbees: java:global/app/WebSiteEJB!reivax.norac.website.service.WebSiteEJB
	  // Tried: java:global/app/VisitWithMe!reivax.norac.website.service.WebSiteEJB
	  Context envCtx = (Context) ctx.lookup("java:comp/env");
	  return (WebSiteEJB)envCtx.lookup("bean/WebSiteEJB");
	}
	
	protected List<T> elements;
	
	public List<T> getAll(){
		if(elements == null || elements.isEmpty()){
			refreshAll();
		}
		return elements;
	}

	public void add(T element){
		if(elements == null || elements.isEmpty()){
			refreshAll();
		}
		addAction(element);
		elements.add(element);
		lastSync = new Date();
	}
	
	public void update(T element){
		if(elements == null || elements.isEmpty()){
			refreshAll();
		}
		updateAction(element);
		elements.remove(element);
		elements.add(element);
		lastSync = new Date();
	}
	
	public synchronized void refreshAll(){
		elements = refreshAllAction();
		lastSync = new Date();
	}
	
	public Date getLastSync(){
		return lastSync;
	}
	
	public String getName(){
		return cacheName;
	}
	
	public int getSize(){
		return elements == null? 0:elements.size();
	}
	
	protected abstract List<T> refreshAllAction();
	protected abstract void addAction(T element);
	protected abstract void updateAction(T element);
}
