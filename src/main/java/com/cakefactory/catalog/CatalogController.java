package com.cakefactory.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class CatalogController {

    @Autowired
    CatalogService catalogService;

    @GetMapping("/catalog")
    ModelAndView index() {
        return new ModelAndView("catalog", Map.of("items", this.catalogService.getItems()));
    }

}