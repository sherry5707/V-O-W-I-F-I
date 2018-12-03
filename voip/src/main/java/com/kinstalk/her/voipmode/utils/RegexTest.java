package com.kinstalk.her.voipmode.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    private static final String[] voiceTest = {
            "你能帮我放一首周杰伦的稻香吗",
            "你能帮我放一首稻香吗",
            "帮我放一首周杰伦的稻香",
            "我想听一首日文歌",
            "我想听一首民谣",
            "我想听一首爵士",
            "我想听一首英文歌",
            "我想听专辑七里香",
            "我想听周杰伦的稻香",
            "我想听安静的歌",
            "我想听我喜欢的歌",
            "我要听专辑七里香",
            "我想听歌",
            "我想听消愁",
            "我要听周杰伦的稻香",
            "我要听嘻哈说唱",
            "我要听周杰伦的歌",
            "我要听薛之谦的演员",
            "我要听歌",
            "我要听稻香",
            "播放我的歌单",
            "我要听儿歌",
            "播放十年",
            "播放适合运动的歌曲",
            "来一首毛不易的歌",
            "播放音乐",
            "给我推荐一首歌吧",
            "给我播放专辑七里香的歌",
            "给我放一首music",
            "给我放一首摇滚歌",
            "能不能帮我放首歌",
            "打电话给孟照雪"
    };

    public static void runTest(){
        int j = 0;
        ArrayList<RegexItem> regexList = new RegexList().contents;

        for (int i = 0; i < voiceTest.length; i++ ) {
            String line = voiceTest[i];
            int k = 0;

            for (int num = 0; num < regexList.size(); num++) {
                int n;

                Pattern r = regexList.get(num).regex;
                String[] tags = regexList.get(num).tags;

                // 现在创建 matcher 对象
                Matcher m = r.matcher(line);
                if (m.find()) {
                    System.out.println("Pattern: " + r.pattern());
                    System.out.println(line + ">>> Much: " + m.group(0));
                    for (int seq = 1; seq <= tags.length; seq++){
                        System.out.println(tags[seq - 1] + ": " + m.group(seq));
                    }
                    k++;
                } else {
                    //System.out.println("NO MATCH: " + line);
                }
            }

            if (k > 0) {
                j++;
            } else {
                System.out.println("NO MATCH: " + line);
            }
        }

        if (j == voiceTest.length){
            System.out.println("All example was parsered.");
        } else{
            System.out.println("Total: " + voiceTest.length + ". Matched: " + j);
        }
    }
}
