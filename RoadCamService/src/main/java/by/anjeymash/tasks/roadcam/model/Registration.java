package by.anjeymash.tasks.roadcam.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "registration")
@XmlRootElement(name = "registration")
@XmlAccessorType(XmlAccessType.FIELD)
public class Registration {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "r_id")
	private Long regId;
	
	@Column(name = "r_regnum")
	private String regNum;
	
	@Column(name = "r_regdate")
	private String regDate;
	
		
	public Long getRegId() {
		return regId;
	}

	public void setRegId(Long regId) {
		this.regId = regId;
	}



	// This default constructor is required if there are other constructors.
	public Registration() {

	}

	public Registration(Long regId, String regNum, String regDate) {
		this.regId = regId;
		this.regNum = regNum;
		this.regDate = regDate;

	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		result = prime * result + ((regId == null) ? 0 : regId.hashCode());
		result = prime * result + ((regNum == null) ? 0 : regNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registration other = (Registration) obj;
		if (regDate == null) {
			if (other.regDate != null)
				return false;
		} else if (!regDate.equals(other.regDate))
			return false;
		if (regId == null) {
			if (other.regId != null)
				return false;
		} else if (!regId.equals(other.regId))
			return false;
		if (regNum == null) {
			if (other.regNum != null)
				return false;
		} else if (!regNum.equals(other.regNum))
			return false;
		return true;
	}

}