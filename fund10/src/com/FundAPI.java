package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FundAPI")
public class FundAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Fund fundObj = new Fund();
       
   
    public FundAPI() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String output = fundObj.insertFund(request.getParameter("FunderCode"),
				request.getParameter("CompanyName"),
				request.getParameter("ContactNo"), 
				request.getParameter("CompanyDesc")); 
				response.getWriter().write(output); 
		
		doGet(request, response);
	}
	
	
	private static Map getParasMap(HttpServletRequest request)
	{
	 Map<String, String> map = new HashMap<String, String>();
	try
	{
		Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
		String queryString = scanner.hasNext() ?
			 scanner.useDelimiter("\\A").next() : "";
		scanner.close();
	 
		String[] params = queryString.split("&");
		for (String param : params)
		{ 
	
			String[] p = param.split("=");
			map.put(p[0], p[1]);
		}
	}
	catch (Exception e)
	{
	 }
	return map;
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 Map paras = getParasMap(request);
		 String output = fundObj.updateFund(paras.get("hidFIDSave").toString(),
		 paras.get("FunderCode").toString(),
		 paras.get("CompanyName").toString(),
		 paras.get("ContactNo").toString(),
		 paras.get("CompanyDesc").toString());
		 response.getWriter().write(output);
		
		// TODO Auto-generated method stub
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request);
		String output = fundObj.deleteFund(paras.get("FID").toString());
		response.getWriter().write(output);
		
	}

}
