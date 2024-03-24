package com.example.ohmy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {

	List<String> searchPulldown = new ArrayList<String>();

	@GetMapping("/test")
	public String haha(Model model) {

		// List<String> searchPulldown = new ArrayList<String>();
//		searchPulldown.add("ppp 1");
//		searchPulldown.add("pppp 2");
//		searchPulldown.add("pppp 3");
//		model.addAttribute("searchTypes", searchPulldown);

		Form101 form = new Form101();
		form.setSearchText("");
		form.setSearchType("pppp 3");
		// form.setSearchTypes(searchPulldown);
		model.addAttribute("form101", form);

		return "Test2";
	}

	@ModelAttribute("searchTypes")
	public List<String> populateSeedStarters() {
		List<String> searchPulldown = new ArrayList<String>();
		searchPulldown.add("ppp 1");
		searchPulldown.add("pppp 2");
		searchPulldown.add("pppp 3");
		return searchPulldown;
	}

	@PostMapping("test/search")
	public String search(@ModelAttribute Form101 a, Model model) {
		SearchResult r1 = new SearchResult();
		String now = new Date().toString();
		r1.col1 = "";
		r1.col2 = a.searchType + now;
		r1.col3 = LocalDateTime.now();
		SearchResult r2 = new SearchResult();

		r2.col1 = "";
		r2.col2 = "bbbbb" + now;
		r2.col3 = LocalDateTime.now();
		SearchResult r3 = new SearchResult();

		r3.col1 = "33333" + now;
		r3.col2 = "ccccc" + now;
		r3.col3 = LocalDateTime.now();

		List<SearchResult> results = new ArrayList<>();
		results.add(r1);
		results.add(r2);
		results.add(r3);
		// model.addAttribute("searchText",a.searchText);
		// model.addAttribute("searchType",a.searchType);
		// model.addAttribute("searchTypes", searchPulldown);
		// System.out.println("*********form sTlist is" + a.getSearchTypes().toString()
		// + "*********");

		// model.addAttribute("form101", a);
		model.addAttribute("searchResults", results);

		return "Test2"; // Return the view name (search.html)
	}

	@PostMapping("test/ajaxtest")
	public @ResponseBody SearchResponse ajtest(@ModelAttribute Form101 a, Model model) {
		SearchResponse res = new SearchResponse();
		SearchResult r1 = new SearchResult();
		String now = new Date().toString();
		r1.col1 = "";
		r1.col2 = a.searchType + now;
		r1.col3 = LocalDateTime.now();
		SearchResult r2 = new SearchResult();

		r2.col1 = "";
		r2.col2 = "bbbbb" + now;
		r2.col3 = LocalDateTime.now();
		SearchResult r3 = new SearchResult();

		r3.col1 = "33333" + now;
		r3.col2 = "ccccc" + now;
		r3.col3 = LocalDateTime.now();

		List<SearchResult> results = new ArrayList<>();
		results.add(r1);
		results.add(r2);
		results.add(r3);
		// model.addAttribute("searchText",a.searchText);
		// model.addAttribute("searchType",a.searchType);
		// model.addAttribute("searchTypes", searchPulldown);
		// System.out.println("*********form sTlist is" + a.getSearchTypes().toString()
		// + "*********");

		// model.addAttribute("form101", a);
		// model.addAttribute("searchResults", results);
		res.resultList = results;
		res.resultCd = "0";

		return res; // Return the view name (search.html)
	}
}
