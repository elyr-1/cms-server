package biz.global77.model;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String gender;
	
	private String address;
	
	private Date birthDate;
	
	private String email;
	
	private String password;

}
