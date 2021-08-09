package com.vision.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileHandlerService {
	public static final String PROJECT_ABSOLUTE_PATH = System.getProperty("user.dir"); 
	public static final String RESOURCE_PATH = "/src/main/webapp/"; 
	
	@Value("${file.images}")
	private String imagesDir;	
	
	@Value("${file.videos}")
	private String videosDir;
	
	@Value("${file.uploads}")
	private String uploadDir;
	
	public void createDirectory(String directoryAblolutePath) {
		File file = new File(directoryAblolutePath);
		if(!file.exists()){
			file.mkdir();
			file.setExecutable(true);
			file.setWritable(true);
			file.setReadable(true);
		}
	}
	
	public String getImageUploadDir(UUID shoutID) {
		//System.out.println(uploadDir+"====================upload====");
		String dir =PROJECT_ABSOLUTE_PATH+RESOURCE_PATH+uploadDir+File.separator+shoutID+File.separator+imagesDir;
		File file = new File(dir);
		if(file.exists()) {
		//	System.out.println("exist");
			return dir;
		}
		
		file.mkdirs();
		file.setExecutable(true);
		file.setWritable(true);
		file.setReadable(true);
		
		return dir;
	}
	
	public String getImageUploadDir(String shoutID) {
		UUID id = UUID.fromString(shoutID);
		return getImageUploadDir(id);
	}
	
	public String getImageUploadDir(UUID shoutID,boolean isRelative) {
		//System.out.println(uploadDir+"=============isRelative=======upload====");
		String dir = uploadDir+File.separator+shoutID+File.separator+imagesDir;
		//System.out.println(PROJECT_ABSOLUTE_PATH+RESOURCE_PATH+dir);
		File file = new File(PROJECT_ABSOLUTE_PATH+RESOURCE_PATH+dir);
		if(file.isDirectory()) {
			return dir;
		}
		return null;
	}
	public String getImageUploadDir(String shoutID,boolean isRelative) {
		UUID id = UUID.fromString(shoutID);
		return getImageUploadDir(id,isRelative);
	}
	
//	public static List<Path> getAllFilesFromDirectory(String directoryPath) throws IOException{
//		List<Path> files = Files.list(Paths.get(directoryPath)).collect(Collectors.toList());
//       return files;
//    }
	public static List<Path> getAllFilesFromDirectory(String directoryPath) throws IOException{
		List<Path> files = Files.list(Paths.get(directoryPath)).collect(Collectors.toList());
//		List<String> fileStr = new ArrayList<>();
//		for (Path path : files) {
//			path.getFileName();
//		}
       return files;
    }
	
//	public String getImageUploadDir(String imageDir) {
//		String dir =PROJECT_ABSOLUTE_PATH+"/src/main/resources/"+imageDir;
//		File file = new File(dir);
//		if(file.exists()) {
//			return dir;
//		}
//		
//		file.mkdirs();
//		file.setExecutable(true);
//		file.setWritable(true);
//		file.setReadable(true);
//		
//		return dir;
//	}
}
