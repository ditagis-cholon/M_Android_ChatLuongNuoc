package tanhoa.hcm.ditagis.com.qlcln;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;

import tanhoa.hcm.ditagis.com.qlcln.adapter.SettingsAdapter;
import tanhoa.hcm.ditagis.com.qlcln.utities.Constant;
import tanhoa.hcm.ditagis.com.qlcln.utities.Preference;

public class SettingsActivity extends AppCompatActivity {
    private ListView mLstViewSettings;
    private SettingsAdapter mSettingsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Preference.getInstance().setContext(SettingsActivity.this);

        mLstViewSettings = findViewById(R.id.lstView_Settings);
        mSettingsAdapter = new SettingsAdapter(this, Constant.getInstance().getSettingsItems());
        mLstViewSettings.setAdapter(mSettingsAdapter);
        mLstViewSettings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        showPhuongThucThemDiemSuCo();
                        break;
                    case 1:
                        showOptionTimKiem();
                        break;
                }

            }
        });
        setSubTitle();
    }

    private void setSubTitle() {
        mSettingsAdapter.setItemSubtitle(0, getPhuongThucThemDiemSuCo());
        mSettingsAdapter.setItemSubtitle(1, getOptionTimKiem());

        mSettingsAdapter.notifyDataSetChanged();
    }

    private String getPhuongThucThemDiemSuCo() {
        final String key = getString(R.string.preference_settings_phuong_thuc_them_diem_su_co);
        return Preference.getInstance().loadPreference(key);
    }

    private String getOptionTimKiem() {
        final String key = getString(R.string.preference_settings_tuy_chon_tim_kiem);
        return Preference.getInstance().loadPreference(key);
    }

    private void showPhuongThucThemDiemSuCo() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Light_Dialog_Alert);
        builder.setCancelable(true);
        builder.setTitle(getString(R.string.nav_cai_dat_them_su_co_title));
        builder.setPositiveButton(getString(R.string.btn_Esc), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        LayoutInflater inflater = getLayoutInflater();
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.layout_settings_phuong_thuc_them_diem_su_co, null);
        final RadioGroup group = (RadioGroup) layout.findViewById(R.id.rdgr_layout_settings);
        final String key = getString(R.string.preference_settings_phuong_thuc_them_diem_su_co);
        String type_Add_Point = getPhuongThucThemDiemSuCo();
        if (type_Add_Point.equals("") || type_Add_Point.equals(getString(R.string.preference_settings_phuong_thuc_them_diem_su_co_cham_diem)))
            group.check(R.id.rd_layout_settings_cham_diem);
        else if (type_Add_Point.equals(this.getResources().getString(R.string.preference_settings_phuong_thuc_them_diem_su_co_toa_do)))
            group.check(R.id.rd_layout_settings_toa_do);
        else if (type_Add_Point.equals(this.getResources().getString(R.string.preference_settings_phuong_thuc_them_diem_su_co_keo_tha)))
            group.check(R.id.rd_layout_settings_keo_tha);

//        builder.setView(layout);
        final AlertDialog dialog = builder.create();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                Preference.getInstance().deletePreferences(key);
                switch (checkedId) {
                    case R.id.rd_layout_settings_cham_diem:
                        Preference.getInstance().savePreferences(key,
                                getString(R.string.preference_settings_phuong_thuc_them_diem_su_co_cham_diem));
                        break;
                    case R.id.rd_layout_settings_toa_do:
                        Preference.getInstance().savePreferences(key,
                                getString(R.string.preference_settings_phuong_thuc_them_diem_su_co_toa_do));
                        break;
                    case R.id.rd_layout_settings_keo_tha:
                        Preference.getInstance().savePreferences(key,
                                getString(R.string.preference_settings_phuong_thuc_them_diem_su_co_keo_tha));
                        break;
                }
                setSubTitle();
                dialog.dismiss();
            }
        });
        dialog.setView(layout);
        dialog.show();
    }

    private void showOptionTimKiem() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Light_Dialog_Alert);
        builder.setCancelable(true);
        builder.setTitle(getString(R.string.nav_cai_dat_tim_kiem_title));
        builder.setPositiveButton(getString(R.string.btn_Esc), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        LayoutInflater inflater = getLayoutInflater();
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.layout_settings_tuy_chon_tim_kiem, null);
        final RadioGroup group = (RadioGroup) layout.findViewById(R.id.rdgr_layout_settings_tim_kiem);
        final String key = getString(R.string.preference_settings_tuy_chon_tim_kiem);
        String type_Add_Point = getOptionTimKiem();
        if (type_Add_Point.equals("") || type_Add_Point.equals(this.getResources().getString(R.string.preference_settings_tuy_chon_tim_kiem_chua_co)))
            group.check(R.id.rd_layout_settings_chua_co);
        else if (type_Add_Point.equals(getString(R.string.preference_settings_tuy_chon_tim_kiem_co_san)))
            group.check(R.id.rd_layout_settings_co_san);

//        builder.setView(layout);
        final AlertDialog dialog = builder.create();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                Preference.getInstance().deletePreferences(key);
                switch (checkedId) {
                    case R.id.rd_layout_settings_chua_co:
                        Preference.getInstance().savePreferences(key,
                                getString(R.string.preference_settings_tuy_chon_tim_kiem_chua_co));
                        break;
                    case R.id.rd_layout_settings_co_san:
                        Preference.getInstance().savePreferences(key,
                               getString(R.string.preference_settings_tuy_chon_tim_kiem_co_san));
                        break;
                }
                setSubTitle();
                dialog.dismiss();
            }
        });
        dialog.setView(layout);
        dialog.show();
    }
}
