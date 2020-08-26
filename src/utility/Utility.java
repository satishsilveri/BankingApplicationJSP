package utility;

import java.util.UUID;

public class Utility {
	
	public static String getTransctionID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
