/**
 * 
 */
package com.demo;
import java.io.File;
import java.io.FileInputStream;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import java.net.*;

/**
 * @author Admin
 *
 */
public final class MetadataModifier {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				System.out.println("this is the demo");
				try{
				File file = new File("E:/General/Islamic/Quraan Audio/AlHasan/[Quran] Salah Al-Hashim [128Kbps]");
				File files[] = file. listFiles();
				ContentHandler contenthandler = new BodyContentHandler();
				Metadata metadata = new Metadata();
				FileInputStream fis ;
				String newFileName;
				Parser  parser = new  AutoDetectParser();
				for(File f : files){
					fis	= new FileInputStream(f);			
					metadata.set(Metadata.RESOURCE_NAME_KEY, f.getAbsolutePath());			
					parser.parse(fis, contenthandler, metadata);
					newFileName = metadata.get(Metadata.TITLE).replace("Surat ", "");
					newFileName =  f.getName().substring(0, 3)+"_"+newFileName+".mp3";
					//newFileName = newFileName.replace("'", "");
					File file2 = new File("E:\\General\\Islamic\\Quraan Audio\\AlHasan\\[Quran] Salah Al-Hashim [128Kbps]\\"+newFileName);			
						
					fis.close();
					if(f.getName().length()==7){
						System.out.println("path of file2"+f.renameTo(file2)+file2.getAbsolutePath());
					}
					//System.out.println("length of file:"+f.getName()+" :"+f.getName().length());

					//System.out.println(metadata.get(Metadata.AUTHOR));
					
					newFileName = "";
					
					
					
					}
				}
				catch(Exception e){
					e.printStackTrace();
					}
				System.out.println("over");

	}

}
