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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
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
public class User implements UserDetails, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public LocalDate date;
    public String username;
    private String password;
    private GrantedAuthority authority;

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

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> arr = new ArrayList<>();
//        arr.add(authority);
//        return arr;
//    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> arr = new ArrayList<>();
        // arr.add(a);
        arr.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "can_read";
            }
        });
        return arr;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
////////////////////////////////////////////////////////////////
// class Authority implements GrantedAuthority {
//    private String name;
//    @Override
//    public String getAuthority() {
//        return getName();
//    }
//}
