package biz.global77.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Professor extends User {
	
	private String professorNumber;
	
	private final String userType = "faculty";

}
