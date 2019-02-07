/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.queensu.websvcs.workshopbooking.client.action;

import ca.queensu.websvcs.workshopbooking.client.domain.StudentDataBean;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import javax.ejb.EJB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ca.queensu.websvcs.workshopbooking.client.facade.WorkshopBookingSessionBeanLocal;
import com.opensymphony.xwork2.Preparable;
import java.util.List;
import org.apache.struts2.interceptor.validation.SkipValidation;


public class StudentEditAction extends ActionSupport implements Preparable{

    private static final long serialVersionUID = 1L;
    private final Logger log = LogManager.getLogger(ca.queensu.websvcs.workshopbooking.client.action.StudentEditAction.class);

    @EJB(mappedName = "WorkshopBookingSessionBean")
    private WorkshopBookingSessionBeanLocal ejb;
    
    private String studentPk;
    private StudentDataBean studentBean;
    
    // This list populates the select drop down of countries.
    List<String> countries;
    // This list populates the radio buttons for hair colour options. 
    List<String> hairColours;

    @Override
    public void prepare() throws Exception {
        try {
            System.out.println("### StudentEditAction prepare running");
            countries = ejb.findCountries();
            hairColours = ejb.findHairColours();
        } 
        catch (Exception e) {
            StringWriter out = new StringWriter();
            e.printStackTrace(new PrintWriter(out));
            addActionError(createErrorMessage("Exception occurred while preparing data for edit screen."));
            log.error("***************Exception occurred in prepare method " + e.getMessage());
            log.error(out);
        }
    }
    
    @SkipValidation
    public String load() throws Exception {
        try {
            System.out.println("### StudentEditAction load running");
            studentBean = ejb.findStudentByPk(studentPk);
        } 
        catch (Exception e) {
            StringWriter out = new StringWriter();
            e.printStackTrace(new PrintWriter(out));
            addActionError(createErrorMessage("Exception occurred while loading student edit screen."));
            log.error("***************Exception occurred in load method " + e.getMessage());
            log.error(out);
            return ERROR;
        }
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        try {
            System.out.println("### StudentEditAction execute running");
            boolean saveSuccessful = ejb.updateStudent(studentBean);
            if(saveSuccessful) {
                addActionMessage("Save Successful!");
            }
            else {
                addActionError("Data was not saved.");
            }
        } 
        catch (Exception e) {
            StringWriter out = new StringWriter();
            e.printStackTrace(new PrintWriter(out));
            addActionError(createErrorMessage("Exception occurred while saving student data."));
            log.error("***************Exception occurred in execute method " + e.getMessage());
            log.error(out);
            return ERROR;
        }
        return SUCCESS;
    }
    
    @Override
    public void validate() {
        try {
            
            System.out.println("### StudentEditAction validate running");
            
            if(studentBean.getFirstName().isEmpty()) {
                addFieldError("firstName", "First name is required.");
            }
            else if(studentBean.getFirstName().length() > 20) {
                addFieldError("firstName", "First name cannot exceed 20 characters.");
            }
        } 
        catch (Exception e) {
            StringWriter out = new StringWriter();
            e.printStackTrace(new PrintWriter(out));
            addActionError(createErrorMessage("Exception occurred while validating student data."));
            log.error("***************Exception occurred in validate method " + e.getMessage());
            log.error(out);
        }
    }
    
    /**
     * Creates a custom error message to be used as an action error 
     * 
     * @param customMessage message to be used as the action error text
     * @return the created error message
     */
    private String createErrorMessage(String customMessage) {
        Date now = new Date();

        String msgAppend = " This error occurred at: " + now.toString() + ". Please note the date and time that this error occurred and take a screenshot of this message. Thank you.";

        return customMessage + msgAppend;
    }

    public String getStudentPk() {
        return studentPk;
    }

    public void setStudentPk(String studentPk) {
        this.studentPk = studentPk;
    }

    public StudentDataBean getStudentBean() {
        return studentBean;
    }

    public void setStudentBean(StudentDataBean studentBean) {
        this.studentBean = studentBean;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getHairColours() {
        return hairColours;
    }

    public void setHairColours(List<String> hairColours) {
        this.hairColours = hairColours;
    }
}
