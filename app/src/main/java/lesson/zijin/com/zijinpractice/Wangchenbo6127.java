package lesson.zijin.com.zijinpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Wangchenbo6127 extends AppCompatActivity {
    private ListView listView;
    private wcbMsgAdapter adapter=null;
    private ArrayList<wcbMsg> mylist=new ArrayList<wcbMsg>();
    private EditText intput_text;
    private Button btn_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题
        initData();//初始化数据 将数据添加到容器中
        setContentView(R.layout.activity_wangchenbo6127);
        //初始化控件
        findView();

        //将数据放入到适配器中
        adapter=new wcbMsgAdapter(Wangchenbo6127.this,R.layout.wcb_chat_item,mylist);
        listView.setAdapter(adapter);
        //按钮的监听事件
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                String content=intput_text.getText().toString();

                //判空
                if (TextUtils.isEmpty(content)){
                    Toast.makeText(getApplication(),"你输入的内容为空",Toast.LENGTH_SHORT).show();
                }else {
                    //不为空
                    wcbMsg msg=new wcbMsg(content,wcbMsg.TYPE_SEND);
                    mylist.add(msg);
                    //刷新消息
                    adapter.notifyDataSetChanged();
                    listView.setSelection(mylist.size());//将listview定位到最后一行
                    intput_text.setText("");//清空
                }
            }
        });
    }



    public void findView(){
        listView=(ListView)findViewById(R.id.listview_chat);
        intput_text=(EditText)findViewById(R.id.input_text);
        btn_send=(Button)findViewById(R.id.btn_send);
    }
    public void initData(){

        wcbMsg msg1=new wcbMsg("吃饭了吗？",wcbMsg.TYPE_RECEIVER);
        mylist.add(msg1);
        wcbMsg msg2=new wcbMsg("吃了！",wcbMsg.TYPE_SEND);
        mylist.add(msg2);
        wcbMsg msg3=new wcbMsg("什么时候出发？",wcbMsg.TYPE_RECEIVER);
        mylist.add(msg3);
    }
}
