package com.kinstalk.her.voipmode.data;

import android.util.Log;

import com.github.promeg.pinyinhelper.Pinyin;

public class ContactInfo {
    private int id;
    private String phoneNumber;
    private String nickname;
    /**
     * 排序字母
     */
    private String sortKey = "";

    public ContactInfo() {
    }

    /**
     *
     * @param phoneNumber
     * @param nickname
     */
    public ContactInfo(String phoneNumber, String nickname) {
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
    }

    public ContactInfo(int id, String phoneNumber, String nickname) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
    }

    public void setInfo(String phoneNumber, String nickname, String sortKey) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
        this.sortKey = sortKey;
    }

    public String getId() {
        return String.valueOf(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        for (char c : nickname.toCharArray()) {
            this.sortKey = sortKey + Pinyin.toPinyin(c);
        }
        Log.i("ContactInfo", "setNickname,sortKey:"+sortKey);
        this.nickname = nickname;
    }

    public String getSortKey() {
        return sortKey;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "id='" + id + '\'' +
                ", contactId='" + phoneNumber + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sortKey='" + sortKey + '\'' +
                '}';
    }
}
