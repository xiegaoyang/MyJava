package com.xgy;

import org.json.JSONException;

/**
 * Created by gowild.cn on 2017/5/19.
 */
public class MyJson {

    public static void main(String[] args) throws JSONException {

//        String responseContent = "[{\"actionCode\": \"061\", \"deltaTime\": \"550.21905899\", \"emotion\": {\"fine-grained\": \"中性\", \"polar\": \"中性\", \"subject\": \"中性\"}, \"exptime\": \"\", \"func\": {\"detail\": {\"actionCode\": \"061\", \"artist\": \"萧芳芳\", \"code\": \"train\", \"composer\": \">刘宏远\", \"detail\": \"\", \"duration\": \"900000\", \"endTime\": \"\", \"errCount\": 3, \"level\": 1, \"musicId\": \"004\", \"name\": \"钢琴\", \"songId\": \"06101004\", \"startTime\": \"\", \"subType\": \"061\", \"title\": \">世上只有妈妈好\"}, \"type\": \"train\"}, \"intent_code\": {\"emotion\": \"000000\", \"intent\": \"040003\", \"primary_intent\": \"040000\", \"reject\": \"000000\", \"sub_intent\": \"000000\"}, \"mid\": \"44:2c:05:75:ad:ec\", \"orgtext\": \"训练钢琴\", \"sayCode\": \"128\", \"segtext\": \"训练 钢琴\", \"text\": \"知道了，那我去训练喽.我也好想快快的升到下一级呢，我就快达成目标了哦.\", \"uid\": \"13682556360\", \"uid4prop\": \"846,213,130.80908800000003,29\", \"zintent\": {}, \"ztriple\": {}}]\n";
//        JSONArray responseJSONArray = new JSONArray(responseContent);
//        JSONObject responseJSON = null;
//
//        for (int i = 0; i < responseJSONArray.length(); i++) {
//            responseJSON = responseJSONArray.optJSONObject(i);
//            if (responseJSON == null) {
//                continue;
//            }
//
//            JSONObject codeJson = responseJSON.getJSONObject("intent_code");
//            String primary_intent = codeJson.optString("primary_intent");
//            System.out.println(primary_intent);
//
//        }

    }

}
