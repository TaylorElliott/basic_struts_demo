package ca.queensu.websvcs.workshopbooking.client.facade;

import ca.queensu.websvcs.workshopbooking.client.domain.StudentDataBean;
import java.util.List;
import javax.ejb.Local;


@Local
public interface WorkshopBookingSessionBeanLocal {
    
    public List<StudentDataBean> findStudentList();
    public StudentDataBean findStudentByPk(String studentPk);
    public List<String> findCountries();
    public List<String> findHairColours();
    public boolean updateStudent(StudentDataBean studentBean);
}
