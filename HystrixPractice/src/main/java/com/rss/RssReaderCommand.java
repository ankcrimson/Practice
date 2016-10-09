package com.rss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class RssReaderCommand extends HystrixCommand<List<String>> {
  String url = "http://rss.cnn.com/rss/cnn_topstories.rss";

  public RssReaderCommand(String url) {
    super(HystrixCommandGroupKey.Factory.asKey("rssCommands"));
    this.url = url;
  }

  @Override
  protected List<String> run() throws Exception {
    // TODO Auto-generated method stub

    return getFeeds();
  }

  @Override
  protected List<String> getFallback() {
    // TODO Auto-generated method stub
    List<String> result = new ArrayList<>();
    result.add("Error Parsing " + url);
    return result;
  }

  public List<String> getFeeds() throws Exception {
    List<String> feeds = new ArrayList<>();
    URL url = new URL(this.url);
    URLConnection conn = url.openConnection();
    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String content = "";
    String line = "";
    while ((line = br.readLine()) != null) {
      content += line;
    }
    int index = 0;
    while ((index = content.indexOf("<description>", index)) >= 0) {
      int endIndex = content.indexOf("</description>", index);
      String data = content.substring(index + 13, endIndex);
      index = endIndex + 1;
      feeds.add(data);
    }
    return feeds;
  }
}
