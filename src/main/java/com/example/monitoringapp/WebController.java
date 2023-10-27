package com.example.monitoringapp;

import entity.ServerURLModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.*;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    @GetMapping("/monitor")
    public String monitor(Model model) throws IOException {
        String data = "";
        try {
            data = getJsonConfig().toJSONString();
            long rangeRefreshSite = (Long) getJsonConfig().get("timeToRefreshUrl");
            JSONArray serverNames = (JSONArray) getJsonConfig().get("listofUrl");
            model.addAttribute("rangeTime", rangeRefreshSite);
            List<ServerURLModel> serverURLModelList = new ArrayList<>();
            if (!serverNames.isEmpty()) {
                List<String> listofUrl = serverNames;
                for (String urlName : listofUrl) {
                    ServerURLModel ServerURLModel = new ServerURLModel(urlName);
                    ServerURLModel.setStatus(urlName);
                    serverURLModelList.add(ServerURLModel);
                }
            }
                model.addAttribute("serverlist", serverURLModelList);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "monitor";
    }
    private JSONObject getJsonConfig() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        File configFile = new File(FileSystems.getDefault().getPath("config.json").toAbsolutePath().toString());
        JSONObject data = (JSONObject) parser.parse(new FileReader(configFile.getAbsolutePath()));
        return data;
    }
}