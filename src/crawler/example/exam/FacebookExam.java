package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.8"
				+ "/crazyck101/feed?fields=id,link,message,created_time,reactions.limit(0).summary(total_count)&since=1480849200&until=1480856400"
				+ "&access_token=EAACEdEose0cBAO4YmZBNpCOx6rDLKmzn9PQPEZBOqkWd96ZCkhpdw3gZCciDAPkrU09mmIsqD0QLeI3bZARMAF5uukz6BDcn3YFUX3jtO8tfzArDr13OuuWRMTwNuOyWMBUmm8kwrGBxcLESmwnVGT1pXhj9OvgnGfZBS0SOAZBA75gMaeKlHZBCkup77yRGySIZD";



		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id,reactions";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();
			 //FIXIT
			String reactions = data.select("reactions").text();


			output += "id="+id + "," + "reactions="+reactions + "\n";
		}

		System.out.println( output );
	} 
}
