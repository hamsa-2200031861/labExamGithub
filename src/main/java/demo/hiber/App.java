package demo.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) throws Exception {
        // Configure Hibernate
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();

        // Create a Project entity instance
        Project project = new Project();
        project.setProjectName("Development Tracker");
        project.setDuration(12); // Duration in months
        project.setBudget(2500000.00);
        project.setTeamLead("Hamsa Vahini");

        // Open a session
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        // Save the project object to the database
        session.save(project);

        // Commit the transaction
        transaction.commit();

        // Close the session
        session.close();

        System.out.println("Project inserted successfully!");
    }
}
