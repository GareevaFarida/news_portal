/**
 * @Author Ostrovskiy Dmitriy
 * @Created 04/04/2020
 * ArticleFilter for SearchController
 * @version v1.0
 */

package ru.geek.news_portal.utils;

import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;
import ru.geek.news_portal.base.entities.Article;
import ru.geek.news_portal.base.specifications.ArticleSpecifications;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Map;

@Getter
public class ArticleFilter {
//    private Specification<Article> specification;
//    private StringBuilder filtersString;

    private Specification<Article> spec;
    private StringBuilder filterDefinition;
    private Specification<Article> specCat;

//    public Specification<Article> getSpecification() {
//        return specification;
//    }
//    public StringBuilder getFiltersString() {
//        return filtersString;
//    }

    public Specification<Article> getSpecification() {
        return spec;
    }

    public StringBuilder getFilterDefinition() {
        return filterDefinition;
    }

    public ArticleFilter(Map<String, String> map) {
        this.spec = Specification.where(null);
        this.filterDefinition = new StringBuilder();
        if (map.containsKey("word") && !map.get("word").isEmpty()) {
            String word = map.get("word");
            spec = spec.and(ArticleSpecifications.titleContains(word));
            filterDefinition.append("&word=").append(word);
        }
        if (map.containsKey("limit") && !map.get("limit").isEmpty()) {
            int limit = Integer.parseInt(map.get("limit"));
            spec = spec.and(ArticleSpecifications.limitNavTab(limit));
            filterDefinition.append("&limit=").append(limit);
        }
        if (map.containsKey("cat_id") && !map.get("cat_id").isEmpty()) {
            Long catId = Long.parseLong(map.get("cat_id"));
            spec = spec.and(ArticleSpecifications.categoryId(catId));
            filterDefinition.append("&cat_id=").append(catId);
        }
//        if (map.containsKey("pageNumber") && !map.get("pageNumber").isEmpty()) {
//            Integer pageNumber = Integer.parseInt(map.get("pageNumber"));
//            filterDefinition.append("&pageNumber=").append(pageNumber);
//        }
        if (map.containsKey("pageLimit") && !map.get("pageLimit").isEmpty()) {
            Integer pageLimit = Integer.parseInt(map.get("pageLimit"));
            filterDefinition.append("&pageLimit=").append(pageLimit);
        }


//    public ArticleFilter(HttpServletRequest request) {
//        filtersString = new StringBuilder();
//        specification = Specification.where(null);
//        specCat = Specification.where(null);
//
//        if (request.getParameter("word") != null && !request.getParameter("word").isEmpty()) {
//            specification = specification.and(ArticleSpecifications.titleContains(request.getParameter("word")));
//            filtersString.append("&word=" + request.getParameter("word"));
//        }
//
//        if (request.getParameter("limit") != null && !request.getParameter("limit").isEmpty()) {
//            specification = specification.and(ArticleSpecifications.limitNavTab(new BigDecimal(request.getParameter("limit"))));
//            filtersString.append("&limit=" + request.getParameter("limit"));
//        }
//
//        if (request.getParameter("catId") != null && !request.getParameter("catId").isEmpty()) {
//            specification = specification.and(ArticleSpecifications.categoryId(Long.valueOf(request.getParameter("catId"))));
//            filtersString.append("&catId=" + request.getParameter("catId"));
//        }

        //        Long[] cats = {1L, 2L};
//        for (int i = 0; i < cats.length; i++) {
//            specCat = specCat.or(ArticleSpecifications.categoryId(Long.valueOf(request.getParameter("catId"))));
//        }
//        specification = specification.and(specCat);
//    }

        // if(isArray) {
        // multiSpec = new Spec(null);
        // String o : arr {
        //  multiSpec = multiSpec.or(.........);
        // }
        // spec = spec.and(multiSpec);
//        Long[] cats = {1L, 2L};
//        for (int i = 0; i < cats.length; i++) {
//            specCat = specCat.or(ArticleSpecifications.categoryId(Long.valueOf(request.getParameter("catId"))));
//        }
//        specification = specification.and(specCat);
    }
}
