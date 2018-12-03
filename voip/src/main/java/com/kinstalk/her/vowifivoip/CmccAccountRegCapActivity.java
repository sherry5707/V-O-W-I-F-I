package com.kinstalk.her.vowifivoip;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import com.juphoon.cmcc.app.lemon.MtcCliCfg;
import com.juphoon.cmcc.app.lemon.MtcCliCfgConstants;
import com.juphoon.cmcc.app.lemon.MtcProf;
import com.kinstalk.her.vowifivoip.R;

import java.util.Arrays;
import java.util.List;

public class CmccAccountRegCapActivity extends AppCompatActivity {
    private ListView mListView;
    private CapAdapter mAdapter;
    private List<String> mRegCapList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        initViews();
        mRegCapList = Arrays.asList(getResources().getStringArray(R.array.cmcc_reg_cap_list_values));
        mAdapter = new CapAdapter(this, mRegCapList);
        mListView.setAdapter(mAdapter);
    }

    private void initViews() {
        findViewById(R.id.loading).setVisibility(View.GONE);
        mListView = (ListView) findViewById(android.R.id.list);
    }

    @Override
    protected void onDestroy() {
        MtcProf.Mtc_ProfSaveProvision();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"清除所有注册能力");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == 1) {
            MtcCliCfg.Mtc_CliCfgClrCmccExtRegCap(MtcCliCfgConstants.MTC_REG_CAP_OPT_ALL);
            mAdapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }

    class CapAdapter extends BaseAdapter {
        private Context context;
        private List<String> list;

        public CapAdapter(Context context, List<String> list){
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item_reg_cap, parent, false);
                holder = new ViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.reg_cap_name);
                holder.isHasCap = (CheckBox) convertView.findViewById(R.id.is_has_reg_cap);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.isHasCap.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        MtcCliCfg.Mtc_CliCfgSetCmccExtRegCap(position+1);
                    }else {
                        MtcCliCfg.Mtc_CliCfgClrCmccExtRegCap(position+1);
                    }
                }
            });
            holder.name.setText(list.get(position));
            int s = MtcCliCfg.Mtc_CliCfgGetCmccExtRegCap() & (1 << ((position+1) % 32));
            holder.isHasCap.setTag(position);
            if((s > 0)) {
                holder.isHasCap.setChecked(true);
            }else {
                holder.isHasCap.setChecked(false);
            }
            return convertView;
        }

        class ViewHolder {
            TextView name;
            CheckBox isHasCap;

        }
    }
}
