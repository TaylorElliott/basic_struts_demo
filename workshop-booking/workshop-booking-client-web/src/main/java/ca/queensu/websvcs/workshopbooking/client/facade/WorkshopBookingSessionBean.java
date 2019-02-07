package ca.queensu.websvcs.workshopbooking.client.facade;

import ca.queensu.websvcs.workshopbooking.client.domain.StudentDataBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Stateless(mappedName = "WorkshopBookingSessionBean")
@Local
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class WorkshopBookingSessionBean implements WorkshopBookingSessionBeanLocal {

    private final Logger log = LogManager.getLogger(WorkshopBookingSessionBean.class);

    @Override
    public List<StudentDataBean> findStudentList() {
        try {
            List<StudentDataBean> studBeanList = new ArrayList<>();
            for(int i = 0; i < 20; i++) {
                StudentDataBean studBean = generateStudentBean(i);
                studBeanList.add(studBean);
            }
            return studBeanList;
        }
        catch(Exception e) {
            throw  new EJBException(e);
        }
    }
    
    private StudentDataBean generateStudentBean(int studentPk) {
        StudentDataBean studBean = new StudentDataBean();
        studBean.setStudentPk(String.valueOf(studentPk));
        studBean.setFirstName("Jane");
        studBean.setLastName("Doe" + studentPk);
        studBean.setAge(String.valueOf(20 + studentPk));
        studBean.setCountry(findCountries().get(studentPk));
        studBean.setHairColour("Pink");
        studBean.setOrganDonor(true);
        return studBean;
    }

    @Override
    public StudentDataBean findStudentByPk(String studentPk) {
        try {
            StudentDataBean stuBean = generateStudentBean(Integer.valueOf(studentPk));
            return stuBean;
        }
        catch(Exception e) {
            throw  new EJBException(e);
        }
    }
    
    @Override
    public List<String> findCountries() {
        List<String> countries = new ArrayList<>();
        countries.add("Dominica");
        countries.add("Norfolk Island");
        countries.add("Comoros");
        countries.add("Morocco");
        countries.add("Cayman Islands");
        countries.add("Costa Rica");
        countries.add("Mayotte");
        countries.add("Niger");
        countries.add("Slovakia");
        countries.add("Belgium");
        countries.add("Martinique");
        countries.add("Gibraltar");
        countries.add("England");
        countries.add("Panama");
        countries.add("Saint Barthelemy");
        countries.add("Palau");
        countries.add("Curacao");
        countries.add("Reunion");
        countries.add("Bonaire");
        countries.add("Saint Vincent and the Grenadines");
        countries.add("Slovenia");
        countries.add("Lesotho");
        countries.add("Japan");
        countries.add("North Korea");
        countries.add("French Guiana");
        countries.add("Uruguay");
        countries.add("Canada");
        countries.add("France");
        countries.add("Qatar");
        countries.add("Guam");
        return  countries;
    }
    
    @Override
    public List<String> findHairColours() {
        List<String> hairColours = new ArrayList<>();
        hairColours.add("Pink");
        hairColours.add("Purple");
        hairColours.add("Green");
        return  hairColours;
    }

    @Override
    public boolean updateStudent(StudentDataBean studentBean) {
        try {
            return true;
        }
        catch(Exception e) {
            throw  new EJBException(e);
        }
    }

}
