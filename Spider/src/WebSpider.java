import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSpider {

	public static void main(String[] args) {
		URL url = null;
		URLConnection urlconn = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		String regEx = "http://[\\w+\\.?/?]+\\.[A-Za-z]+";
		Pattern p = Pattern.compile(regEx);
		try {
		url = new URL("http://www.163.com");
		urlconn = url.openConnection();
		pw = new PrintWriter(new FileWriter("d:\\url.txt"), true);
		
		br = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
		String buf = null;
		while((buf = br.readLine()) != null) {
			Matcher buf_m = p.matcher(buf);
			while(buf_m.find()) {
				pw.println(buf_m.group());
			}
		}
		System.out.println("Success");
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			pw.close();
		}
			
	}

}
