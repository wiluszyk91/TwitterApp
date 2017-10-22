package twitter.controller;

import twitter.cookies.CookieHelper;
import twitter.dto.TwitterMessageDto;
import twitter.service.TwitterService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import static twitter.enums.TwitterCookieNames.FAVOURITE_TWITTS;
import static twitter.enums.TwitterMessages.TWITT_ADDED;


@WebServlet(name = "TwitterController", value = "/all" )
public class TwitterController extends HttpServlet {

    private TwitterService service = new TwitterService();

    private static int hitCount=0;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String userMessage = req.getParameter("userMessage");
    	
    	if (userMessage!=null) {
    		
    		if (userMessage.equals(TWITT_ADDED.name())) {
    			req.setAttribute("userMessage", TWITT_ADDED.getValue());
    		}
    	}
    	
    	String cookieValue=CookieHelper.getCookieValue(req.getCookies(), FAVOURITE_TWITTS.getValue());
    	
        List<TwitterMessageDto> allTwitts = service.getAllTwitts();
        
        if (cookieValue!=null) {
	        List<TwitterMessageDto> favouriteTwitts = service.getFavouriteTwitts(cookieValue);
	        for (TwitterMessageDto twitterMessageDto : allTwitts) {
	        	for (TwitterMessageDto favouriteMessageDto : favouriteTwitts) {
	        		if (twitterMessageDto.getId()==favouriteMessageDto.getId()) {
	        			twitterMessageDto.setFavouriteTweet(true);
	        			break;
	        		}
	        	}
	        }
        }
        req.setAttribute("twitters", allTwitts);
        RequestDispatcher dispatcher = req.getRequestDispatcher("twitters.jsp");
        dispatcher.forward(req, resp);
    }
}