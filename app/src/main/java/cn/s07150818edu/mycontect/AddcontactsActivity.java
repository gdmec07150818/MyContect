package cn.s07150818edu.mycontect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AddcontactsActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText mobileEditText;
    private EditText qqEditText;
    private EditText danweiEditText;
    private EditText addressEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        setTitle("添加联系人");
        nameEditText= (EditText) findViewById(R.id.name);
        mobileEditText= (EditText) findViewById(R.id.mobile);
        qqEditText= (EditText) findViewById(R.id.qq);
        danweiEditText= (EditText) findViewById(R.id.danwei);
        addressEditText= (EditText) findViewById(R.id.address);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       menu.add(Menu.NONE,1,Menu.NONE,"保存");
        menu.add(Menu.NONE,2,Menu.NONE,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                if (!nameEditText.getText().toString().equals("")){
                    //新建User对象
                    User user=new User();
                    //User对象赋值
                    user.setName(nameEditText.getText().toString());
                    user.setMobile(mobileEditText.getText().toString());
                    user.setDanwei(danweiEditText.getText().toString());
                    user.setQq(qqEditText.getText().toString());
                    user.setAddress(addressEditText.getText().toString());
                    //创建数据表对象
                    ContactsTable ct=new ContactsTable(AddcontactsActivity.this);
                    //数据表添加数据
                    if (ct.addData(user)) {

                        Toast.makeText(AddcontactsActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(AddcontactsActivity.this,"添加失败",Toast.LENGTH_SHORT).show();

                    }
                }else {
                    Toast.makeText(AddcontactsActivity.this,"请输入数据",Toast.LENGTH_SHORT).show();

                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
