package Data_Encapsulation;

import java.util.HashMap;
import java.util.Map.Entry;

public class DATA_PACK {
	
	HashMap<String, String> pack = new HashMap<String, String>();
	public DATA_PACK (String pack_name) {
		pack.put("name", pack_name);
	}
	
	public String get_Pack_Name() {
		return pack.get("name");
	}
	public void add_value(String key , String value) {
		pack.put(key, value);
	}
	public String get_Value_by_Key(String key) {
		return pack.get(key);
	}
	
	public void to_String () {
		System.out.println( "The Name of Package is: "+this.get_Pack_Name() );
		for (Entry<String, String> entry : pack.entrySet()) {
		    String key = entry.getKey();
		    Object value = entry.getValue();
		    // ...
		    System.out.println(key + " -> " + value);
		}
	}

}
