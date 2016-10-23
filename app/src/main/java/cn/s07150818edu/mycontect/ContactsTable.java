package cn.s07150818edu.mycontect;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by Administrator on 2016/10/23.
 */
public class ContactsTable {

    private  final  static  String TABLENAME="contactsTable";
    private MyDB db;
    public ContactsTable(Context context){
        db=new MyDB(context);
        if (!db.isTableExits(TABLENAME)){
            String createTableSql="CREATE TABEL IF NOT EXISTS"+TABLENAME+"primary key AUTOINCREMENT,"+
                    User.NAME+" VARCHAR,"+User.MOBLE+" VARCHAR,"+User.QQ+" VARCHAR,"+User.DANWEI+" VARCHAR,"+User.ADDRESS+" VARCHAR)";

            db.createTable(createTableSql);
        }
    }
    public boolean addData(User user){
        ContentValues values=new ContentValues();
        values.put(User.NAME,user.getName());
        values.put(User.MOBLE,user.getMoble());
        values.put(User.DANWEI,user.getDanwei());
        values.put(User.QQ,user.getQq());
        values.put(User.ADDRESS,user.getAddress());
        return db.save(TABLENAME,values);
    }

}
