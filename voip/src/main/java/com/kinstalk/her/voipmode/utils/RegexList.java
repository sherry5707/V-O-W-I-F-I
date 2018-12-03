package com.kinstalk.her.voipmode.utils;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class RegexList {
    public ArrayList<RegexItem> contents;

    {
        contents = new ArrayList<>();

//        contents.add(new RegexItem(Pattern.compile("^(?:听一首|来一首)(.{1,})(?<!歌)$"), new String[]{"tag"}));
//        contents.add(new RegexItem(Pattern.compile("^(?:听一首|来一首)(.{1,})歌$"), new String[]{"tag"}));
//
//        contents.add(new RegexItem(Pattern.compile("(?:放|听)(?:一首|首)*(?:(.{1,})的)+(.{1,})(?:吗|歌)$"), new String[]{"singer","song"}));
//        contents.add(new RegexItem(Pattern.compile("(?:放|听)(?:一首|首)*(?:(.{1,})的)+(.{1,})(?<!吗|歌)$"), new String[]{"singer","song"}));
//
//        contents.add(new RegexItem(Pattern.compile("(?:放|听)(?:一首|首)+([^的]{1,})(?:吗|歌)$"), new String[]{"song"}));
//        contents.add(new RegexItem(Pattern.compile("(?:放|听)(?:一首|首)+([^的]{1,})(?<!吗|歌)$"), new String[]{"song"}));
//
//        contents.add(new RegexItem(Pattern.compile("(专辑)(.*)的歌$"),new String[]{"type","name"}));
//        contents.add(new RegexItem(Pattern.compile("(专辑)(.*)(?<!的歌)$"),new String[]{"type","name"}));
//
//        contents.add(new RegexItem(Pattern.compile("(?:要|想)(?:听|播放)我?(.*)的(.*)(歌|歌曲)$"), new String[]{"singer","song"}));
//        contents.add(new RegexItem(Pattern.compile("(?:要|想)(?:听|播放)我?(.*)的(.*)(?<!歌)$"), new String[]{"singer","song"}));
//        contents.add(new RegexItem(Pattern.compile("(?:要|想)(?:听|播放)([^的歌]*)(?<!歌)$"), new String[]{"singer|song"}));
//
//        contents.add(new RegexItem(Pattern.compile("我(?:要|想)听()()歌"), new String[]{"singer","song"}));
//        contents.add(new RegexItem(Pattern.compile("(?:播放音乐|给我推荐一首歌吧|帮我放首歌)()()"), new String[]{"singer","song"}));
        contents.add(new RegexItem(Pattern.compile("打电话给+(.{1,})"),new String[]{"contact"},"makeCall"));
        contents.add(new RegexItem(Pattern.compile("给(?:(.{1,}))+打电话"),new String[]{"contact"},"makeCall"));
        //contents.add(new RegexItem(Pattern.compile(""), new String[]{}));
    }
}
