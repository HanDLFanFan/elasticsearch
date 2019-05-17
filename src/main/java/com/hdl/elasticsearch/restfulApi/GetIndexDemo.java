package com.hdl.elasticsearch.restfulApi;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GetIndexDemo {



    public void getIndex() throws IOException {

        try(RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(
                        "47.93.247.163", 9200, "http")));){

            GetRequest request = new GetRequest();
            request.index("game");
            request.type("mhxy");
            request.id("2");


            GetResponse response = client.get(request, RequestOptions.DEFAULT);

            System.out.println(response.getSourceAsString());
        }


    }


}
