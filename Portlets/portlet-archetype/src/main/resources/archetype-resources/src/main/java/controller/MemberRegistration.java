#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import ${package}.model.Member;

// The @Stateful annotation eliminates the need for manual transaction demarcation
@Stateful
// The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an
// EL name
// Read more about the @Model stereotype in this FAQ:
// http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
@Model
@PersistenceContext(name="MemberRegistration")
public class MemberRegistration {

   @Inject
   private Logger log;

   @Inject
   private FacesContext facesContext;

   private EntityManager em;

   @Inject
   private Event<Member> memberEventSrc;

   private Member newMember;
   
   public MemberRegistration() {
	   newMember = new Member();
   }

   @Produces
   @Named
   public Member getNewMember() {
      return newMember;
   }

   @Resource
   private javax.transaction.UserTransaction utx;

   // Code to inject entity manager
   @PersistenceUnit(unitName="Portlet")
   private EntityManagerFactory emf;
   
   private EntityManager getEntityManager() {
	    return emf.createEntityManager();
   }
   
   public void register() throws Exception {
      log.info("Registering " + newMember.getName());
      em = getEntityManager();
      utx.begin();
      em.joinTransaction();
      em.persist(newMember);
      utx.commit();
      facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful"));
      memberEventSrc.fire(newMember);
      initNewMember();
      em.close();
   }

   @PostConstruct
   public void initNewMember() {
      newMember = new Member();
   }
}
