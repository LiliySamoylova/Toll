package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.service_Gps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Controller
public class GessingController {
    @Autowired
    service_Gps gpsService;

    @RequestMapping("/gess")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="Noname") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("num", gpsService.dataGps());
        return "gessing";
    }



}
