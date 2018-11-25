package CreateTxT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Crawl.JsoupCrawl;

public class ReadTxt {
 
	public static void writeFileString(List<String> stringBuffer) {
		File file = new File("D:\\doubanBooks.txt");
		//if(!file.isDirectory())
			//file.mkdir();//创建目录
		File fileDir = new File(file,"");
		if(!fileDir.isFile()){
			try {
				fileDir.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			FileWriter fw = new FileWriter(fileDir);//FileWriter写入文件时不能指定编码格式，编码格式是系统默认的编码格式
			for(String a:stringBuffer) {
			fw.write(a+"\n"); //向文件中写入字符串
			}
			
			fw.flush(); //刷新
			fw.close(); }//关闭流}
			
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readFileString() {
		try {
			FileReader fr = new FileReader("D:\\doubanBooks.txt");//字符读入流
			BufferedReader br = new BufferedReader(fr);
			while(br.read() > 0){
				System.out.println(br.readLine());
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}