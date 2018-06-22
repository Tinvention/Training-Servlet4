/*******************************************************************************
 *    Copyright 2018, Tinvention - Ingegneria Informatica
 *    This project includes software developed by Tinvention - Ingegneria Informatica .
 *    http://tinvention.net/
 *    
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the Licens
 *    
 *******************************************************************************/
package net.tinvention.training.web.servlet4;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// Generate page contents
    	String stringPageTemplate = 
    			"	<!DOCTYPE HTML>" +
    			"	<html>" + 
    			"    	<head><title>Servlet 4.0 Demo</title></head>" + 
    			"    	<body>" + 
    			"    	    <h1>This is a Servlet 4.0 Example</h1>" + 
    			"    	    </br>" + 
    			"    	    <p>{0} {3}</p>" + 
    			"    	    </br>" + 
    			"    	    <p>{1} {2} {3}</p>" + 
    			"    	</body>" + 
    			"    	</html>";
 
		String outputBodycontent = MessageFormat.format(stringPageTemplate, "It works", "Hello", "World", "!!"); //it is using the varargs way

		//Send contents to browser
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(outputBodycontent); // it is better do not to close here the writer, it is managed by the Application Server

    }
}