package org.films.servlets.tmbd;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.films.services.TmdbService;
import org.json.simple.JSONArray;

public class TmdbComedyServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

   private TmdbService tmdbService = new TmdbService();
   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	  String id = request.getParameter("id");
	   
      JSONArray movies = tmdbService.comedyMovies(Integer.parseInt(id));
      
      // Check data
      if(movies == null) {
         response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
         response.setContentType("application/json");
         response.getWriter().println("Não foi possível buscar por filmes em alta!");
         return;
      }
      
      response.setStatus(HttpServletResponse.SC_ACCEPTED);
      response.setContentType("application/json");
      response.getWriter().println(movies.toString());
      return;
   }

}
