
package jp.techacademy.hanai.hideo.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    EditText Num1;
    EditText Num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button plus = (Button) findViewById(R.id.plus);
        plus.setOnClickListener(this);
        Button minus = (Button) findViewById(R.id.minus);
        minus.setOnClickListener(this);
        Button mult = (Button) findViewById(R.id.mult);
        mult.setOnClickListener(this);
        Button divid = (Button) findViewById(R.id.divid);
        divid.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);
        Num1 = (EditText) findViewById(R.id.Num1);
        Num2 = (EditText) findViewById(R.id.Num2);

    }

    @Override
    public void onClick(View v) {

        double a=0;
        double b=0;
        boolean eFlg = false;
        String ans="";

        //　入力文字チェック（Num2)
        try {
            Double.parseDouble(Num2.getText().toString());
        } catch (NumberFormatException e) {
            eFlg = true;
            ans = "数字を入力してください（Num2)";
        }

        //　入力文字チェック（Num1)
        try {
            Double.parseDouble(Num1.getText().toString());
        } catch (NumberFormatException e) {
            eFlg = true;
            ans = "数字を入力してください（Num1)";
        }

        //　計算処理
        if (eFlg == false) {

            a = Double.parseDouble(Num1.getText().toString());
            b = Double.parseDouble(Num2.getText().toString());

            switch (v.getId()) {
                case R.id.plus:
                    ans = String.format("%.2f", (a + b));

                    break;

                case R.id.minus:
                    ans = String.format("%.2f", (a - b));
                    break;

                case R.id.mult:
                    ans = String.format("%.2f", (a * b));
                    break;

                case R.id.divid:
                    if (b == 0) {
                        ans = "0で除算はできません";
                        eFlg = true;
                    } else {
                        ans = String.format("%.2f", (a / b));
                    }
                    break;


            }
        }

        if (eFlg == true){

            //　エラーコメント表示
            if(ans == "0で除算はできません"){
                showAlertDialog2();
            } else {
                showAlertDialog();
            }

        } else {
            //　計算結果表示（表示画面へ遷移）
            Intent intent = new Intent(this, DispAnsActivity.class);
            intent.putExtra("Ans", ans);
            startActivity(intent);
        }
    }

    private void showAlertDialog() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("入力エラー");
        alertDialogBuilder.setMessage("数字を入力してください。");

        // OKボタン
        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                    }
                });
        // AlertDialogを作成して表示する
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    private void showAlertDialog2() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("入力エラー");
        alertDialogBuilder.setMessage("0で除算はできません");

        // OKボタン
        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                    }
                });
        // AlertDialogを作成して表示する
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}

