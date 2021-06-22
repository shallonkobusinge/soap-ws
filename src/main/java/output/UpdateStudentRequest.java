
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
    "studentInfo"
})
@XmlRootElement(name = "updateStudentRequest", namespace = "http://example.ac.rw/soap/students")
public class UpdateStudentRequest {

    @XmlElement(namespace = "http://example.ac.rw/soap/students", required = true)
    protected StudentInfo studentInfo;

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
