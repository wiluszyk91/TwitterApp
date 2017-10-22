package twitter.repository;

import twitter.model.TwitterMessage;

import java.util.List;

public interface TwitterRepository {

    List<TwitterMessage> getAllTwitts();
    TwitterMessage persistTwitterMessage(TwitterMessage twitterMessage);
    
    TwitterMessage getTweet(long id);


}
