package com.demo.alterdialog_demo;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnAlterDialog1;
    private Button btnAlterDialog2;
    private Button btnAlterDialog3;
    private Button btnAlterDialog4;
    private Button btnAlterDialog5;

    //单选按钮列表
    String single[] = {"男","女","程序员","鸣人","路飞","天明","小黄人"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
        intevent();

    }

    private void intevent() {
        btnAlterDialog1.setOnClickListener(clickListener);
        btnAlterDialog2.setOnClickListener(clickListener);
        btnAlterDialog3.setOnClickListener(clickListener);
        btnAlterDialog4.setOnClickListener(clickListener);
        btnAlterDialog5.setOnClickListener(clickListener);
    }

    private void init() {
        btnAlterDialog1 = (Button) findViewById(R.id.btnAlterDialog1);
        btnAlterDialog2 = (Button) findViewById(R.id.btnAlterDialog2);
        btnAlterDialog3 = (Button) findViewById(R.id.btnAlterDialog3);
        btnAlterDialog4 = (Button) findViewById(R.id.btnAlterDialog4);
        btnAlterDialog5 = (Button) findViewById(R.id.btnAlterDialog5);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnAlterDialog1:
                    showAlterDialog1();
                    break;
                case R.id.btnAlterDialog2:
                    showAlterDialog2();
                    break;
                case R.id.btnAlterDialog3:
                    showAlterDialog3();
                    break;
                case R.id.btnAlterDialog4:
                    showAlterDialog4();
                    break;
                case R.id.btnAlterDialog5:
                    showAlterDialog5();
                    break;
            }
        }
    };

    /**
     * 显示确认对话框
     */
    private void showAlterDialog1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(
                R.string.alter1));
        builder.setIcon(R.drawable.xiaohuangren);
        builder.setMessage("确认对话框提示内容");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "您点击了确认按钮", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "您点击了取消按钮", Toast.LENGTH_SHORT).show();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
    }

    /**
     * 显示单选按钮对话框
     */
    private void showAlterDialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(
                R.string.alter2));
        builder.setIcon(R.drawable.xiaohuangren);

        builder.setSingleChoiceItems(single, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "您点击了"+single[which], Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });

        Dialog dialog = builder.create();
        dialog.show();
    }

    /**
     * 显示多选按钮对话框
     */
    private void showAlterDialog3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(
                R.string.alter3));
        builder.setIcon(R.drawable.xiaohuangren);

        builder.setMultiChoiceItems(single, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this, "您选择了"+single[which], Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "您取消选择了"+single[which], Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });

        Dialog dialog = builder.create();
        dialog.show();
    }

    /**
     * 显示列表对话框
     */
    private void showAlterDialog4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(
                R.string.alter4));
        builder.setIcon(R.drawable.xiaohuangren);

        builder.setItems(single,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "您点击了"+single[which], Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });

        Dialog dialog = builder.create();
        dialog.show();
    }

    /**
     * 显示自定义对话框
     */
    private void showAlterDialog5() {
        LayoutInflater inflater = LayoutInflater.from(this);
        @SuppressLint("InflateParams")
        View view = inflater.inflate(R.layout.activity_main, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("自定义对话框");//设置标题
        builder.setIcon(R.drawable.xiaohuangren);//设置图标

        builder.setView(view);

        AlertDialog dialog = builder.create();//获取dialog
        dialog.show();//显示对话框
    }

}
