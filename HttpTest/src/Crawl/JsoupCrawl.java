package Crawl;
import CreateTxT.ReadTxt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
	public class JsoupCrawl {
		private static List<String> stringBuffer=new ArrayList<String>();
		public static void Crawl() throws IOException {
		  
	    	
	    	String s1 = "https://book.douban.com/top250?start=";
	        // 存储待爬取的网址url链接
	        ArrayList<String> list = new ArrayList<>();
	        for (int i = 0; i <= 225; i += 25) {
	            list.add(s1+i);
	        }
	      
	        // 遍历url集合 爬取网页数据
	        int i=0;
	       
	        for (String string : list) {
	        	List<String>content=null;
	            Document doc = Jsoup.connect(string).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36").timeout(6000).get();
	            	Elements elements = doc.select("div[class=indent]").select("table");
	        		for (Element ele : elements){
	        			i=i+1;
	        			String name = ele.select("div[class=pl2]").text();
	        			Element links=ele.getElementsByTag("a").get(0);
	        			String link=links.attr("href");
	        			
	        			String pubinfo = ele.select("p").text();
	        			//pubinfo:[美] 卡勒德·胡赛尼 / 李继宏 / 上海人民出版社 / 2006-5 / 29.00元
	        			//               作者       / 翻译  /    出版社      /出版时间/价格
	        			// 没有翻译人员的格式：钱锺书 / 人民文学出版社 / 1991-2 / 19.00
	        			String[] infos = pubinfo.split("/");
	        			content=Arrays.asList(infos);
	        			
	        			String ratingStr = ele.select("div[class=star clearfix]").select("span[class=rating_nums]").text();
	        			Double rating = Double.valueOf(ratingStr);
	        			stringBuffer.add(" <<"+name+">>"+"\n "+content.toString()+"\n "+rating+"\n "+link);
	        			System.out.println();
	        			
	            }
	        		//crawlcontent.setPagecontent(Crawlcontent.toString());
	        		
	    }

	}
		
		public static void main(String [] args) throws IOException {
			Crawl();
			ReadTxt.writeFileString(stringBuffer);
			ReadTxt.readFileString();
			
			
		}
	}
		
	