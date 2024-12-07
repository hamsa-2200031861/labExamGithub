package demo.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        try {
            // Load Hibernate configuration
            Configuration configuration = new Configuration().configure();
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            // Create a Project object
            Project project = new Project();
            project.setProjectName("AI Research");
            project.setDuration(24);
            project.setBudget(5000000.00);
            project.setTeamLead("John Doe");

            // Open session
            Session session = sessionFactory.openSession();

            // Begin transaction
            Transaction transaction = session.beginTransaction();

            // Save the object
            session.save(project);
            transaction.commit();

            System.out.println("Project inserted successfully!");

            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
