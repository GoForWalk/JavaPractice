package com.command;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lec.beans.AjaxCateList;
import com.lec.beans.CategotyDTO;

public class AjaxListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		CategotyDTO [] cateArr = (CategotyDTO [])request.getAttribute("data");
		
		AjaxCateList result = new AjaxCateList();
		
		result.setStatus(request.getAttribute("status").toString());
		result.setMessage(request.getAttribute("message").toString());
		
		System.out.println(request.getAttribute("status").toString());
		System.out.println(request.getAttribute("message").toString());
		
		if(cateArr != null) {
			result.setCount(cateArr.length);
			result.setList(Arrays.asList(cateArr));
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String jsonString = mapper.writerWithDefaultPrettyPrinter()
									.writeValueAsString(result);
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(jsonString);
			System.out.println(jsonString);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
