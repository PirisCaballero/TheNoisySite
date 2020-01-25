package Data_Encapsulation;

import java.util.HashMap;

public class DATA_PACK {
	
	HashMap<String, String> pack = new HashMap<String, String>();
	public DATA_PACK (String pack_name) {
		pack.put("name", pack_name);
	}
	
	public String get_Pack_Name() {
		return pack.get("name");
	}

}
