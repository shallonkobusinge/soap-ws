
package output;

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
 *         &lt;element name="serviceStatus" type="{http://example.ac.rw/soap/students}serviceStatus"/>
 *         &lt;element name="studentInfo" type="{http://example.ac.rw/soap/students}studentInfo"/>
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
    "serviceStatus",
    "studentInfo"
})
@XmlRootElement(name = "addStudentResponse", namespace = "http://example.ac.rw/soap/students")
public class AddStudentResponse {

    @XmlElement(namespace = "http://example.ac.rw/soap/students", required = true)
    protected ServiceStatus serviceStatus;
    @XmlElement(namespace = "http://example.ac.rw/soap/students", required = true)
    protected StudentInfo studentInfo;

    /**
     * Gets the value of the serviceStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceStatus }
     *     
     */
    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    /**
     * Sets the value of the serviceStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceStatus }
     *     
     */
    public void setServiceStatus(ServiceStatus value) {
        this.serviceStatus = value;
    }

    /**
     * Gets the value of the studentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link StudentInfo }
     *     
     */
    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    /**
     * Sets the value of the studentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudentInfo }
     *     
     */
    public void setStudentInfo(StudentInfo value) {
        this.studentInfo = value;
    }

}
