package com.example.administrator.mygittest01;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity{
    private ListView listView;
    private String[]data = new String[]{"添加","删除","修改","查询"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) this.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,data[i]+"被点击了",Toast.LENGTH_SHORT).show();
            }
        });
    }
    BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return data.length;
        }
        @Override
        public Object getItem(int i) {
            return data[i];
        }
        @Override
        public long getItemId(int i) {
            return i;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHoder  holder;
            if(view==null){
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item,null);
                holder = new ViewHoder();
                holder.btn = (Button) view.findViewById(R.id.myButton);
                holder.edit =(EditText)view.findViewById(R.id.input);
                view.setTag(holder);
            }
            else{
                holder =(ViewHoder)view.getTag();
            }
            holder.btn.setText(data[i]);
//            final int tag =i;
//            holder.btn.setOnClickListener(new MyListener(i));
            return view;
        }
        class ViewHoder{
            Button btn;
            EditText edit;
        }
    };
    class MyListener implements View.OnClickListener {
           int item;
        public MyListener(int position) {
             this.item=position;
        }
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, data[item], Toast.LENGTH_SHORT).show();
        }
    }
//    View.OnClickListener btnOlickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
////            for(int i =0;i<data.length;i++) {
////                log
//                if (((int) view.getTag()) == i) {
//                    Toast.makeText(MainActivity.this, (Button) view.getTag() + "", Toast.LENGTH_SHORT).show();
////                    break;
////                }
////            }
////          Toast.makeText(getApplicationContext(),data[i]+"按钮被点击",Toast.LENGTH_SHORT).show();
//        }
//    };
}
