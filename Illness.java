

import android.arch.persistence.room.Entity;

/**
 * Created by Alexandrov Alex on 6/26/18.
 */
@Entity
public class Illness extends BaseBodyAndHealth {

    private int doctorUserId;

    private String illness;

    private String doctorName;

    public int getDoctorUserId() {
        return doctorUserId;
    }

    public void setDoctorUserId(int doctorUserId) {
        this.doctorUserId = doctorUserId;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
