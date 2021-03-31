package org.gnu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NumberGuess
 */
public class NumberGuess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int numb = (int) (Math.random()*100);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NumberGuess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 // Envoi d'une reponse en HTML
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    // Recuperation du parametre nom
	    int nb = Integer.parseInt(request.getParameter("num"));
	    String mess="";
	    if (nb == numb ) {
	    	mess = "GAGNE <p> <a href=\"NumberGuess.html\">nouvel essai ?</a>";
	    	setNumb();
	    }else if (nb>numb) {
	      mess = "Nombre trop haut";
	    }else {
	    	mess = "Nombre trop bas";
	    }
	    out.write("<html><head><title>NumberGuess</title></head>"
	    		+ "<body>"
	    		+ "<h2>Mise en application "+numb+"</h2>"
	    		+ "<br>"
	    		+ "\r\n"
	    		+ "<p><h2>Formulaire de devinette de nombre</h2></p>"
	    		+ "<form action=\"numberguess\" method=\"POST\">"
	    		+ "  <p>Entrez un nombre : <input type=\"text\" name=\"num\"></p>"
	    		+ "  <p><input type=\"submit\" value=\"Envoyer\"></p>\r\n"
	    		+ "</form><p>"+mess+"</p>");
	    		out.write("</center></body></html>");	
	}

	private void setNumb() {
		// TODO Auto-generated method stub
		numb = (int) (Math.random()*100);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
