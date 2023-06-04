package in.vini.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class CitizenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private Integer caseNum;
	private String fullName;
	private String email;
	private String phno;
	private String gender;
	private String dob;
	private String ssn;
	private String city;
	private String houseNum;
	private String state;
	@CreationTimestamp
	private LocalDate createdDate;

	private String createdBy;
}
