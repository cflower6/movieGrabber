package com.stuff;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MovieServ extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userInput = req.getParameter("userInput").replaceAll("\\s","+");
        PullFromMovieAPI movieAPI = new PullFromMovieAPI();
        ParseData pd = new ParseData();

        StringBuffer holder = movieAPI.JsonFromMovieAPI(userInput);

        ArrayList<String> movie = pd.parse(holder.toString());


        PrintWriter writer = res.getWriter();
        writer.append("<html lang=\"en\">");
        writer.append("<head>");
        writer.append("<meta charset=\"UTF-8\">");
        writer.append("<title>Movie Info</title>");
        writer.append("</head>");
        writer.append("<body>");
        writer.append("<h2>Enter the name of a Movie</h2>");
        writer.append("<form action=\"Movie\">");
        writer.append("Movie Title: <input type=\"text\" name=\"userInput\">");
        writer.append("<input type=\"submit\">");
        writer.append("<H2>" + movie.get(0) + "</h2>");
        writer.append("<p>"+movie.get(1)+"</p>");
        writer.append("<img src=" + "\""+ movie.get(2)+ "\"" + ">");
        writer.append("</form>");
        writer.append("</body>");
        writer.append("</html>");
    }
}
