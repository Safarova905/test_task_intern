package com.example.test_task.controllers;

import com.example.test_task.Storage;
import com.example.test_task.models.WikiModel;
import com.example.test_task.repository.CategoryRepository;
import com.example.test_task.repository.WikiRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    final Storage storage;
    final WikiRepository wikiRepository;
    final CategoryRepository categoryRepository;

    public MainController(WikiRepository wikiRepository, CategoryRepository categoryRepository, Storage storage) {
        this.wikiRepository = wikiRepository;
        this.categoryRepository = categoryRepository;
        this.storage = storage;
    }

    @PostMapping("/update")
    public String update(@RequestParam(name = "path", required = false) String path) {
        if (path != null) {
            storage.parserJSON(path);
            return "Update";
        }
        return "Null path";
    }

    @GetMapping("/wiki/{title}")
    public Object getWikiPretty(@PathVariable String title, @RequestParam(required = false) String pretty) {
        WikiModel wiki = wikiRepository.findByTitle(title);
        if (pretty != null) {
            return wiki;
        }
        return wiki.toString();
    }
}
