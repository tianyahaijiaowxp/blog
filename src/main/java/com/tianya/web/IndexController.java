package com.tianya.web;

import com.tianya.NotFoundException;
import com.tianya.po.Blog;
import com.tianya.service.BlogService;
import com.tianya.service.TagService;
import com.tianya.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String index(@PageableDefault(size=2, sort={"updateTime"},
            direction = Sort.Direction.DESC) Pageable pageable,
                        Model model){
        model.addAttribute("page", blogService.listBlog(pageable));
        model.addAttribute("types", typeService.listTypeTop(6));
        model.addAttribute("tags", tagService.listTagTop(10));
        return "index";
    }

    @GetMapping("/blog")
    public String blog(){
        System.out.println("------blog------");
        return "blog";
    }
}
