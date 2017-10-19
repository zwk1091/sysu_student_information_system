package com.example.app0;

import android.content.DialogInterface;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // TextView t=(TextView) findViewById(R.id.title);
        //t.setText(R.string.test);
        //sysu img 对话框

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText t=(EditText)findViewById(R.id.IdText);
        t.requestFocus();

        final AlertDialog.Builder sDialog= new AlertDialog.Builder(this);
        sDialog.setTitle("上传头像").setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"你点击了取消",Toast.LENGTH_SHORT).show();
                    }
                }).setItems(
                new String[]{"拍摄", "从相册选取"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                        Toast.makeText(MainActivity.this,"您选择了[拍摄]",Toast.LENGTH_SHORT).show();
                        }
                        if (which == 1) {
                            Toast.makeText(MainActivity.this,"您选择了[从相册选择]",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        ).create();
        ImageView sysuButton=(ImageView) findViewById(R.id.sysuimage);
        if(sysuButton!=null) {
            sysuButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    sDialog.show();
                }

            });
        }
        final RadioGroup buttGroup=(RadioGroup) findViewById(R.id.buttonGroup);
        if(buttGroup!=null) {
            buttGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    if(checkedId==R.id.student) {
                       // Toast.makeText(MainActivity.this,"您选择了[学生]",Toast.LENGTH_SHORT).show();
                        Snackbar.make(buttGroup,"您选择了[学生]",Snackbar.LENGTH_SHORT).setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this,"Snackbar的确定按钮被点击了",Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                    } else if(checkedId==R.id.teacher) {
                        //Toast.makeText(MainActivity.this,"您选择了[教职工]",Toast.LENGTH_SHORT).show();
                        Snackbar.make(buttGroup,"您选择了[教职工]",Snackbar.LENGTH_SHORT).setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this,"Snackbar的确定按钮被点击了",Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                    }
                }
            });
        }
        Button tlogin =(Button) findViewById(R.id.login);
        if(tlogin!=null) {
            tlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText tPassword=(EditText)findViewById(R.id.passwordText);
                    EditText tId=(EditText)findViewById(R.id.IdText);
                    TextInputLayout tIdLayout=(TextInputLayout)findViewById(R.id.IdLayout);
                    TextInputLayout tPasswordLayout=(TextInputLayout)findViewById(R.id.passwordLayout);
                    String pass=tPassword.getText().toString();
                    String num=tId.getText().toString();
                    if(TextUtils.isEmpty(num)) {
                        tIdLayout.setError("学号不能为空");
                    } else if(TextUtils.isEmpty(pass)) {
                        tPasswordLayout.setError("密码不能为空");
                    } else {
                        if(num.equals("123456")&&pass.equals("6666")) {
                            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this,"学号或密码错误",Toast.LENGTH_SHORT).show();
                        }
                    }
                    if(!TextUtils.isEmpty(pass)) {
                        tPasswordLayout.setError("");
                    }
                    if(!TextUtils.isEmpty(num)) {
                        tIdLayout.setError("");
                    }

                }
            });
        }

        Button tregister =(Button) findViewById(R.id.register);
        if(tregister!=null) {
            tregister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
               if(buttGroup.getCheckedRadioButtonId()==R.id.student) {
                   Toast.makeText(MainActivity.this,"学生注册功能尚未启用",Toast.LENGTH_SHORT).show();
               }
                    if(buttGroup.getCheckedRadioButtonId()==R.id.teacher) {
                        Toast.makeText(MainActivity.this,"教职工注册功能尚未启用",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}
