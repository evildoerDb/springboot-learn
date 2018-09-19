package com.bobo.elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@Slf4j
public class ElasticsearchApplication {

    @Autowired
    private TransportClient client;


    /**
     * 查询数据
     * @param id
     * @return
     */
    @GetMapping("/get/book/novel")
    @ResponseBody
    public ResponseEntity get(@RequestParam(name = "id",defaultValue = "")String id){

        try {
            if (id == null){
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }

            GetResponse response = this.client.prepareGet("book","novel",id).get();

            if (!response.isExists()){
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity(response.getSource(), HttpStatus.OK);
        }catch (Exception e){
            log.error("查询出错={}",e.getMessage());
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


    /**
     * 添加数据
     * @param name
     * @param title
     * @return
     */
    @PostMapping("/add/book/novel")
    @ResponseBody
    public ResponseEntity addBook(@RequestParam("name")String name, @RequestParam("title")String title){

        try {
            XContentBuilder content = XContentFactory.jsonBuilder().startObject()
                    .field("name",name)
                    .field("title",title)
                    .endObject();
            IndexResponse response = this.client.prepareIndex("book","novel").setSource(content).get();
            log.info("插入数据成功={}",response);
            return new ResponseEntity(response.getId(),HttpStatus.OK);

        }catch (Exception e){
            log.error("插入数据异常={}", e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    /**
     * 删除数据
     * @param id
     * @return
     */
    @DeleteMapping("/del/book/novel")
    @ResponseBody
    public ResponseEntity delBook(@RequestParam("id")String id){

        DeleteResponse response = this.client.prepareDelete("book","novel",id).get();

        log.info("删除数据成功={}",response.getId());
        return new ResponseEntity(response,HttpStatus.OK);


    }

    @PutMapping("/update/book/novel")
    @ResponseBody
    public ResponseEntity updateBook(@RequestParam("id")String id, @RequestParam("title")String title, @RequestParam("name")String name){
        UpdateRequest request = new UpdateRequest("book","novel",id);

        try {

            XContentBuilder builder = XContentFactory.jsonBuilder().startObject();

            if (title != null){
                builder.field("title",title);
            }
            if (name != null){
                builder.field("name",name);
            }
            builder.endObject();

            request.doc(builder);

            UpdateResponse response = this.client.update(request).get();

            return new ResponseEntity(response.getResult().toString(),HttpStatus.OK);

        }catch (Exception e){
            log.error("更新数据异常={}",e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }
}
