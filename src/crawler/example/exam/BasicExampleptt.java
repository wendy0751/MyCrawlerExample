package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import static javafx.beans.binding.Bindings.select;

/**
 * 爬蟲包程式的全貌，就只有這固定的模式
 * 
 * @author Abola Lee
 *
 */
public class BasicExampleptt {
	// commit test
	public static void main(String[] args) {


		String uri = "https://www.ptt.cc/bbs/Gossiping/M.1481286263.A.B3B.html";


        		Elements content = CrawlerPack.start()
			    .addCookie("over18","1")
				.getFromHtml(uri)
		        .select("#main-content* ");

				for(Element sdf :content.select("div.push")){
					//content.remove();

                    //System.out.println(sdf.select(".push-userid").text());
                    //String a = sdf.select(".push-userid").text();
                    //String b = sdf.select(".push-content").text();
                    //System.out.println(a+";"+b);

                    String a = sdf.select("span:contains(推)+span").text();
                    String b = sdf.select("span:containsOwn(推)+span+span").text();
                    System.out.println(a+";"+b);


				}


			    

	}
}
