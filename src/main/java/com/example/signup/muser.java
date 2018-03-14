package com.example.signup;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

import lombok.Data;

@Data
@Entity(naming = NamingType.SNAKE_UPPER_CASE)
public class muser{
    @Id
   private String userId;
   private String password;
   private String lastUpdate;
    
}






/*public class SignUp {
	 private String id;
	 private String pass;
	
	 
	 
}
*/