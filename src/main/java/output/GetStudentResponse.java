
package output;

import com.soap.soapCrud.general.bean.Student;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="studentDetails" type="{http://example.ac.rw/soap/students}StudentDetails" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "studentInfos"
})
@XmlRootElement(name = "GetStudentResponse", namespace = "http://example.ac.rw/soap/students")
public class GetStudentResponse {

    @XmlElement(namespace = "http://example.ac.rw/soap/students", required = true)
    protected StudentInfo studentInfos;

    public StudentInfo getStudentInfos() {
        return studentInfos;
    }

    public void setStudentInfos(StudentInfo studentInfos) {
        this.studentInfos = studentInfos;
    }

    /**
     * Gets the value of the studentDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studentDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudentDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StudentInfo }
     * 
     * 
     */


}
