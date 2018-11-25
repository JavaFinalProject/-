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
			//file.mkdir();//����Ŀ¼
		File fileDir = new File(file,"");
		if(!fileDir.isFile()){
			try {
				fileDir.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			FileWriter fw = new FileWriter(fileDir);//FileWriterд���ļ�ʱ����ָ�������ʽ�������ʽ��ϵͳĬ�ϵı����ʽ
			for(String a:stringBuffer) {
			fw.write(a+"\n"); //���ļ���д���ַ���
			}
			
			fw.flush(); //ˢ��
			fw.close(); }//�ر���}
			
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readFileString() {
		try {
			FileReader fr = new FileReader("D:\\doubanBooks.txt");//�ַ�������
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