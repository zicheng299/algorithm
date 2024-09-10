package com.interview.domain;

import lombok.Data;
@Data
public class DemoEntity {


    private Integer id;

    private String name;


    @Override
    public boolean equals(Object obj) {
        DemoEntity entity = (DemoEntity) obj;
        return (this.name == entity.getName());
    }

//    public int hashCode() {
//        return this.name.hashCode();
//    }

}
