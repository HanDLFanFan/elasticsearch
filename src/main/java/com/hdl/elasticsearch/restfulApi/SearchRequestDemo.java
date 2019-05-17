package com.hdl.elasticsearch.restfulApi;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SearchRequestDemo {

    @Qualifier(value = "esClient")
    @Autowired
    RestHighLevelClient client;

    public void searchData() throws IOException {
        try {
            SearchRequest searchRequest = new SearchRequest();
            searchRequest.indices("game");


            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//            searchSourceBuilder.query(QueryBuilders.termQuery("name","ffy"));

            searchSourceBuilder.query(QueryBuilders.rangeQuery("name"));
            searchRequest.source(searchSourceBuilder);

            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits searchHits = searchResponse.getHits();
            SearchHit[] hits = searchHits.getHits();
            for (SearchHit sh : hits){

                String data = sh.getSourceAsString();
                System.out.println(data);
            }

        }finally {
            client.close();
        }
    }
}
