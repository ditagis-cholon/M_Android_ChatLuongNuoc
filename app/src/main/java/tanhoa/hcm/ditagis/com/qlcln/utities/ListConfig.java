package tanhoa.hcm.ditagis.com.qlcln.utities;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import tanhoa.hcm.ditagis.com.qlcln.R;

/**
 * Created by ThanLe on 5/8/2018.
 */

public class ListConfig {
    private static Context mContext;
    private static ListConfig instance = null;

    public static ListConfig getInstance(Context context) {
        if (instance == null) instance = new ListConfig();
        mContext = context;
        return instance;
    }

    private ListConfig() {
    }

    public List<Config> getConfigs() {
        List<Config> configs = new ArrayList<>();
        String url_service_diemdanhgianuoc = mContext.getResources().getString(R.string.url_service_diemdanhgianuoc);
        String url_service_maudanhgia = mContext.getResources().getString(R.string.url_service_maudanhgia);
        String alias_diemdanhgianuoc = mContext.getResources().getString(R.string.alias_diemdanhgianuoc);
        String name_diemdanhgianuoc = mContext.getResources().getString(R.string.name_diemdanhgianuoc);
        String[] addFields_diemdanhgianuoc = mContext.getResources().getStringArray(R.array.addFields_diemdanhgianuoc);
        String[] updateFields_diemdanhgianuoc = mContext.getResources().getStringArray(R.array.updateFields_diemdanhgianuoc);
        String[] queryFields_diemdanhgianuoc = mContext.getResources().getStringArray(R.array.queryFields_diemdanhgianuoc);
        String[] outFields_diemdanhgianuoc = mContext.getResources().getStringArray(R.array.outFields_diemdanhgianuoc);
        Config configDiemDanhGiaNuoc = new Config(url_service_diemdanhgianuoc, alias_diemdanhgianuoc, name_diemdanhgianuoc, addFields_diemdanhgianuoc, updateFields_diemdanhgianuoc, queryFields_diemdanhgianuoc, null,true);
        configs.add(configDiemDanhGiaNuoc);
        String[] addFields_maudanhgia = mContext.getResources().getStringArray(R.array.addFields_maudanhgia);
        String[] updateFields_maudanhgia = mContext.getResources().getStringArray(R.array.updateFields_maudanhgia);
        String[] queryFields_maudanhgia = mContext.getResources().getStringArray(R.array.queryFields_maudanhgia);
        String[] outFields_maudanhgia = mContext.getResources().getStringArray(R.array.outFields_maudanhgia);


        String name_maudanhgia = mContext.getResources().getString(R.string.name_maudanhgia);
        String alias_maudanhgia = mContext.getResources().getString(R.string.alias_maudanhgia);
        Config configMauDanhGia = new Config(url_service_maudanhgia,alias_maudanhgia,name_maudanhgia,addFields_maudanhgia, updateFields_maudanhgia, queryFields_maudanhgia, outFields_maudanhgia,false);
        configs.add(configMauDanhGia);
        return configs;
    }

}