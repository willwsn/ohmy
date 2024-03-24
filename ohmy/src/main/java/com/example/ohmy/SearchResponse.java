package com.example.ohmy;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchResponse {
	public List<SearchResult> resultList;
	public String resultCd;

}
