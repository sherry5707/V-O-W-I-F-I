package common;

import android.content.Context;
import android.text.TextUtils;

import com.juphoon.cmcc.app.lemon.MtcCliDb;
import com.juphoon.rcs.JRClient;
import com.juphoon.rcs.JRMessageItem;

import common.model.RealmConversation;
import common.model.RealmMessage;
import io.realm.Realm;

/**
 * Created by Upon on 2018/2/27.
 */

public class RealmDataHelper {
    //    private static Realm sRealm;
    private static Context sContext;

    public static void init(Context context) {
        sContext = context;
//        if (sRealm != null) {
//            sRealm.close();
//        }
//        sRealm = RealmHelper.getInstance();
    }

    public static void insertOrUpdateMessageAsync(Realm realm, final JRMessageItem messageItem) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmMessage message = RealmMessage.itemToMessage(messageItem);
                realm.insertOrUpdate(message);
            }
        });
    }

    public static void insertOrUpdateMessage(Realm realm, final JRMessageItem messageItem) {
        if(realm == null){
            return;
        }
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmMessage message = RealmMessage.itemToMessage(messageItem);
                realm.insertOrUpdate(message);
                insertOrUpdateConversation(realm, message.getPeerPhone(), message.getContent() == null ? "" : message.getContent());

            }
        });
    }

    public static void insertOrUpdateConversationAsync(Realm realm, final String peerNumber, final String msg) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmConversation conversation = realm.where(RealmConversation.class)
                        .equalTo(RealmConversation.FIELD_UID, peerNumber).findFirst();
                if (conversation != null) {
                    conversation.setUpdateTime(System.currentTimeMillis());
                    conversation.setLastMessage(msg);
                }
            }
        });
    }

    public static void insertOrUpdateConversation(Realm realm, final String peerNumber, final String msg) {
        RealmConversation conversation = realm.where(RealmConversation.class)
                .equalTo(RealmConversation.FIELD_PEER_PHONE, peerNumber).findFirst();
        if (conversation != null) {
            conversation.setUpdateTime(System.currentTimeMillis());
            conversation.setLastMessage(msg);
        } else {
            conversation = new RealmConversation();
            conversation.setPeerPhone(peerNumber);
            conversation.setUid(System.currentTimeMillis() + "");
            conversation.setLastMessage(msg);
            conversation.setUpdateTime(System.currentTimeMillis());
        }
        realm.insertOrUpdate(conversation);
    }

    private static RealmConversation tectonicConversation(RealmMessage message) {
        RealmConversation conversation = new RealmConversation();
        conversation.setPeerPhone(message.getPeerPhone());
        conversation.setUid(message.getPeerPhone());
        if (!TextUtils.isEmpty(message.getContent())) {
            conversation.setLastMessage(message.getContent() + "");
        }
        conversation.setUpdateTime(message.getTimeStamp());
        return conversation;
    }
}
