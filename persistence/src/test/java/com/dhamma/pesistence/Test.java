package com.dhamma.pesistence;

import com.dhamma.pesistence.entity.data.User;
import com.dhamma.pesistence.entity.repo.DataRepo;
import com.dhamma.pesistence.entity.repo.UserRepo;
import com.google.gson.JsonElement;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    UserRepo userRepo;

    @Autowired
    DataRepo dataRepo;

//    // @org.junit.Test
//    public void testme() {
//
////        "[{" id ":" ma "," value ":" 0.20 < 50 "},{" id ":1," value ":" 0.5 < 200 "},{" id ":" ma "," value ":" 30 < 14"}]"
//        JsonArray mainArray = new JsonArray();
//
//        JsonObject content = new JsonObject();
//        content.addProperty("id", "ma");
//        content.addProperty("value", "0.2<50");
//        mainArray.add(content);
//
//        content = new JsonObject();
//        content.addProperty("id", "ma");
//        content.addProperty("value", "0.5<200");
//        mainArray.add(content);
//
//        content = new JsonObject();
//        content.addProperty("id", "rsi");
//        content.addProperty("value", "30<14");
//        mainArray.add(content);
//
//
//        System.out.println("-------------------" + mainArray);
//        User usr = User.builder().algo(mainArray.toString()).date(LocalDate.now()).build();
//        System.out.println("-------------------" + usr);
//        System.out.println("-------------------" + userRepo);
//        System.out.println("-------------------" + dataRepo);
//        userRepo.save(usr);
//
//
//    }

    @org.junit.Test
    public void testme2() {

        User usr = userRepo.findAll().get(1);

        System.out.println("----------USER---------" + usr);
        System.out.println("----------USER---------" + usr.getUserConfig());

        Map<String, List<JsonElement>> userconfig = usr.getUserConfig();
        userconfig.keySet().forEach(a -> {
            System.out.println("----data---" + userconfig.get(a).get(0).getAsJsonObject().get("value").getAsString());

//            System.out.println("----data---" + userconfig.get(a).get(0).getAsJsonObject().get("value").getAsString().replace("\"","") );


        });

        //userconfig.values().forEach(a -> {
        // System.out.println("----data---" + userconfig.get(a).get(0).getAsJsonObject().get("value").getAsString().replace("\"","") );
        //});


//
//        JsonArray convertedObject = new Gson().fromJson(usr.getAlgo(), JsonArray.class);
//
//
//        System.out.println("----------convertedObject---------" + convertedObject);
//
//        convertedObject.forEach(a -> {
//            System.out.println("----------*********************---------" + a);
//
//
//        });
//
//
//        System.out.println("-------------------" + convertedObject.getAsJsonArray());
//


//        usr.getAlgoAsJsonArray().forEach(jsonElement -> System.out.println("----------" + jsonElement.getAsJsonObject()));
//        usr.getAlgoAsJsonArray().forEach(jsonElement -> System.out.println("----------" + jsonElement.getAsJsonObject().get("id")));
//        System.out.println("--------------->>>>>>>>>>>>>>>>>>>>MA----" + usr.getMA());
//        System.out.println("--------------->>>>>>>>>>>>>>>>>>>>RSI----" + usr.getRSI());
//        System.out.println("--------------->>>>>>>>>>>>>>>>>>>>RSI----" + usr.getAlgoAsJsonArrayJackson());


    }

//    @org.junit.Test
//    public void testme3() {
//
//        ObjectMapper mapper = new ObjectMapper();
//        ArrayNode arrayNode = mapper.createArrayNode();
//
//        ObjectNode objectNode1 = mapper.createObjectNode();
//        objectNode1.put("id", "ma");
//        objectNode1.put("value", "0.2<50");
//        arrayNode.add(objectNode1);
//
//        objectNode1 = mapper.createObjectNode();
//        objectNode1.put("id", "ma");
//        objectNode1.put("value", "0.5<200");
//        arrayNode.add(objectNode1);
//
//        objectNode1 = mapper.createObjectNode();
//        objectNode1.put("id", "rsi");
//        objectNode1.put("value", "30<14");
//        arrayNode.add(objectNode1);
//        System.out.println("--------------->>>>>>>>>>>>>>>>>>>>MA----" + arrayNode);
//
//    }
//
//    @Autowired
//    CommentRepo commentRepo;
//
//    @org.junit.Test
//    public void testme4() {
//        Iterable<Comment> cc = commentRepo.findAll(QComment.comment.userid.eq("rowanf").and(QComment.comment.code.eq("abc.ax")));
//
//        System.out.println("--------------->>>>>>>>>>>>>>>>>>>>MA----" + cc);
//
//    }
//
//    @Autowired
//    NewsRepo newsRepo;
//
//    @org.junit.Test
//    public void testme5() {
//        ArrayList arr = new ArrayList<String>();
//        arr.add("BHP.AX");
//        arr.add("RIO.AX");
//
//        newsRepo.findAll(QNews.news.code.in(arr));
//
//        //System.out.println("--------------->>>>>>>>>>>>>>>>>>>>MA----" + cc);
//
//    }


}