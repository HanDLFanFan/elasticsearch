package com.hdl.elasticsearch.restfulApi;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.rest.RestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DeleteIndexDemo {

    @Qualifier(value = "esClient")
    @Autowired
    RestHighLevelClient client;

    public void deleteIndex() throws IOException {

        try {
            DeleteRequest deleteRequest = new DeleteRequest();
            deleteRequest.index("game");
            deleteRequest.type("mhxy");
            deleteRequest.id("2");

            DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
            RestStatus restStatus = deleteResponse.status();
            System.out.println(restStatus.getStatus());
        }finally {
            client.close();
        }
    }

}
