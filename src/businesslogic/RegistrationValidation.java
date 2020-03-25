package businesslogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegistrationValidation {
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	private Pattern pattern;
	  private Matcher matcher1,matcher2;
	public boolean checkUserDetails(String email,String password,String confirmPassword) {
		if(validEmail(email) && validPassword(password,confirmPassword))
			return true;
		else
			return false;
	}

	private boolean validPassword(String password, String confirmPassword) {
		 pattern = Pattern.compile(PASSWORD_PATTERN);
		 if(password.equals(confirmPassword)) {
		  matcher1 = pattern.matcher(password);
		 matcher2 = pattern.matcher(confirmPassword);
		  return (matcher2.matches() && matcher1.matches());
		 }
		return false;
		 
	}

	private boolean validEmail(String email) {
		
		 String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		 return email.matches(regex);
	}
	
	
}