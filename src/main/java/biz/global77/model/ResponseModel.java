package biz.global77.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseModel {
	
	private int status;
	
	private String message;
	
	private String token;
	
	private Object object;

}
