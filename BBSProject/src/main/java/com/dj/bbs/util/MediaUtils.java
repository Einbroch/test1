package com.dj.bbs.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

public class MediaUtils {
	private static Map<String, MediaType> mediaApp;
	
	static{
		mediaApp = new HashMap<String, MediaType>();
		mediaApp.put("JPG", MediaType.IMAGE_JPEG);
		mediaApp.put("GIF", MediaType.IMAGE_GIF);
		mediaApp.put("PNG", MediaType.IMAGE_PNG);
	}
	
	public static MediaType getMediaType(String type){
		return mediaApp.get(type.toUpperCase());
	}
}
