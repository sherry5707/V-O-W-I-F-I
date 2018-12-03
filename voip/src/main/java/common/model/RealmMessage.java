package common.model;

import android.text.TextUtils;

import com.juphoon.cmcc.app.lemon.MtcImFileConstants;
import com.juphoon.rcs.JRClient;
import com.juphoon.rcs.JRLog;
import com.juphoon.rcs.JRMessageConstants;
import com.juphoon.rcs.JRMessageItem;

import common.CommonValue;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class RealmMessage extends RealmObject {
    public static final String TABLE_NAME = "RealmMessage";
    // basic
    public static final String FIELD_IMDN_ID = "imdnId";
    public static final String FIELD_PEER_PHONE = "peerPhone";
    public static final String FIELD_TYPE = "type";
    public static final String FIELD_SENDER_PHONE = "senderPhone";
    public static final String FIELD_CONTENT = "content";
    public static final String FIELD_STATE = "state";
    public static final String FIELD_TIME_STAMP = "timeStamp";
    public static final String FIELD_DISPLAY_NAME = "displayName";
    public static final String FIELD_IS_READ = "isRead";
    public static final String FIELD_IS_BURN_AFTER_READING = "isBurnAfterReading";
    // file
    public static final String FIELD_FILE_TRANS_ID = "fileTransId";
    public static final String FIELD_FILE_NAME = "fileName";
    public static final String FIELD_FILE_PATH = "filePath";
    public static final String FIELD_FILE_THUMB_PATH = "fileThumbPath";
    public static final String FIELD_FILE_SIZE = "fileSize";
    public static final String FIELD_FILE_TRANS_SIZE = "fileTransSize";
    public static final String FIELD_FILE_DURATION = "fileDuration";
    public static final String FIELD_FILE_PROGRESS = "fileProgress";
    public static final String FIELD_LATITUDE = "latitude";
    public static final String FIELD_LONGITUDE = "cardContent";
    public static final String FIELD_RADIUS = "radius";
    public static final String FIELD_LABEL = "label";


    @PrimaryKey
    private String imdnId;
    private String peerPhone;
    private int type;
    private String senderPhone;
    private String content;
    private int state;
    private long timeStamp;
    private String displayName;
    private boolean isRead;
    private boolean isBurnAfterReading;

    private String fileTransId;
    private String fileName;
    private String filePath;
    private String fileThumbPath;
    private int fileSize;
    private int fileTransSize;
    private int fileDuration;
    private int progress;

    //地理位置
    private double latitude;
    private double longitude;
    private float radius;
    private String label;

    public String getImdnId() {
        return imdnId;
    }

    public void setImdnId(String imdnId) {
        this.imdnId = imdnId;
    }

    public String getPeerPhone() {
        return peerPhone;
    }

    public void setPeerPhone(String peerPhone) {
        this.peerPhone = peerPhone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isBurnAfterReading() {
        return isBurnAfterReading;
    }

    public void setBurnAfterReading(boolean burnAfterReading) {
        isBurnAfterReading = burnAfterReading;
    }

    public String getFileTransId() {
        return fileTransId;
    }

    public void setFileTransId(String fileTransId) {
        this.fileTransId = fileTransId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileThumbPath() {
        return fileThumbPath;
    }

    public void setFileThumbPath(String fileThumbPath) {
        this.fileThumbPath = fileThumbPath;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public int getFileTransSize() {
        return fileTransSize;
    }

    public void setFileTransSize(int fileTransSize) {
        this.fileTransSize = fileTransSize;
    }

    public int getFileDuration() {
        return fileDuration;
    }

    public void setFileDuration(int fileDuration) {
        this.fileDuration = fileDuration;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public static RealmMessage itemToMessage(JRMessageItem item) {
        if (item == null) {
            return null;
        }
        RealmMessage message = new RealmMessage();
        message.imdnId = item.getImdnId();
        message.content = item.getText();
        message.timeStamp = item.getTimeStamp();
        message.peerPhone = item.getDirection() == JRMessageConstants.Direction.RECV ? item.getSenderNumber() : item.getRecvNumber();
        message.senderPhone = item.getSenderNumber();
        message.type = getMessageType(item);
        message.filePath = item.getFilePath();
        message.fileTransId = item.getTransId();
        message.fileThumbPath = item.getThumbPath();
        message.fileSize = item.getFileSize();
        message.fileTransSize = item.getTranferSize();
        message.label = item.getLabel();
        message.latitude = item.getLatitude();
        message.longitude = item.getLongitude();
        message.radius = item.getRadius();
        message.state = getMessageState(item);
        message.fileDuration = item.getDuration();
        return message;
    }

    public JRMessageItem messageToItem(RealmMessage message) {
        if (message == null) {
            return null;
        }
        JRMessageItem item = new JRMessageItem();
        item.setImdnId(message.getImdnId());
        item.setText(message.content);
        item.setTimeStamp(message.timeStamp);
        item.setSenderNumber(message.senderPhone);
        item.setRecvNumber(TextUtils.equals(message.senderPhone, message.peerPhone) ? JRClient.getInstance().getCurLoginNumber() : message.peerPhone);
        item.setDirection(TextUtils.equals(message.senderPhone, JRClient.getInstance().getCurLoginNumber()) ? JRMessageConstants.Direction.SEND : JRMessageConstants.Direction.RECV);
        item.setFilePath(message.filePath);
        item.setMessageType(getMessageType(message));
        item.setTransId(message.fileTransId);
        item.setThumbPath(message.fileThumbPath);
        item.setFileSize(message.fileSize);
        item.setTranferSize(message.fileTransSize);
        item.setFileType(getFileType(message));
        item.setLabel(message.label);
        item.setLatitude(message.latitude);
        item.setLongitude(message.longitude);
        item.setRadius(message.radius);
        item.setState(getMessageState(message));
        item.setDuration(message.fileDuration);
        return item;
    }

    private static int getMessageType(JRMessageItem item) {
        switch (item.getMessageType()) {
            case AUDIO:
                return CommonValue.MESSAGE_TYPE_AUDIO;
            case GEO:
                return CommonValue.MESSAGE_TYPE_GEO;
            case IMAGE:
                return CommonValue.MESSAGE_TYPE_IMAGE;
            case LMSG:
                return CommonValue.MESSAGE_TYPE_LMSG;
            case OTHER_FILE:
                return CommonValue.MESSAGE_TYPE_OTHER_FILE;
            case VCARD:
                return CommonValue.MESSAGE_TYPE_VCARD;
            case PMSG:
                return CommonValue.MESSAGE_TYPE_PMSG;
            case VIDEO:
                return CommonValue.MESSAGE_TYPE_VIDEO;
        }
        return CommonValue.MESSAGE_TYPE_UNKNOWN;
    }

    private static JRMessageConstants.Type getMessageType(RealmMessage message) {
        switch (message.type) {
            case CommonValue.MESSAGE_TYPE_AUDIO:
                return JRMessageConstants.Type.AUDIO;
            case CommonValue.MESSAGE_TYPE_GEO:
                return JRMessageConstants.Type.GEO;
            case CommonValue.MESSAGE_TYPE_IMAGE:
                return JRMessageConstants.Type.IMAGE;
            case CommonValue.MESSAGE_TYPE_LMSG:
                return JRMessageConstants.Type.LMSG;
            case CommonValue.MESSAGE_TYPE_OTHER_FILE:
                return JRMessageConstants.Type.OTHER_FILE;
            case CommonValue.MESSAGE_TYPE_VCARD:
                return JRMessageConstants.Type.VCARD;
            case CommonValue.MESSAGE_TYPE_PMSG:
                return JRMessageConstants.Type.PMSG;
            case CommonValue.MESSAGE_TYPE_VIDEO:
                return JRMessageConstants.Type.VIDEO;
        }
        return JRMessageConstants.Type.UNKNOWN;
    }

    private String getFileType(RealmMessage message) {
        switch (message.type) {
            case CommonValue.MESSAGE_TYPE_AUDIO:
                return MtcImFileConstants.MTC_IM_FILE_CONT_AUDIO_AMR;
            case CommonValue.MESSAGE_TYPE_IMAGE:
                return MtcImFileConstants.MTC_IM_FILE_CONT_IMG_JPEG;
            case CommonValue.MESSAGE_TYPE_OTHER_FILE:
                return MtcImFileConstants.MTC_IM_FILE_CONT_APP_OSTRM;
            case CommonValue.MESSAGE_TYPE_VIDEO:
                return MtcImFileConstants.MTC_IM_FILE_CONT_VIDEO_MP4;
        }
        return "";
    }

    private static int getMessageState(JRMessageItem item) {
        switch (item.getState()) {
            case RECEIVE_FAILED:
                return CommonValue.MESSAGE_STATUS_RECV_FAILED;
            case RECEIVE_OK:
                return CommonValue.MESSAGE_STATUS_RECV_OK;
            case RECEIVEING_PAUSE:
                return CommonValue.MESSAGE_STATUS_RECV_PAUSED;
            case RECEIVEING:
                return CommonValue.MESSAGE_STATUS_RECVING;
            case RECEIVE_INVITE:
                return CommonValue.MESSAGE_STATUS_INVITE;
            case SEND_FAILED:
                return CommonValue.MESSAGE_STATUS_SEND_FAILED;
            case SEND_OK:
                return CommonValue.MESSAGE_STATUS_SEND_OK;
            case SENDING:
                return CommonValue.MESSAGE_STATUS_SENDING;
            case SENDING_PAUSE:
                return CommonValue.MESSAGE_STATUS_SEND_PAUSED;
        }
        return CommonValue.MESSAGE_STATUS_UNKNOWN;
    }

    private static JRMessageConstants.State getMessageState(RealmMessage message) {
        switch (message.state) {
            case CommonValue.MESSAGE_STATUS_RECV_FAILED:
                return JRMessageConstants.State.RECEIVE_FAILED;
            case CommonValue.MESSAGE_STATUS_RECV_OK:
                return JRMessageConstants.State.RECEIVE_OK;
            case CommonValue.MESSAGE_STATUS_RECV_PAUSED:
                return JRMessageConstants.State.RECEIVEING_PAUSE;
            case CommonValue.MESSAGE_STATUS_RECVING:
                return JRMessageConstants.State.RECEIVEING;
            case CommonValue.MESSAGE_STATUS_INVITE:
                return JRMessageConstants.State.RECEIVE_INVITE;
            case CommonValue.MESSAGE_STATUS_SEND_FAILED:
                return JRMessageConstants.State.SEND_FAILED;
            case CommonValue.MESSAGE_STATUS_SEND_OK:
                return JRMessageConstants.State.SEND_OK;
            case CommonValue.MESSAGE_STATUS_SENDING:
                return JRMessageConstants.State.SENDING;
            case CommonValue.MESSAGE_STATUS_SEND_PAUSED:
                return JRMessageConstants.State.SENDING_PAUSE;
        }
        return JRMessageConstants.State.INIT;
    }

    public boolean isSender() {
        return state == CommonValue.MESSAGE_STATUS_SEND_FAILED || state == CommonValue.MESSAGE_STATUS_SEND_OK || state == CommonValue.MESSAGE_STATUS_SEND_PAUSED || state == CommonValue.MESSAGE_STATUS_SENDING;
    }

    public boolean isVideo() {
        return type == CommonValue.MESSAGE_TYPE_VIDEO;
    }

    public boolean isImage() {
        return type == CommonValue.MESSAGE_TYPE_IMAGE;
    }

    public boolean isSuccess() {
        return state == CommonValue.MESSAGE_STATUS_RECV_OK;
    }
}
