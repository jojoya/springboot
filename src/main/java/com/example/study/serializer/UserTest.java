package com.example.study.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.junit.Assert;

import java.util.Date;

/**
 * Created by user on 2018/1/4.
 */
public class UserTest {

    public static void test_entity() throws Exception {
        Entity entity = new Entity(123, new Object());

        Assert.assertSame(entity.getValue(), JSONPath.eval(entity, "$.value"));
        Assert.assertTrue(JSONPath.contains(entity, "$.value"));
        Assert.assertTrue(JSONPath.containsValue(entity, "$.id", 123));
        Assert.assertTrue(JSONPath.containsValue(entity, "$.value", entity.getValue()));
        Assert.assertEquals(2, JSONPath.size(entity, "$"));
//        Assert.assertEquals(0, JSONPath.size(new Object[],"$"));
    }

    public static class Entity {
        private Integer id;
        private String name;
        private Object value;

        public Entity() {}
        public Entity(Integer id, Object value) { this.id = id; this.value = value; }
        public Entity(Integer id, String name) { this.id = id; this.name = name; }
        public Entity(String name) { this.name = name; }

        public Integer getId() { return id; }
        public Object getValue() { return value; }
        public String getName() { return name; }

        public void setId(Integer id) { this.id = id; }
        public void setName(String name) { this.name = name; }
        public void setValue(Object value) { this.value = value; }
    }

    public static void main(String [] args) throws Exception{

        // JSONType includes
        Uo1 uo1 = new Uo1();
        uo1.setAge(10);
        uo1.setDate(new Date());
        uo1.setId(1);
        uo1.setName("李Inner");
        uo1.setSex("男Inner");
        System.out.println("@JSONType includes --> " + JSON.toJSONString(uo1));


        // JSONType ignores
        Uo uo = new Uo();
        uo.setAge(10);
        uo.setDate(new Date());
        uo.setId(1);
        uo.setName("李outer");
        uo.setSex("男outer");
        uo.setInfo(uo1);
        System.out.println("@JSONType ignores --> " + JSON.toJSONString(uo));


        // 序列化的时候, 不序列化id, sex字段序列化成gender
        User user = new User();
        user.setAge(10);
        user.setDate(new Date());
        user.setId(1);
        user.setName("李四");
        user.setSex("男");
        System.out.println("@JSONField --> " + JSON.toJSONString(user));

        UserTest.test_entity();
    }


}
