package com.dhamma.pesistence.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Test {


    private static final ObjectMapper mapper = new ObjectMapper();

    public static ArrayNode getNodes() {

        ArrayNode gamesNode = mapper.createArrayNode();

        ObjectNode game1 = mapper.createObjectNode().objectNode();
        game1.put("name", "Fall Out 4");
        game1.put("price", 49.9);

        ObjectNode game2 = mapper.createObjectNode().objectNode();
        game2.put("name", "Dark Soul 3");
        game2.put("price", 59.9);

        gamesNode.add(game1);
        gamesNode.add(game2);
        return gamesNode;
    }


    public static ArrayNode getNodes2() {
        try {
            
            return (ArrayNode) mapper.readValue("hello1 , hello2 , hello3", ArrayNode.class);

        } catch (Exception e) {
            System.out.println("-----------" + e);
        }
        return null;

    }






}
