package com.kinstalk.her.voipmode.data;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.util.Log;

import com.kinstalk.her.dialer.database.DialerDatabaseHelper;
import com.kinstalk.her.vowifivoip.MainApplication;

import java.util.List;

/**
 * create to use ContentProvider
 */
public class MyDBProviderHelper {
    private static final String TAG = "MyDBProviderHelper";

    public static int insertAllContacts(List<ContactInfo> contacts) {
        Log.i(TAG, "insertAllContacts: " + contacts);
        int status = 0;
        ContentResolver resolver = MainApplication.sApp.getContentResolver();
        try {
            Log.i(TAG, "insertContacts");
            ContentValues values = new ContentValues();
            for (ContactInfo contact : contacts) {
                values.clear();
                values.put(DialerDatabaseHelper.AllContactsColumns.CONTACT_ID, contact.getPhoneNumber());
                values.put(DialerDatabaseHelper.AllContactsColumns.NICK_NAME, contact.getNickname());
                values.put(DialerDatabaseHelper.AllContactsColumns.SORT_KEY, contact.getSortKey());
                resolver.insert(DialerDatabaseHelper.AllContactsColumns.CONTENT_URI, values);
            }
        } catch (SQLException e) {
            Log.e(TAG, "insertAllContacts: exception:" + e);
            status = -1;
        }
        return status;
    }

    public static int insertContact(ContactInfo contact) {
        Log.i(TAG, "insertAllContacts: " + contact);
        int status = 0;
        ContentResolver resolver = MainApplication.sApp.getContentResolver();
        try {
            Log.i(TAG, "insertContacts");
            ContentValues values = new ContentValues();
            values.clear();
            values.put(DialerDatabaseHelper.AllContactsColumns.CONTACT_ID, contact.getPhoneNumber());
            values.put(DialerDatabaseHelper.AllContactsColumns.NICK_NAME, contact.getNickname());
            values.put(DialerDatabaseHelper.AllContactsColumns.SORT_KEY, contact.getSortKey());
            resolver.insert(DialerDatabaseHelper.AllContactsColumns.CONTENT_URI, values);
        } catch (SQLException e) {
            Log.e(TAG, "insertAllContacts: exception:" + e);
            status = -1;
        }
        return status;
    }

    public static int clearContactsDB() {
        Log.i(TAG, "clearMyOwnContactsDB: ");
        int status = 0;
        ContentResolver resolver = MainApplication.sApp.getContentResolver();
        try {
            resolver.delete(DialerDatabaseHelper.AllContactsColumns.CONTENT_URI,
                    DialerDatabaseHelper.AllContactsColumns.CONTACT_ID + "!=-1", null);
        } catch (SQLException e) {
            Log.e(TAG, "clearContactsDB: exception:" + e);
            e.printStackTrace();
            status = -1;
        }
        return status;
    }

    public static int deleteContact(String name) {
        int status = 0;
        ContentResolver resolver = MainApplication.sApp.getContentResolver();
        try {
            resolver.delete(DialerDatabaseHelper.AllContactsColumns.CONTENT_URI,
                    DialerDatabaseHelper.AllContactsColumns.NICK_NAME + " =? ",
                    new String[]{name});
        } catch (SQLException e) {
            e.printStackTrace();
            status = -1;
        }
        return status;
    }

    @SuppressLint("MissingPermission")
    public static void insertCallRecord(Context context, CallRecord record) {
        Log.i(TAG, "insertCallRecord: record:" + record);
        ContentValues values = new ContentValues();
        values.put(CallLog.Calls.CACHED_NAME, record.getmName());
        values.put(CallLog.Calls.NUMBER, record.getmNumber());
        //CallLog.Calls.OUTGOING_TYPE 外拨
        //CallLog.Calls.INCOMING_TYPE 接入
        //CallLog.Calls.MISSED_TYPE 未接
        values.put(CallLog.Calls.TYPE, record.getmCallLogType());
        values.put(CallLog.Calls.DATE, record.getmCallLogDate());
        values.put(CallLog.Calls.NEW, "0");// 0已看1未看 ,由于没有获取默认全为已读
        Log.e(TAG, "insertCallRecord: values:" + values.toString());
        Uri uri = context.getContentResolver().insert(CallLog.Calls.CONTENT_URI, values);
        Log.i(TAG, "insertCallRecord: uri:" + uri);
    }

