package spring.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.model.Article;
import spring.service.ArticleService;

@Controller

public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	// To add new article
	@RequestMapping(value = "/addArticle.html", method = RequestMethod.POST)
	public @ResponseBody
	String addUser(@ModelAttribute(value = "article") Article article,
			BindingResult result) {
		String returnText;
		if (!result.hasErrors()) {
			articleService.addArticle(article);
			returnText = "Total number of articles are "
					+ articleService.listArticles().size();
		} else {
			returnText = "Errors";
		}
		return returnText;
	}
	
	// To search articles using name
	@RequestMapping(value = "/searchArticle.html", method = RequestMethod.POST)
	public @ResponseBody
	String searchUser(Map<String, Object> map, HttpServletRequest request) {
		String keyword = request.getParameter("keyword");
		String returnText;
		// System.out.println("KEYWORD : "+keyword);
		List<Article> articles = articleService
				.searchArticlesByKeyword(keyword);

		returnText = "Found : " + (null == articles ? 0 : articles.size());
		String htmlResult = "";
		if (null != articles) {
			htmlResult = "<table><tr><th>Article ID</th><th>Article Name</th>"
					+ "<th>Article Desc</th><th>Added Date</th></tr>";
			for (Article article : articles) {
				htmlResult += "<tr>" + "<td>" + article.getArticleId()
						+ "</td>" + "<td>" + article.getArticleName() + "</td>"
						+ "<td>" + article.getArticleDesc() + "</td>" + "<td>"
						+ article.getAddedDate() + "</td>"

						+ "</tr>";
			}

		}
		returnText = returnText + "<br>" + htmlResult;

		return returnText;
	}
	
	// To display page addArticle.jsp
	@RequestMapping(value = "/addArticle.html", method = RequestMethod.GET)
	public ModelAndView addUser1(@ModelAttribute("article") Article article,
			BindingResult result) {

		return new ModelAndView("addArticle");

	}

}