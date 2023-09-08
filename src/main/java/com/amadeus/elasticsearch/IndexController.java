package com.amadeus.elasticsearch;

import cn.hutool.core.lang.Assert;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.GetIndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class IndexController {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @GetMapping("/addIndex/{indexName}")
    public void addIndex(@PathVariable String indexName) throws IOException {
        CreateIndexResponse createIndexResponse = elasticsearchClient.indices().create(c -> c.index(indexName));
        Assert.notNull(createIndexResponse);
        System.out.println(createIndexResponse);
    }

    @GetMapping("searchIndexList")
    public void searchIndexList() throws IOException {
        GetIndexResponse getIndexResponse = elasticsearchClient.indices().get(demo -> demo.index("*"));
        Assert.notNull(getIndexResponse);
        System.out.println(getIndexResponse);
    }
}
