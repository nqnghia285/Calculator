package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.Math.atan;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    public static final Double SIGMA0 = 0.0;

    public static Double sm_x = 0.0;
    public static Double sm_y = 0.0;
    public static Double sm_z = 0.0;
    public static Double t_xy = 0.0;
    public static Double ap = 0.0;
    public static Double e = 0.0;
    public static Double mu = 0.0;

    public static Double sm_u = 0.0;
    public static Double sm_v = 0.0;
    public static Double t_uv = 0.0;
    public static Double t_vu = 0.0;
    public static Double sm_max = 0.0;
    public static Double sm_min = 0.0;
    public static Double sm1 = 0.0;
    public static Double sm2 = 0.0;
    public static Double sm3 = 0.0;
    public static Double t_max = 0.0;
    public static Double t_min = 0.0;
    public static Double ap1 = 0.0;
    public static Double ap2 = 0.0;
    public static Double ap_tau_max = 0.0;
    public static Double ap_tau_min = 0.0;
    public static Double sm_c = 0.0;
    public static Double r = 0.0;
    public static Double sm_p = 0.0;
    public static Double t_p = 0.0;
    public static Double sm_td3 = 0.0;
    public static Double sm_td4 = 0.0;
    public static Double ex_x = 0.0;
    public static Double ex_y = 0.0;
    public static Double ex_z = 0.0;
    public static Double ex_u = 0.0;
    public static Double ex_v = 0.0;
    public static Double ex1 = 0.0;
    public static Double ex2 = 0.0;
    public static Double ex3 = 0.0;
    public static Double g = 0.0;
    public static Double gm_xy = 0.0;
    public static Double gm_uv = 0.0;
    public static Double gm_vu = 0.0;
    public static Double gm_tau_max = 0.0;
    public static Double gm_tau_min = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            Log.e(TAG, "Class main is not created.");
        } else {
            Log.e(TAG, "Class main is created.");
        }

        setContentView(R.layout.activity_main);

        // Các giá trị cần nhập
        final EditText sigma_x = findViewById(R.id.editTextSigma_x);
        final EditText sigma_y = findViewById(R.id.editTextSigma_y);
        final EditText tau_xy = findViewById(R.id.editTextTau_xy);
        final EditText alpha = findViewById(R.id.editTextAlpha);
        final EditText E = findViewById(R.id.editTextE);
        final EditText Mu = findViewById(R.id.editTextMu);

        // Các nút nhấn
        Button buttonOK = findViewById(R.id.buttonOK);
        Button buttonClear = findViewById(R.id.buttonClear);

        // Các giá trị cần xuất ra
        final EditText sigma_u = findViewById(R.id.editTextSigma_u);
        final EditText sigma_v = findViewById(R.id.editTextSigma_v);
        final EditText tau_uv = findViewById(R.id.editTextTau_uv);
        final EditText tau_vu = findViewById(R.id.editTextTau_vu);
        final EditText sigma_max = findViewById(R.id.editTextSigma_max);
        final EditText sigma_min = findViewById(R.id.editTextSigma_min);
        final EditText sigma1 = findViewById(R.id.editTextSigma1);
        final EditText sigma2 = findViewById(R.id.editTextSigma2);
        final EditText sigma3 = findViewById(R.id.editTextSigma3);
        final EditText alpha1 = findViewById(R.id.editTextAlpha1);
        final EditText alpha2 = findViewById(R.id.editTextAlpha2);
        final EditText alpha_tau_max = findViewById(R.id.editTextAlpha_tau_max);
        final EditText alpha_tau_min = findViewById(R.id.editTextAlpha_tau_min);
        final EditText tau_max = findViewById(R.id.editTextTau_max);
        final EditText tau_min = findViewById(R.id.editTextTau_min);
        final EditText sigma_c = findViewById(R.id.editTextSigma_c);
        final EditText r_tau = findViewById(R.id.editTextR);
        final EditText sigma_p = findViewById(R.id.editTextSigma_p);
        final EditText tau_p = findViewById(R.id.editTextTau_p);
        final EditText sigma_td3 = findViewById(R.id.editTextSigma_td3);
        final EditText sigma_td4 = findViewById(R.id.editTextSigma_td4);
        final EditText Ex_x = findViewById(R.id.editTextEpsilon_x);
        final EditText Ex_y = findViewById(R.id.editTextEpsilon_y);
        final EditText Ex_z = findViewById(R.id.editTextEpsilon_z);
        final EditText Ex1 = findViewById(R.id.editTextEpsilon1);
        final EditText Ex2 = findViewById(R.id.editTextEpsilon2);
        final EditText Ex3 = findViewById(R.id.editTextEpsilon3);
        final EditText Ex_u = findViewById(R.id.editTextEpsilon_u);
        final EditText Ex_v = findViewById(R.id.editTextEpsilon_v);
        final EditText G = findViewById(R.id.editTextG);
        final EditText gamma_xy = findViewById(R.id.editTextGamma_xy);
        final EditText gamma_uv = findViewById(R.id.editTextGamma_uv);
        final EditText gamma_vu = findViewById(R.id.editTextGamma_vu);
        final EditText gamma_tau_max = findViewById(R.id.editTextGamma_tau_max);
        final EditText gamma_tau_min = findViewById(R.id.editTextGamma_tau_min);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyen gia tri da nhap va luu lai
                Alpha(alpha);
                sm_x = Double.parseDouble(toNumber(sigma_x));
                sm_y = Double.parseDouble(toNumber(sigma_y));
                t_xy = Double.parseDouble(toNumber(tau_xy));
                e = Double.parseDouble(toNumber(E));
                mu = Double.parseDouble(toNumber(Mu));

                // Tinh toan tat ca cac dai luong
                Sigma_U();
                Sigma_V();
                Tau_UV();
                Tau_VU();
                Sigma_Max();
                Sigma_Min();
                CheckSigma123();
                Alpha_One();
                Alpha_Two();
                Alpha_Tau_Max();
                Alpha_Tau_Min();
                Tau_Max();
                Tau_Min();
                Sigma_C();
                R();
                Sigma_P();
                Tau_P();
                Sigma_TD3();
                Sigma_TD4();
                Ex_X();
                Ex_Y();
                Ex_Z();
                Ex_One();
                Ex_Two();
                Ex_Three();
                EX_U();
                EX_V();
                G();
                Gamma_XY();
                Gamma_UV();
                Gamma_VU();
                Gamma_Tau_Max();
                Gamma_Tau_Min();

                // Gan gia tri cho cac dai luong de hien thi
                sigma_u.setText(sm_u.toString());
                sigma_v.setText(sm_v.toString());
                tau_uv.setText(t_uv.toString());
                tau_vu.setText(t_vu.toString());
                sigma_max.setText(sm_max.toString());
                sigma_min.setText(sm_min.toString());
                sigma1.setText(sm1.toString());
                sigma2.setText(sm2.toString());
                sigma3.setText(sm3.toString());
                alpha1.setText(ap1.toString());
                alpha2.setText(ap2.toString());
                alpha_tau_max.setText(ap_tau_max.toString());
                alpha_tau_min.setText(ap_tau_min.toString());
                tau_max.setText(t_max.toString());
                tau_min.setText(t_min.toString());
                sigma_c.setText(sm_c.toString());
                r_tau.setText(r.toString());
                sigma_p.setText(sm_p.toString());
                tau_p.setText(t_p.toString());
                sigma_td3.setText(sm_td3.toString());
                sigma_td4.setText(sm_td4.toString());
                Ex_x.setText(ex_x.toString());
                Ex_y.setText(ex_y.toString());
                Ex_z.setText(ex_z.toString());
                Ex1.setText(ex1.toString());
                Ex2.setText(ex2.toString());
                Ex3.setText(ex3.toString());
                Ex_u.setText(ex_u.toString());
                Ex_v.setText(ex_v.toString());
                G.setText(g.toString());
                gamma_xy.setText(gm_xy.toString());;
                gamma_uv.setText(gm_uv.toString());
                gamma_vu.setText(gm_vu.toString());
                gamma_tau_max.setText(gm_tau_max.toString());
                gamma_tau_min.setText(gm_tau_min.toString());
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set lai gia tri cua cac dai luong
                sm_x = 0.0;
                sm_y = 0.0;
                t_xy = 0.0;
                ap = 0.0;
                e = 0.0;
                mu = 0.0;

                sm_u = 0.0;
                sm_v = 0.0;
                t_uv = 0.0;
                t_vu = 0.0;
                sm_max = 0.0;
                sm_min = 0.0;
                sm1 = 0.0;
                sm2 = 0.0;
                sm3 = 0.0;
                ap1 = 0.0;
                ap2 = 0.0;
                ap_tau_max = 0.0;
                ap_tau_min = 0.0;
                t_max = 0.0;
                t_min = 0.0;
                sm_c = 0.0;
                r = 0.0;
                sm_p = 0.0;
                sm_td3 = 0.0;
                sm_td4 = 0.0;
                t_p = 0.0;
                ex_x = 0.0;
                ex_y = 0.0;
                ex_z = 0.0;
                ex1 = 0.0;
                ex2 = 0.0;
                ex3 = 0.0;
                ex_u = 0.0;
                ex_v = 0.0;
                g = 0.0;
                gm_xy = 0.0;
                gm_uv = 0.0;
                gm_vu = 0.0;
                gm_tau_max = 0.0;
                gm_tau_min = 0.0;

                // Xoa gia tri cua cac dai luong
                sigma_x.setText("");
                sigma_y.setText("");
                tau_xy.setText("");
                alpha.setText("");
                E.setText("");
                Mu.setText("");
                sigma_u.setText("");
                sigma_v.setText("");
                tau_uv.setText("");
                tau_vu.setText("");
                sigma_max.setText("");
                sigma_min.setText("");
                sigma1.setText("");
                sigma2.setText("");
                sigma3.setText("");
                alpha1.setText("");
                alpha2.setText("");
                alpha_tau_max.setText("");
                alpha_tau_min.setText("");
                tau_max.setText("");
                tau_min.setText("");
                sigma_c.setText("");
                r_tau.setText("");
                sigma_p.setText("");
                tau_p.setText("");
                sigma_td3.setText("");
                sigma_td4.setText("");
                Ex_x.setText("");
                Ex_y.setText("");
                Ex_z.setText("");
                Ex1.setText("");
                Ex2.setText("");
                Ex3.setText("");
                Ex_u.setText("");
                Ex_v.setText("");
                G.setText("");
                gamma_xy.setText("");
                gamma_uv.setText("");
                gamma_vu.setText("");
                gamma_tau_max.setText("");
                gamma_tau_min.setText("");
            }
        });
    }

    ///////////////////////////////////////////////////
    // Cac ham kiem tra gia tri so nhap vao

    private String toNumber(EditText e) {
        String container = e.getText().toString();
        if (container.length() > 0) {
            if (container.charAt(0) == '-') {
                if (container.length() == 1) {
                    return "0";
                }
                else if (container.contains(".")) {
                    int dotIndex = 2;
                    while (dotIndex < container.length()) {
                        if (container.charAt(dotIndex) != '.') {
                            dotIndex++;
                        } else {
                            break;
                        }
                    }

                    if (checkDifferentNumberZero(container.substring(dotIndex + 1))) {
                        return container;
                    } else {
                        return container.substring(0, dotIndex);
                    }
                } else {
                    return container;
                }
            }
            else {
                if (container.contains(".")) {
                    int dotIndex = 1;
                    while (dotIndex < container.length()) {
                        if (container.charAt(dotIndex) != '.') {
                            dotIndex++;
                        } else {
                            break;
                        }
                    }

                    if (checkDifferentNumberZero(container.substring(dotIndex + 1))) {
                        return container;
                    } else {
                        return container.substring(0, dotIndex);
                    }
                } else {
                    return container;
                }
            }
        }
        else {
            return "0";
        }
    }

    private boolean checkDifferentNumberZero(String number) {
        if (number != null) {
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) != '0') {
                    return true;
                }
            }
        }
        return false;
    }

    /////////////////////////////////////////////////////
    // Cac ham tinh toan

    private void Alpha(EditText alpha) {
        if (abs(ap) > 360.0) {
            ap = Double.parseDouble(toNumber(alpha))%360;
            ap = ap*PI/180;
        }
        else {
            ap = Double.parseDouble(toNumber(alpha))*PI/180;
        }
    }

    private void Sigma_U() {
        sm_u = (sm_x + sm_y) / 2 + ((sm_x - sm_y) / 2) * cos(2 * ap) + t_xy * sin(2 * ap);
    }

    private void Sigma_V() {
        sm_v = sm_x + sm_y - sm_u;
    }

    private void Tau_UV() {
        t_uv = ((sm_x - sm_y) / 2) * sin(2 * ap) - t_xy * cos(2 * ap);
    }

    private void Tau_VU() {
        t_vu = -t_uv;
    }

    private void Sigma_Max() {
        sm_max = (sm_x + sm_y) / 2 + 0.5 * sqrt((sm_x - sm_y) * (sm_x - sm_y) + 4 * t_xy * t_xy);
    }

    private void Sigma_Min() {
        sm_min = (sm_x + sm_y) / 2 - 0.5 * sqrt((sm_x - sm_y) * (sm_x - sm_y) + 4 * t_xy * t_xy);
    }

    private void CheckSigma123() {
        if(sm_max >= SIGMA0 && sm_min >= SIGMA0) {
            sm1 = sm_max;
            sm2 = sm_min;
            sm3 = SIGMA0;
        }
        else if(sm_max >= SIGMA0 && sm_min <= SIGMA0) {
            sm1 = sm_max;
            sm2 = SIGMA0;
            sm3 = sm_min;
        }
        else {
            sm1 = SIGMA0;
            sm2 = sm_max;
            sm3 = sm_min;
        }
    }

    private void Alpha_One() {
        ap1 = (atan(t_xy / (sm_max - sm_y))) * 180 / PI;
    }

    private void Alpha_Two() {
        ap2 = ap1 + 90;
    }

    private void Alpha_Tau_Max() {
        ap_tau_max = ap1 + 45;
    }

    private void Alpha_Tau_Min() {
        ap_tau_min = ap1 + 135;
    }

    private void Tau_Max() {
        t_max = 0.5 * sqrt((sm_x - sm_y) * (sm_x - sm_y) + 4 * t_xy * t_xy);
    }

    private void Tau_Min() {
        t_min = -t_max;
    }

    private void Sigma_C() {
        sm_c = (sm_x + sm_y) / 2;
    }

    private void R() {
        r = t_max;
    }

    private void Sigma_P() {
        sm_p = sm_y;
    }

    private void Tau_P() {
        t_p = -t_xy;
    }

    private void Sigma_TD3() {
        sm_td3 = sm1 - sm3;
    }

    private void Sigma_TD4() {
        sm_td4 = sqrt(sm1 * sm1 + sm2 * sm2 + sm3 * sm3 - sm1 * sm2 - sm1 * sm3 - sm2 * sm3);
    }

    private void Ex_X() {
        ex_x = (sm_x - mu * (sm_y + sm_z)) / e;
    }

    private void Ex_Y() {
        ex_y = (sm_y - mu * (sm_x + sm_z)) / e;
    }

    private void Ex_Z() {
        ex_z = (sm_z - mu * (sm_x + sm_y)) / e;
    }

    private void Ex_One() {
        ex1 = (sm1 - mu * (sm2 + sm3)) / e;
    }

    private void Ex_Two() {
        ex2 = (sm2 - mu * (sm1 + sm3)) / e;
    }

    private void Ex_Three() {
        ex3 = (sm3 - mu * (sm1 + sm2)) / e;
    }

    private void EX_U() {
        ex_u = (sm_u - mu * sm_v) / e;
    }

    private void EX_V() {
        ex_v = (sm_v - mu * sm_u) / e;
    }

    private void G() {
        g = e / (2 * (1 + mu));
    }

    private  void Gamma_XY() {
        gm_xy = t_xy / g;
    }

    private  void Gamma_UV() {
        gm_uv = t_uv / g;
    }

    private  void Gamma_VU() {
        gm_vu = t_vu / g;
    }

    private  void Gamma_Tau_Max() {
        gm_tau_max = t_max / g;
    }

    private  void Gamma_Tau_Min() {
        gm_tau_min = t_min / g;
    }
}
