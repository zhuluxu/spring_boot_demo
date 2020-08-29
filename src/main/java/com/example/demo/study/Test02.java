package com.example.demo.study;

import com.example.demo.model.vo.UserInfoVO;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

/**
 * @author didi
 */
public class Test02 {

    private static int PII_CANCEL_BATCH_SIZE = 2;

    public static void main(String[] args) {
        Gson gson = new Gson();
        List<UserInfoVO> listPiiCancel = Lists.newArrayList(new UserInfoVO(),new UserInfoVO(),new UserInfoVO());
        System.out.println(gson.toJson(listPiiCancel));
        JsonObject asJsonObject = gson.fromJson("{\n" +
                "    \"msg\": \"更新成功\",\n" +
                "    \"data\": {},\n" +
                "    \"errno\": 0\n" +
                "}", JsonElement.class).getAsJsonObject();
        System.out.println(asJsonObject.get("msg"));


        int num = listPiiCancel.size() / PII_CANCEL_BATCH_SIZE + 1;
        for (int i = 0; i < num; i++) {
            int fromIndex = PII_CANCEL_BATCH_SIZE * i;
            int toIndex = Math.min(fromIndex + PII_CANCEL_BATCH_SIZE, listPiiCancel.size());
            if (fromIndex >= toIndex) {
                break;
            }
            System.out.println(listPiiCancel.subList(fromIndex,toIndex));

        }
    }
}
