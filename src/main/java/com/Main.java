package com;

import com.db.DataStore;
import com.html.UrlContentReader;
import com.model.AdAuthor;
import com.model.CarFuelType;
import com.parser.AutoPlius.FrontPage;
import com.parser.AutoPlius.jsoup.FrontPageImpl;
import com.parser.AutoPlius.jsoup.IndividualAdImpl;
import com.service.Front;
import com.service.IndAd;
import com.service.Manager;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        DataStore store = new DataStore();

        Front front = new Front(1, 1, store);
        IndAd indAd = new IndAd(15, store);
        Manager manager = new Manager(5, store);

        front.start();
        indAd.start();
        manager.start();

    }

    public Document getParsedDocument(String target){
        UrlContentReader client = new UrlContentReader();
        return UrlContentReader.readContentInJsoupDocument(target);
    }

    public void showNumberOfAdsFound(FrontPage frontPage){
        int adCount = frontPage.countOfAdsFound();
        System.out.println("Count of Ads found in the page:" + adCount);
    }

    public void listIdsAndUrls(FrontPageImpl frontPage){
        for(Element element : frontPage.getAdsInHtml()){
            String id = frontPage.parseAdId(element);
            String url = frontPage.parseAdUrl(element);

            System.out.println("Ad id: " + id + " URL: " + url);
        }
    }

    public void innerAdTest(){
        Document parsedDocument = getParsedDocument("https://en.autoplius.lt/ads/bmw-active-hybrid-5-saloon-sedan-2014-petrol-9064967.html");
        IndividualAdImpl individualAd = new IndividualAdImpl(parsedDocument);
        int price = individualAd.parsePrice();
        AdAuthor adAuthor = individualAd.parseAdAuthor();
        String[] images = individualAd.parseImg();
        CarFuelType carFuelType = individualAd.parseFuelType();
        String makeYear = individualAd.parseMakeYear();

        System.out.println(price);
        System.out.println(adAuthor);
        for(String image : images){
            System.out.println(image);
        }
        System.out.println(carFuelType);
        System.out.println(makeYear);

//        for (String i : individualAd.getAdCarParams().keySet()) {
//            System.out.println("key: " + i + " value: " + individualAd.getAdCarParams().get(i));
//        }
    }
}
