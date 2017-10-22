package twitter.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter.cookies.CookieHelper;
import twitter.dto.TwitterMessageDto;
import twitter.service.TwitterService;
import static twitter.enums.TwitterCookieNames.FAVOURITE_TWITTS;

@WebServlet("/favourite_tweets")
public class FavouriteTweetsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String TWITTS_ID_COOKIE_NAME = "twitts_id";
	
	private int hitCounter = 0;
	
	private TwitterService twitterService = new TwitterService();
	

    public FavouriteTweetsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cookieValue=CookieHelper.getCookieValue(request.getCookies(), FAVOURITE_TWITTS.getValue());
		
		if (cookieValue!=null) {
			
			List<TwitterMessageDto> favouriteTwitts = twitterService.getFavouriteTwitts(cookieValue);
			request.setAttribute("favouriteTwitts", favouriteTwitts);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("favourites.jsp");
        dispatcher.forward(request, response);
	}

	// addCookie 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cookieValue=CookieHelper.getCookieValue(request.getCookies(), FAVOURITE_TWITTS.getValue());
		
		String twittId = request.getParameter("twitt_id");

		if (cookieValue!=null) {
			cookieValue+="#"+twittId;
		} else {
			cookieValue = twittId;
		}
		
		Cookie cookie = new Cookie(TWITTS_ID_COOKIE_NAME, cookieValue);
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		response.sendRedirect("/all");
	}
}
