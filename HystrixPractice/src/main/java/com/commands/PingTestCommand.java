package com.commands;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Tells you how much time it took to reach a website
 * @author asriv5
 *
 */

public class PingTestCommand extends HystrixCommand<String> {

  String url;

  public PingTestCommand(String url) {
    super(HystrixCommandGroupKey.Factory.asKey("pingTestGroup"));
    this.url = url;
  }

  @Override
  protected String run() throws Exception {

    URL myURL = new URL(this.url);
    HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();
    conn.setRequestMethod("GET");
    conn.connect();
    long len = conn.getContentLengthLong();
    // InputStream is = conn.getInputStream();
    // BufferedReader br = new BufferedReader(new InputStreamReader(is));
    // String line = "";
    // while ((line = br.readLine()) != null) {
    // System.out.println(url + " : " + line);
    // }
    int rc = conn.getResponseCode();

    return this.url + " returned " + len + " bytes of data" + " and " + rc;
  }

  @Override
  protected String getFallback() {
    // TODO Auto-generated method stub
    return "Error Occoured While Connecting to " + url;
  }

  public static void main(String[] args) throws Exception {
    List<String> urls = new ArrayList<>();
    urls.add("http://www.google.com");
    urls.add("https://www.facebook.com/");
    urls.add("http://www.yahoo.com");
    urls.add("http://www.cognizant.com");
    urls.add("http://www.nike.com/us/en_us/");
    urls.add("http://www.wikipedia.com");
    urls.add("http://www.oracle.com");

    List<Future<String>> futures = new ArrayList<>();
    urls.stream().map(url -> {
      return new PingTestCommand(url).queue();
    }).forEach(future -> {
      futures.add(future);
    });

    boolean done = false;
    while (!done) {
      Set<Future<String>> completed = new HashSet<>();
      futures.stream().filter(f -> f.isDone()).forEach(f -> {
        completed.add(f);
        try {
          System.out.println(f.get());
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      });
      futures.removeAll(completed);
      done = futures.size() == 0;
    }

  }

}