    public static int clearSystemContactsDB() {
        Log.i(TAG, "clearSystemContactsDB: ");
        int status = 0;
        try {
            Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
            MainApplication.sApp.getContentResolver().delete(uri, "_id!=-1", null);
        } catch (SQLException e) {
            Log.e(TAG, "clearContactsDB: exception:" + e);
            status = -1;
        }
        return status;
    }

    /**
     * 首先向RawContacts.CONTENT_URI执行一个空值插入，目的是获取系统返回的rawContactId
     * 后面插入data表的数据，只有执行空值插入，才能使插入的联系人在通讯录里可见
     */
    public static void insertContactToSystemDB(List<ContactInfo> contacts) {
        try {
            Log.i(TAG, "insertTestDataToContactsDB: contacts:" + contacts.toString());
            ContentValues values = new ContentValues();
            for (ContactInfo contact : contacts) {
                values.clear();
                Uri rawContactUri = MainApplication.sApp.getContentResolver().insert(
                        ContactsContract.RawContacts.CONTENT_URI, values);
                long rawContactId = ContentUris.parseId(rawContactUri);
                //往data表入姓名数据
                values.clear();
                values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
                values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);// 内容类型
                values.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, contact.getNickname());
                MainApplication.sApp.getContentResolver().insert(ContactsContract.Data.CONTENT_URI,
                        values);

                //往data表入电话数据
                values.clear();
                values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
                values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
                values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, contact.getPhoneNumber());
                values.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
                MainApplication.sApp.getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
            }
        } catch (SQLException e) {
            Log.e(TAG, "clearContactsDB: exception:" + e);
        }
    }

    /**
     * 首先向RawContacts.CONTENT_URI执行一个空值插入，目的是获取系统返回的rawContactId
     * 后面插入data表的数据，只有执行空值插入，才能使插入的联系人在通讯录里可见
     */
    public static int insertContactToSystemDB(ContactInfo contact) {
        int status = 0;
        try {
            Log.i(TAG, "insertTestDataToContactsDB: contacts:" + contact.toString());
            ContentValues values = new ContentValues();
            values.clear();
            Uri rawContactUri = MainApplication.sApp.getContentResolver().insert(
                    ContactsContract.RawContacts.CONTENT_URI, values);
            long rawContactId = ContentUris.parseId(rawContactUri);
            //往data表入姓名数据
            values.clear();
            values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
            values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);// 内容类型
            values.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, contact.getNickname());
            MainApplication.sApp.getContentResolver().insert(ContactsContract.Data.CONTENT_URI,
                    values);

            //往data表入电话数据
            values.clear();
            values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
            values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
            values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, contact.getPhoneNumber());
            values.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
            MainApplication.sApp.getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
        } catch (SQLException e) {
            Log.e(TAG, "clearContactsDB: exception:" + e);
            status = -1;
        }
        return status;
    }

    /**
     * 根据contactId查找联系人
     *
     * @param context
     * @param contactId
     * @return
     */
    public static ContactInfo getContactByContactIdFromSystemDB(Context context, String contactId) {
        Log.i(TAG, "getContactByContactIdFromSystemDB: contactID:"+contactId);
        //uri=  content://com.android.contacts/data/phones/filter/#
        Cursor cursor = null;
        try {
//            Uri uri = Uri.parse("content://com.android.contacts/data/phones/filter/" + number);
            //先判断该number是否为contactId
            ContentResolver resolver = context.getContentResolver();
            cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    new String[]{ContactsContract.Data.DISPLAY_NAME},
                    ContactsContract.CommonDataKinds.Phone.NUMBER + " = ?",
                    new String[]{contactId}, null); //从raw_contact表中返回display_name
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                String nickName = cursor.getString(0);
                ContactInfo contact = new ContactInfo(contactId, nickName);
                return contact;
            }
        } catch (SQLException e) {
            Log.e(TAG, "getContactByContactIdFromSystemDB: exception:" + e);
            e.printStackTrace();
            return null;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }

    /**
     * 根据姓名获得contactInfo
     *
     * @param context
     * @param nickName
     * @return
     */
    public static ContactInfo getContactByNickName(Context context, String nickName) {
        Log.i(TAG, "getContactByNickName: nickName:" + nickName);
        Cursor cursor = null;
        ContactInfo contact = null;
        try {
            ContentResolver resolver = context.getContentResolver();
            //view_data表中displayName相同的的值会有两行，一行的data1是number，一行是name
            //根据mimeType区分。
            //我的selection语句是:display_name = 'nickName' & mimeType = 'phone'
            cursor = resolver.query(ContactsContract.Data.CONTENT_URI,
                    new String[]{"data1"},
                    ContactsContract.Data.DISPLAY_NAME + "= \'" + nickName + "\' and " +
                            ContactsContract.Data.MIMETYPE + "= \'" + ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE + "\'",
                    null, null);
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                int number = cursor.getInt(0);
                Log.i(TAG, "getContactByNickName: number:" + number);
                contact = new ContactInfo();
                contact.setNickname(nickName);
                contact.setPhoneNumber(String.valueOf(number));
                return contact;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return contact;
    }

    /**
     * 根据row_contact_id找Contact
     *
     * @param context
     * @param id:row_contact_id
     * @return
     */
    public static ContactInfo getContactByRowContactIdFromSystemDB(Context context, int id) {
        //uri=  content://com.android.contacts/data/phones/filter/#
//        Uri uri = Uri.parse("content://com.android.contacts/data" + number);
        Cursor cursor = null;
        ContactInfo contact = null;
        try {
            ContentResolver resolver = context.getContentResolver();
            //从data表中返回display_name和contactId
            //因为data1表中的数据会根据mimeType改变，所以对于同一个row_contact_id，会找到两行数据。
            //一行data1是name，一行data1是number
            cursor = resolver.query(ContactsContract.Data.CONTENT_URI,
                    new String[]{"data1", ContactsContract.Data.MIMETYPE},
                    ContactsContract.Data.RAW_CONTACT_ID + "=" + id,
                    null, null);
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                contact = new ContactInfo();
                do {
                    String data1 = cursor.getString(0);
                    String mimeType = cursor.getString(1);
                    Log.i(TAG, "getContactByRowContactIdFromSystemDB: mimeType:" + mimeType + ",data1;" + data1);
                    if (ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE.equals(mimeType)) {
                        contact.setNickname(data1);
                    } else if (ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE.equals(mimeType)) {
                        contact.setPhoneNumber(data1);
                    }
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return contact;
    }

    /**
     * 获得通话记录里最后一个contactInfo用于重拨
     *
     * @return
     */
    @SuppressLint("MissingPermission")
    public static ContactInfo getLastRecordContact(Context context) {
        Cursor cursor = null;
        ContactInfo contact = null;
        try {
            ContentResolver resolver = context.getContentResolver();
            cursor = resolver.query(CallLog.Calls.CONTENT_URI, new String[]{CallLog.Calls.CACHED_NAME, CallLog.Calls.NUMBER},
                    null, null, CallLog.Calls.DATE + " desc");
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                String name = cursor.getString(0);
                String number = cursor.getString(1);
                contact = new ContactInfo(number, name);
                Log.i(TAG, "getLastRecordContact: contact:" + contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return contact;
    }

    public static String getNameByPinYin(String pinyin) {
        Log.i(TAG, "pinyin:" + pinyin);
        Cursor cursor = null;
        try {
            ContentResolver resolver = MainApplication.sApp.getContentResolver();
            cursor = resolver.query(DialerDatabaseHelper.AllContactsColumns.CONTENT_URI,
                    new String[]{DialerDatabaseHelper.AllContactsColumns.SORT_KEY,
                            DialerDatabaseHelper.AllContactsColumns.NICK_NAME},
                    DialerDatabaseHelper.AllContactsColumns.SORT_KEY + "=?",
                    new String[]{pinyin}, null);
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                String nickName = cursor.getString(1);
                Log.i(TAG, "getNameByPinYin: nickNmae;" + nickName);
                return nickName;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }

    public static String getNumberByPinYin(String pinyin) {
        Log.i(TAG, "pinyin:" + pinyin);
        Cursor cursor = null;
        try {
            ContentResolver resolver = MainApplication.sApp.getContentResolver();
            cursor = resolver.query(DialerDatabaseHelper.AllContactsColumns.CONTENT_URI,
                    new String[]{DialerDatabaseHelper.AllContactsColumns.SORT_KEY,
                            DialerDatabaseHelper.AllContactsColumns.CONTACT_ID},
                    DialerDatabaseHelper.AllContactsColumns.SORT_KEY + "=?",
                    new String[]{pinyin}, null);
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                String number = cursor.getString(1);
                Log.i(TAG, "getNumberByPinYin: number;" + number);
                return number;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }


    public static ContactInfo getContactByUri(Uri uri) {
        int row_contact_id = getRowContactId(uri);
        if (row_contact_id != -1) {
            ContactInfo contact = MyDBProviderHelper.getContactByRowContactIdFromSystemDB(MainApplication.sApp, row_contact_id);
            return contact;
        }
        return null;
    }

    public static int getRowContactId(Uri uri) {
        Cursor cursor = MainApplication.sApp.getContentResolver().query(uri, null, null, null, null);
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            int row_contact_id = cursor.getInt(cursor.getColumnIndex("name_raw_contact_id"));
            return row_contact_id;
        }
        return -1;
    }

    /**
     * 修改系统联系人数据
     *
     * @param contact
     * @return
     */
    public static int updateSystemContact(String oldName, ContactInfo contact, String rawContactId) {
        Log.i(TAG, "updateSystemContact: oldName:" + oldName + ",new info:" + contact);
        if (contact == null) {
            Log.e(TAG, "updateContact: contact is null");
            return -1;
        }
        int status = 0;
        ContentResolver resolver = MainApplication.sApp.getContentResolver();
        try {
            //往data表入姓名数据
            //view_data表中displayName相同的的cursor会有两行，一行的data1是number，一行是name
            //根据mimeType区分。
            //我的selection语句是:display_name = 'nickName' & mimeType = 'phone'这个是修改phone
            ContentValues values = new ContentValues();
            values.put("data1", contact.getPhoneNumber());
            resolver.update(ContactsContract.Data.CONTENT_URI, values,
                    ContactsContract.Data.MIMETYPE + "=? and " + ContactsContract.Data.RAW_CONTACT_ID + "=?",
                    new String[]{ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE,rawContactId});

            //isplay_name = 'nickName' & mimeType = 'name'这个是修改name
            values.clear();
            values.put("data1", contact.getNickname());
            resolver.update(ContactsContract.Data.CONTENT_URI, values,
                    ContactsContract.Data.MIMETYPE + "=? and " + ContactsContract.Data.RAW_CONTACT_ID + "=?",
                    new String[]{ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE,rawContactId});
        } catch (SQLException e) {
            e.printStackTrace();
            status = -1;
        }
        return status;
    }

    public static int updateContact(String oldName, ContactInfo contact) {
        Log.i(TAG, "updateContact: oldName:" + oldName + ",new info:" + contact);
        if (contact == null) {
            Log.e(TAG, "updateContact: contact is null");
            return -1;
        }
        int status = 0;
        ContentResolver resolver = MainApplication.sApp.getContentResolver();
        try {
            //往data表入姓名数据
            ContentValues values = new ContentValues();
            values.put(DialerDatabaseHelper.AllContactsColumns.NICK_NAME, contact.getNickname());
            values.put(DialerDatabaseHelper.AllContactsColumns.CONTACT_ID, contact.getPhoneNumber());
            resolver.update(DialerDatabaseHelper.AllContactsColumns.CONTENT_URI, values,
                    DialerDatabaseHelper.AllContactsColumns.NICK_NAME + " = ? ",
                    new String[]{oldName});
        } catch (SQLException e) {
            e.printStackTrace();
            status = -1;
        }
        return status;
    }
}
