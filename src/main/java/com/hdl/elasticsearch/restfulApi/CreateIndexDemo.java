package com.hdl.elasticsearch.restfulApi;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CreateIndexDemo {


    @Qualifier(value = "esClient")
    @Autowired
    RestHighLevelClient client;

    public void createIndex() throws IOException {

        try{
            Map<String,Object> esMap = new HashMap<>();
            esMap.put("name", "serlou");
            esMap.put("age", "109");
            esMap.put("des", "i like and study elasticearch");

            IndexRequest indexRequest = new IndexRequest("game","mhxy","2").source(esMap);

            IndexResponse indexResponse = client.index(indexRequest,RequestOptions.DEFAULT);

            int status = indexResponse.status().getStatus();

            System.out.println("status="+status);

            System.out.println("info="+indexResponse.status().toString());
        }finally {
            client.close();
        }


    }

}
