package com.example.ohmy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {

	@GetMapping("/")
	public String getItems(Model model) {
		System.out.println("*********getItemscalled*********");
		// List<YourItemObject> items = new ArrayList(); // Get items from ser
		// YourItemObject item1 =new YourItemObject();
		List<String> items = new ArrayList<String>();
		items.add("items 1");
		items.add("items 2");
		items.add("items 3");
		model.addAttribute("items", items);

		List<String> options = new ArrayList<String>();
		options.add("option 1");
		options.add("option 2");
		options.add("option 3");
		model.addAttribute("options", options);

		return "main"; // Return the view name (index.html)
	}

	@PostMapping("/your-server-endpoint")
	public ResponseEntity<?> handleSelectedRows(@RequestBody List<YourDataObject> receivedData) {
		// Process the received data here
		// ...
		System.out.println("**************handleSelectedRows called******************");
		return ResponseEntity.ok("Data received successfully!");
	}

}
