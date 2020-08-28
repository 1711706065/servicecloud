//package com.lmc.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author lmc
// * @Description
// * @Date: Create in 22:14 2020/8/24
// */
//@RestController
//public class ArticleRestController {
//    @Autowired
//    private ArticleService articleService;
//
//    @RequestMapping(value = "/rest/article", method = RequestMethod.POST, produces = "application/json")
//    public WebResponse<Map<String, Object>> saveArticle(@RequestBody Article article) {
//        article.setUserId(1L);
//        articleService.saveArticle(article);
//        Map<String, Object> ret = new HashMap<>();
//        ret.put("id", article.getId());
//        WebResponse<Map<String, Object>> response = WebResponse.getSuccessResponse(ret);
//        return response;
//    }
//
//    @RequestMapping(value = "/rest/article/{id}", method = RequestMethod.DELETE, produces = "application/json")
//    public WebResponse<?> deleteArticle(@PathVariable Long id) {
//        Article article = articleService.getById(id);
//        article.setStatus(-1);
//        articleService.updateArticle(article);
//        WebResponse<Object> response = WebResponse.getSuccessResponse(null);
//        return response;
//    }
//
//    @RequestMapping(value = "/rest/article/{id}", method = RequestMethod.PUT, produces = "application/json")
//    public WebResponse<Object> updateArticle(@PathVariable Long id, @RequestBody Article article) {
//        article.setId(id);
//        articleService.updateArticle(article);
//        WebResponse<Object> response = WebResponse.getSuccessResponse(null);
//        return response;
//    }
//
//    @RequestMapping(value = "/rest/article/{id}", method = RequestMethod.GET, produces = "application/json")
//    public WebResponse<Article> getArticle(@PathVariable Long id) {
//        Article article = articleService.getById(id);
//        WebResponse<Article> response = WebResponse.getSuccessResponse(article);
//        return response;
//    }
//
//    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET, produces = "application/json")
//    public WebResponse<?> getNoApi(){
//        WebResponse<?> response = WebResponse.getSuccessResponse(null);
//        return response;
//    }
//}
