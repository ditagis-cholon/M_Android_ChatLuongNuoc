package cholon.hcm.ditagis.com.qlcln.entities;

import android.app.Application;

public class DApplication extends Application {

    private boolean checkedVersion;

    public boolean isCheckedVersion() {
        return checkedVersion;
    }

    public void setCheckedVersion(boolean checkedVersion) {
        this.checkedVersion = checkedVersion;
    }
}
