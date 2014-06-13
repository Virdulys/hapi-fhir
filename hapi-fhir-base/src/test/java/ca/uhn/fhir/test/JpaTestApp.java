package ca.uhn.fhir.test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import ca.uhn.fhir.rest.server.tester.RestfulServerTesterServlet;
import ca.uhn.fhir.rest.server.tester.RestfulTesterServlet;

public class JpaTestApp {

	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) throws Exception {
		
//		ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("fhir-spring-test-config.xml");
//		
//		IFhirResourceDao<Patient> patientDao = appCtx.getBean("myPatientDao", IFhirResourceDao.class);
//		PatientResourceProvider patientRp = new PatientResourceProvider();
//		patientRp.setDao(patientDao);
//		
//		IFhirResourceDao<Questionnaire> questionnaireDao = appCtx.getBean("myQuestionnaireDao", IFhirResourceDao.class);
//		QuestionnaireResourceProvider questionnaireRp = new QuestionnaireResourceProvider();
//		questionnaireRp.setDao(questionnaireDao);
//		
//		RestfulServer restServer = new RestfulServer();
//		restServer.setResourceProviders(patientRp, questionnaireRp);
		
		int myPort = 8888;
		Server server = new Server(myPort);
		
		ServletContextHandler proxyHandler = new ServletContextHandler();
		proxyHandler.setContextPath("/");

		RestfulTesterServlet testerServlet = new RestfulTesterServlet();
//		testerServlet.setServerBase("http://localhost:" + myPort + "/fhir/context");
		 testerServlet.setServerBase("http://fhir.healthintersections.com.au/open");
		ServletHolder handler = new ServletHolder();
		handler.setName("Tester");
		handler.setServlet(testerServlet);
		proxyHandler.addServlet(handler, "/fhir/tester/*");

//		ServletHolder servletHolder = new ServletHolder();
//		servletHolder.setServlet(restServer);
//		proxyHandler.addServlet(servletHolder, "/fhir/context/*");

		server.setHandler(proxyHandler);
		server.start();

		
	}

}
