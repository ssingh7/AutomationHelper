package com.scienitificgames.AutomationProject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.JsonParser;

public class Cricinfo {
	JSONObject jobj = new JSONObject();
	static String GET_URL;
	static String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) {
		List<String> matchIds = getMatchIds();
		for(String matchId : matchIds) {
			getMatchDetails(matchId);
		}

	}

	public static void getMatchDetails(String matchId) {
		GET_URL = "http://push.cricbuzz.com/match-api/"+matchId+"/commentary.json";
		String matchDetails = "";
		try {
			URL obj = new URL(GET_URL);
			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
			connection.setRequestMethod("GET");
			String line = "";
			System.out.println(connection.getResponseCode());
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			JSONParser parser = new JSONParser();
			JSONObject object = (JSONObject) parser.parse(bufferedReader);
			String matchStatus = (String) object.get("status");
			String seriesName = (String) ((JSONObject) object.get("series")).get("name");
			String score = (String) ((JSONObject) ((JSONObject) object.get("score")).get("batting")).get("score");
			System.out.println("Match status : " + matchStatus);
			System.out.println("Series name : " + seriesName);
			System.out.println("Score : " + score);
			connection.disconnect();

		} catch (Exception e) {
			System.out.println("API response code : " + e);
		}
	}

	public static void getLiveMatches() {
		GET_URL = "http://synd.cricbuzz.com/j2me/1.0/livematches.xml";
		try {
			URL obj = new URL(GET_URL);
			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = connection.getResponseCode();
			System.out.println("API response code : " + responseCode);
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.parse(connection.getInputStream());
			document.getDocumentElement().normalize();
			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList nodeList = (NodeList) xpath.compile("//match").evaluate(document, XPathConstants.NODESET);
			for(int i=0;i< nodeList.getLength();i++) {
				System.out.println(nodeList.item(i).getAttributes().getNamedItem("srs").getNodeValue());
				System.out.println(nodeList.item(i).getAttributes().getNamedItem("datapath").getNodeValue());
			}
		} catch (Exception e) {
			System.out.println("API response code : " + e);
		}

	}
	
	public static List<String> getMatchIds() {
		GET_URL = "http://www.cricbuzz.com/cricket-match/live-scores";
		try {
			URL obj = new URL(GET_URL);
			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = connection.getResponseCode();
			System.out.println("API response code : " + responseCode);
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";
			while((line = br.readLine())!=null) {
				if(line.length()>0) {
					break;
				}
			}
			String content = line;
			Pattern pattern = Pattern.compile("live-cricket-scores/[1-9][1-9][1-9][1-9][1-9]/");
			Matcher match = pattern.matcher(content);
			List<String> matchIds = new ArrayList<String>();
			
			while(match.find()) {
				if(!matchIds.contains(match.group().split("/")[1])) {
					matchIds.add(match.group().split("/")[1]);
					System.out.println(match.group().split("/")[1]);
				}
				
			}
			return matchIds;

		} catch (Exception e) {
			System.out.println("API response code : " + e);
		}
		return null;
	}

}
