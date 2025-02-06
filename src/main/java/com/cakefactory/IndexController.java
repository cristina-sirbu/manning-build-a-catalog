package com.cakefactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    CatalogService catalogService;

    @GetMapping("/")
    ModelAndView index() {
        return new ModelAndView("catalog", Map.of("items", this.catalogService.getItems()));
    }

}