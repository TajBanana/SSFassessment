package tajbanana.ssfassessment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tajbanana.ssfassessment.service.BookService;

@Controller
@RequestMapping(path = "/book")
public class SearchController {
    private final Logger logger = LoggerFactory.getLogger(SearchController.class.getName());

    @Autowired
    private BookService bookService;


    @GetMapping
    public String getBook(@RequestParam String searchParam, Model model) {
        logger.info("Search for: " + searchParam);
//        model.addAttribute(searchParam);
        bookService.search(searchParam);
        return "book";
    }

}
