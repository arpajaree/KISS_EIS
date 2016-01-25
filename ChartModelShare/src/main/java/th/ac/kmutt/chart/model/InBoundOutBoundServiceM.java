package th.ac.kmutt.chart.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import th.ac.kmutt.chart.xstream.common.ImakeXML;

import java.io.Serializable;

/**
 * Created by imake on 20/10/2015.
 */
@XStreamAlias("InBoundOutBoundServiceM")
public class InBoundOutBoundServiceM extends ImakeXML implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer fieldKey;
    private Integer programKey;
    private Integer semesterKey;
    private Integer noOfStudent;
    private Integer academicYear;
    private Integer facultyKey;
    private Integer empKey;
    private Integer departmentKey;
    private Integer nationalityKey;
    private Integer monthKey;
    
	public Integer getFieldKey() {
		return fieldKey;
	}
	public void setFieldKey(Integer fieldKey) {
		this.fieldKey = fieldKey;
	}
	public Integer getProgramKey() {
		return programKey;
	}
	public void setProgramKey(Integer programKey) {
		this.programKey = programKey;
	}
	public Integer getSemesterKey() {
		return semesterKey;
	}
	public void setSemesterKey(Integer semesterKey) {
		this.semesterKey = semesterKey;
	}
	public Integer getNoOfStudent() {
		return noOfStudent;
	}
	public void setNoOfStudent(Integer noOfStudent) {
		this.noOfStudent = noOfStudent;
	}
	public Integer getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(Integer academicYear) {
		this.academicYear = academicYear;
	}
	public Integer getFacultyKey() {
		return facultyKey;
	}
	public void setFacultyKey(Integer facultyKey) {
		this.facultyKey = facultyKey;
	}
	public Integer getEmpKey() {
		return empKey;
	}
	public void setEmpKey(Integer empKey) {
		this.empKey = empKey;
	}
	public Integer getDepartmentKey() {
		return departmentKey;
	}
	public void setDepartmentKey(Integer departmentKey) {
		this.departmentKey = departmentKey;
	}
	public Integer getNationalityKey() {
		return nationalityKey;
	}
	public void setNationalityKey(Integer nationalityKey) {
		this.nationalityKey = nationalityKey;
	}
	public Integer getMonthKey() {
		return monthKey;
	}
	public void setMonthKey(Integer monthKey) {
		this.monthKey = monthKey;
	}
    
}
