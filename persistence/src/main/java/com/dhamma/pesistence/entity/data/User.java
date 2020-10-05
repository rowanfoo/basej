package com.dhamma.pesistence.entity.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
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

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    List<UserConfig> userConfig;

//    @JsonIgnore
//    public List<JsonElement> getAlgoAsJsonArray() {
//        return Lists.newArrayList(new Gson().fromJson(algo, JsonArray.class).iterator());
//    }

//    @JsonIgnore
//    public ArrayNode getAlgoAsJsonArrayJackson() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        ArrayNode pp1 = null;
//        try {
//            pp1 = objectMapper.readValue(algo, ArrayNode.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return pp1;
//
//    }

//    @JsonIgnore
//    public Map<String, List<JsonElement>> getUserConfig() {
//        Map<String, List<JsonElement>> groupByPriceMap =
//                getAlgoAsJsonArray().stream().collect(Collectors.groupingBy(a -> {
//                            return a.getAsJsonObject().get("id").getAsString();
//                        }
//
//                ));
//        return groupByPriceMap;
//    }

    @JsonIgnore
    public Map<IndicatorType, List<UserConfig>> getUserConfigMap() {
        Map<IndicatorType, List<UserConfig>> map = userConfig.stream().collect(Collectors.groupingBy(a -> {
                    return ((UserConfig) a).getType();
                }
        ));
        return map;
    }


    @JsonIgnore
    public List<UserConfig> getUserConfigType(IndicatorType type) {
//    public Map<String, List<JsonElement>> getUserConfig(IndicatorType type) {
//        Map<String, List<JsonElement>> groupByPriceMap =
//                getAlgoAsJsonArray().stream().collect(Collectors.groupingBy(a -> {
//                            return a.getAsJsonObject().get("id").getAsString();
//                        }
//
//                ));
//        return groupByPriceMap;
//        Map<IndicatorType, List<UserConfig>> map = userConfig.stream().collect(Collectors.groupingBy(a -> {
//                    return ((UserConfig) a).getType();
//                }
//        ));

        return getUserConfigMap().get(type);
    }


//    private List<JsonElement> getArray(String var) {
//
//        Map<String, List<JsonElement>> groupByPriceMap =
//                getAlgoAsJsonArray().stream().collect(Collectors.groupingBy(a -> {
//                            return a.getAsJsonObject().get("id").getAsString();
//                        }
//                ));
//        return groupByPriceMap.get(var);
//    }


}
