package com.kinstalk.her.vowifivoip;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import common.RealmHelper;
import common.model.RealmConversation;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import io.realm.Sort;
import ui.RecyclerViewClickListener;

/**
 * Created by Upon on 2018/3/13.
 */

public class JRMessageListActivity extends BaseActivity {
    private RecyclerView mMessageListView;
    private RealmResults<RealmConversation> mRealmConversations;
    private Realm mRealm;
    private JRMessageListAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        mRealm = RealmHelper.getInstance();
        initViews();
        initListener();
        initData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 1, 1, "添加");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == 1) {
            showDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initViews() {
        mMessageListView = (RecyclerView) findViewById(R.id.message_list);
    }

    private void initListener() {

    }

    private void initData() {
        mRealmConversations = mRealm.where(RealmConversation.class)
                .findAllSorted(RealmConversation.FIELD_UPDATE_TIME, Sort.DESCENDING);
        mRealmConversations.addChangeListener(new RealmChangeListener<RealmResults<RealmConversation>>() {
            @Override
            public void onChange(RealmResults<RealmConversation> conversations) {
                mAdapter.notifyDataSetChanged();
            }
        });
        mAdapter = new JRMessageListAdapter(getApplicationContext(), mRealmConversations);
        mMessageListView.setAdapter(mAdapter);
        mMessageListView.setLayoutManager(new LinearLayoutManager(this));
        mMessageListView.addOnItemTouchListener(new RecyclerViewClickListener(this, mMessageListView,
                mOnItemClickListener));
    }

    private RecyclerViewClickListener.SimpleOnItemClickListener mOnItemClickListener = new RecyclerViewClickListener.SimpleOnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            int id = view.getId();
            if (id == R.id.user_name || id == R.id.item_view || id == R.id.icon || id== R.id.message) {
                String peernumber = mRealmConversations.get(position).getPeerPhone();
                Intent intent = new Intent(JRMessageListActivity.this, JRMessageActivity.class);
                intent.putExtra("account_phone", peernumber);
                startActivity(intent);
            }
        }
    };

    private void showDialog() {
        final TextView tv = new EditText(this);
        new AlertDialog.Builder(this)
                .setTitle("请输入")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setView(tv)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!TextUtils.isEmpty(tv.getText())) {
                            String peernumber = tv.getText().toString();
                            Intent intent = new Intent(JRMessageListActivity.this, JRMessageActivity.class);
                            intent.putExtra("account_phone", peernumber);
                            startActivity(intent);
                        }
                    }
                })
                .setNegativeButton("取消", null)
                .show();
    }
}
