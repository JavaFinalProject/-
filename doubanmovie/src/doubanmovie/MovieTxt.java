package doubanmovie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MovieTxt {

	public static void writeFileString(List<String> stringBuffer) {
		
		File file = new File("D:\\douban\\doubanmovie.txt");
		File fileDir = new File(file,"");
		if(!fileDir.isFile()) {
			try {
				fileDir.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		try {
			FileWriter fw = new FileWriter(fileDir);
			
			for(String a:stringBuffer) {
				fw.write(a+"\n");
			}
				fw.flush();//刷新
				
				fw.close();//关闭流
			}catch(IOException e){
				
				e.printStackTrace();
			}
			}
		
	public static void readFileString() {
		
		try {
			
		FileReader fr = new FileReader("D:\\douban\\doubanmovie.txt");//字符读入流
		BufferedReader br = new BufferedReader(fr);
		
		try {
			while(br.read()>0) {
				System.out.println(br.readLine());
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		}
		
	}
		



