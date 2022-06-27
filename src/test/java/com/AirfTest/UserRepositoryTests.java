package com.AirfTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.Calendar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository therepo;
	
	@Autowired
	private TestEntityManager theentityManager;
	
	@Test
	public void testCreateUser() { 
		
		
		Calendar cal = Calendar.getInstance();
		cal.set(1994,1,8);
		
		User user = new User(); 
		
		user.setCountryOfResidence("France");
		user.setFirstName("Ousmane");
		user.setLastName("DIOP");
		user.setGender("MALE");
		user.setPhoneNumber("+33199220789");
		user.setBirthDate(1969,Calendar.JANUARY, 4);
		user.setPassword("P@sseZ4223");  
		
		User insideUser = therepo.save(user); 

		Assertions.assertThat(insideUser.getCountryOfResidence()).isEqualTo("France");	
		
	}
}
