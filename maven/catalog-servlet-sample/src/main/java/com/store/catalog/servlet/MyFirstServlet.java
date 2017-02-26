package com.store.catalog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFirstServlet extends HttpServlet {

	public MyFirstServlet() {		
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			 throws ServletException, IOException {
			
		String first = req.getParameter("param1");
		String second = req.getParameter("param2");
		int operand1 = Integer.parseInt(first);
		int operand2 = Integer.parseInt(second);
        PrintWriter writer = res.getWriter();
        writer.println(operand1+operand2);
        writer.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String line = request.getReader().readLine();
		//System.out.println(line);
		//String[] operand = line.split("+");
		char[] array = line.toCharArray();
		
		int operand1 = 0;
		int operand2 = 0;
		
		int position = 0;
		
		for (int i = array.length-1; i >= 0; i--){
			if(array[i] == '+'){
				position = i;
				break;	
			}
			operand1 += Character.getNumericValue(array[i])*(int)Math.pow(10, array.length-i-1);
		}
		
		for (int i = position-1; i >= 0; i--)
			operand2 += Character.getNumericValue(array[i])*(int)Math.pow(10, position-i-1);
		
		PrintWriter writer = response.getWriter();
		writer.println(operand1+operand2);
		writer.close();
	}
	
}
