package com.dhamma.pesistence.entity.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public LocalDate date;
    public String name;
    public String userid;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String algo;
    @Transient
    private List<JsonElement> MA;
    @Transient
    private List<JsonElement> RSI;
    @Transient
    private List<JsonElement> FALLTODAY;


    public List<JsonElement> getAlgoAsJsonArray() {
        return Lists.newArrayList(new Gson().fromJson(algo, JsonArray.class).iterator());
    }

    public ArrayNode getAlgoAsJsonArrayJackson() {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode pp1 = null;
        try {
            pp1 = objectMapper.readValue(algo, ArrayNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pp1;

    }


    public List<JsonElement> getMA() {
        if (MA == null) {
            MA = getArray("ma");
        }
        return MA;
    }

    public List<JsonElement> getRSI() {
        if (RSI == null) {
            RSI = getArray("rsi");
        }
        return RSI;
    }

    public List<JsonElement> getFALLTODAY() {
        if (RSI == null) {
            RSI = getArray("falltoday");
        }
        return RSI;
    }


    private List<JsonElement> getArray(String var) {
        Map<String, List<JsonElement>> groupByPriceMap =
                getAlgoAsJsonArray().stream().collect(Collectors.groupingBy(a -> {
                            return a.getAsJsonObject().get("id").getAsString();
                        }

                ));
        return groupByPriceMap.get(var);
    }


}
