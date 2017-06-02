package com.firstdemo.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.firstdemo.entity.User;
import com.google.gson.Gson;

public class ResponseJsonUtils {
	public static void responseJson(HttpServletResponse response, User user){
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		Gson gson=new Gson();
		String jsonStr=gson.toJson(user);
		System.out.println(jsonStr);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

}
