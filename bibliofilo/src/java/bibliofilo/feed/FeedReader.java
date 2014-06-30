/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bibliofilo.feed;

import bibliofilo.feed.FeedParser;

/**
 *
 * @author frangel
 */
public class FeedReader {

  public static void main(String[] args) {
    FeedParser parser = new FeedParser("http://www.amazon.com/gp/rss/new-releases/books/ref=zg_bsnr_books_rsslink");
    Feed feed = parser.readFeed();
    System.out.println(feed);
    for (FeedMessage message : feed.getMessages()) {
      System.out.println(message.title);
    }

  }  
}
