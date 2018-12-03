package common.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RealmConversation extends RealmObject {

    public static final String TABLE_NAME = "RealmConversation";
    public static final String FIELD_UID = "uid";
    public static final String FIELD_PEER_PHONE = "peerPhone";
    public static final String FIELD_UPDATE_TIME = "updateTime";
    public static final String FIELD_LAST_MESSAGE = "lastMessage";
    public static final String FIELD_IS_NOTIFY = "isNotify";
    public static final String FIELD_IS_STICK = "isStick";
    public static final String FIELD_IS_SHOW_NAME = "isShowName";
    public static final String FIELD_UNREAD_COUNT = "unReadCount";

    @PrimaryKey
    private String uid;
    private String peerPhone;
    private long updateTime;
    private String lastMessage;
    private boolean isNotify;
    private boolean isStick;
    private boolean isShowName;
    private int unReadCount;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPeerPhone() {
        return peerPhone;
    }

    public void setPeerPhone(String peerPhone) {
        this.peerPhone = peerPhone;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public boolean isNotify() {
        return isNotify;
    }

    public void setNotify(boolean notify) {
        isNotify = notify;
    }

    public boolean isStick() {
        return isStick;
    }

    public void setStick(boolean stick) {
        isStick = stick;
    }

    public boolean isShowName() {
        return isShowName;
    }

    public void setShowName(boolean showName) {
        isShowName = showName;
    }

    public int getUnReadCount() {
        return unReadCount;
    }

    public void setUnReadCount(int unReadCount) {
        this.unReadCount = unReadCount;
    }

}
