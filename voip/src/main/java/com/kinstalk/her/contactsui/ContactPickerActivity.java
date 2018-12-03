package com.kinstalk.her.contactsui;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.kinstalk.her.vowifivoip.R;

public class ContactPickerActivity extends Activity {
    private static final String TAG = "ContactPickerActivity";
    public static final int PICK_CONTACT = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_picker);

        final Cursor c = getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI, null, null, null, null
        );

        String[] from = new String[]{ContactsContract.Contacts.DISPLAY_NAME_PRIMARY};
        int[] to = new int[]{R.id.itemTextView};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.contact_picker_layout_item, c, from, to, 0);
        ListView lv = (ListView)findViewById(R.id.contactListView);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new ListView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                c.moveToPosition(pos);
                int rowId = c.getInt(c.getColumnIndexOrThrow("_id"));
                Uri outURI = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, rowId);
                Intent outData = new Intent();
                outData.setData(outURI);
                setResult(Activity.RESULT_OK, outData);
                finish();
            }
        });
    }
}
