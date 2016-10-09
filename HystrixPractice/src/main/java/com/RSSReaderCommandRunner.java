package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.function.Consumer;

import com.rss.RssReaderCommand;

public class RSSReaderCommandRunner {

  public void print(Future<List<String>> future, Consumer<List<String>> consumer) {
    try {
      consumer.accept(future.get());
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

  public static void main(String[] args) throws Exception {
    RSSReaderCommandRunner runner = new RSSReaderCommandRunner();
    List<Future<List<String>>> futures = new ArrayList<>();
    try (FileReader fr = new FileReader("src/main/resources/RssUrls.txt"); BufferedReader br = new BufferedReader(fr);) {
      String url = "";
      while ((url = br.readLine()) != null) {
        RssReaderCommand rssReaderCommand = new RssReaderCommand(url);
        Future<List<String>> rssFuture = rssReaderCommand.queue();
        futures.add(rssFuture);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    int cnt = futures.size();
    while (cnt > 0) {
      Set<Future<List<String>>> completed = new HashSet<>();
      futures.stream().filter(future -> future.isDone()).forEach(future -> {
        completed.add(future);
        runner.print(future, res -> System.out.println(res.toString()));
      });

      futures.removeAll(completed);
      cnt = futures.size();
    }

  }

}
