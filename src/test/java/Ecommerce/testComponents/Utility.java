package Ecommerce.testComponents;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Utility{

	public ArrayList<HashMap<String, String>> getJsonDataToMap(String filePath) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<HashMap<String, String>> data = mapper.readValue(new File(filePath),
				new TypeReference<ArrayList<HashMap<String, String>>>() {
				});

		return data;
	}

}