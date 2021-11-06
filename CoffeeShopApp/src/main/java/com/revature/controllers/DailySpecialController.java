package com.revature.controllers;

import com.revature.models.DailySpecial;
import com.revature.services.DailySpecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class DailySpecialController {

    @Autowired
    DailySpecialService dss;

    @GetMapping("/dailySpecials")
    public List<DailySpecial> getAllDailySpecials() {
        return dss.getAllDailySpecials();
    }
}
