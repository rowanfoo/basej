package com.dhamma.pesistence.entity.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public LocalDate date;
    public String username;
    private String password;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String algo;

    @JsonIgnore
    public List<JsonElement> getAlgoAsJsonArray() {
        return Lists.newArrayList(new Gson().fromJson(algo, JsonArray.class).iterator());
    }

    @JsonIgnore
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

    @JsonIgnore
    public Map<String, List<JsonElement>> getUserConfig() {
        Map<String, List<JsonElement>> groupByPriceMap =
                getAlgoAsJsonArray().stream().collect(Collectors.groupingBy(a -> {
                            return a.getAsJsonObject().get("id").getAsString();
                        }

                ));
        return groupByPriceMap;
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
