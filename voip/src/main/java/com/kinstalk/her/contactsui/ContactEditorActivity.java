package com.kinstalk.her.contactsui;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.kinstalk.her.voipmode.data.ContactInfo;
import com.kinstalk.her.voipmode.data.MyDBProviderHelper;
import com.kinstalk.her.vowifivoip.R;

public class ContactEditorActivity extends AppCompatActivity {
    private static final String TAG = "ContactEditorActivity";
    private EditText nameEdit;
    private EditText numberEdit;
    private TextView saveBtn;
    public static final String KEY_NAME_EXTRA = "key_name_extra";
    public static final String KEY_NUMBER_EXTRA = "key_number_extra";
    public static final String KEY_URI_EXTRA = "key_uri_extra";
    /**
     * 是否是编辑联系人
     */
    private boolean isEditMode = false;
    private String oldName;
    private int rawContactId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_editor);
        initViews();
        initData();
    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        saveBtn = (TextView) toolbar.findViewById(R.id.save);
        setActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        ActionBar actionBar = getActionBar();//getSupportActionBar()
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        nameEdit = findViewById(R.id.contact_name);
        numberEdit = findViewById(R.id.contact_number);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEditMode) {
                    editContact();
                } else {
                    createContact();
                }
            }
        });
    }

    private void initData() {
        oldName = getIntent().getStringExtra(KEY_NAME_EXTRA);
        String number = getIntent().getStringExtra(KEY_NUMBER_EXTRA);
        rawContactId = getIntent().getIntExtra(KEY_URI_EXTRA, -1);
        Log.i(TAG, "initData: oldname:" + oldName + ",number:" + number + ",raw_contact_id:"+rawContactId);
        if (!TextUtils.isEmpty(oldName) && !TextUtils.isEmpty(number) && rawContactId != -1) {
            nameEdit.setText(oldName);
            numberEdit.setText(number);
            isEditMode = true;
        }
    }

    private void createContact() {
        if (TextUtils.isEmpty(nameEdit.getText().toString())) {
            Toast.makeText(ContactEditorActivity.this,
                    getString(R.string.no_name_error), Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(numberEdit.getText().toString())) {
            Toast.makeText(ContactEditorActivity.this,
                    getString(R.string.no_number_error), Toast.LENGTH_SHORT).show();
        } else {
            ContactInfo hasContact = MyDBProviderHelper.getContactByNickName(this, nameEdit.getText().toString());
            if (hasContact == null) {
                ContactInfo contactInfo = new ContactInfo();
                contactInfo.setPhoneNumber(numberEdit.getText().toString());
                contactInfo.setNickname(nameEdit.getText().toString());
                Log.i(TAG, "onClick: insert:contact:" + contactInfo);
                int status1 = MyDBProviderHelper.insertContact(contactInfo);
                int status2 = MyDBProviderHelper.insertContactToSystemDB(contactInfo);
                Log.i(TAG, "onClick: status1:" + status1 + ",status2:" + status2);
                if (status1 == 0 && status2 == 0) {
                    Toast.makeText(this,
                            getString(R.string.add_contact_success), Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this,
                            getString(R.string.add_contact_fail), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this,
                        getString(R.string.contact_already_exist), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void editContact() {
        if (TextUtils.isEmpty(nameEdit.getText().toString())) {
            Toast.makeText(ContactEditorActivity.this,
                    getString(R.string.no_name_error), Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(numberEdit.getText().toString())) {
            Toast.makeText(ContactEditorActivity.this,
                    getString(R.string.no_number_error), Toast.LENGTH_SHORT).show();
        } else {
            ContactInfo contactInfo = new ContactInfo();
            contactInfo.setPhoneNumber(numberEdit.getText().toString());
            contactInfo.setNickname(nameEdit.getText().toString());
            Log.i(TAG, "onClick: insert:contact:" + contactInfo);
            int status1 = MyDBProviderHelper.updateSystemContact(oldName, contactInfo, String.valueOf(rawContactId));
            int status2 = MyDBProviderHelper.updateContact(oldName, contactInfo);
            if (status1 == 0 && status2 == 0) {
                Toast.makeText(this,
                        getString(R.string.update_contact_success), Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this,
                        getString(R.string.update_contact_fail), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
