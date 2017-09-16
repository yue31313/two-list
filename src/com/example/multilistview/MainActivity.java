package com.example.multilistview;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
    
	private MyListView listView; 
	private MyListView subListView;
	private MyAdapter myAdapter;
	private SubAdapter subAdapter;
	
	String cities[][] = new String[][] {
            new String[] {"ȫ����ʳ", "���ｭ���", "����", "����", "���","������","̨���","�½�/����","�ز�","���","������","С�Կ��","�ձ�","��������",
            "�����ǲ�","����","������","����"},
            new String[] {"ȫ����������","������","�ư�","���","KTV","��ӰԺ","��������","��԰","����/����","ϴԡ","��ԡ��Ħ","�Ļ�����",
          		"DIY�ֹ���","�����","������Ϸ","������������"},
            new String[] {"ȫ������", "�ۺ��̳�", "����Ь��", "�˶�����","�鱦��Ʒ","��ױƷ","����ҵ�","���ӹ���","�Ҿӽ���"
          		,"���","���","�۾���","��ɫ����","���๺�ﳡ��","ʳƷ���","����/������","ҩ��"},
            new String[] {"ȫ����������","������","�ư�","���","KTV","��ӰԺ","��������","��԰","����/����","ϴԡ","��ԡ��Ħ","�Ļ�����",
            		"DIY�ֹ���","�����","������Ϸ","������������"},
            new String[] {"ȫ","������","�ư�","���","KTV","��������","��԰","����/����","ϴԡ","��ԡ��Ħ","�Ļ�����",
            		"DIY�ֹ���","�����","������Ϸ","������������"},
            new String[] {"ȫ��","������","�ư�","���","��ӰԺ","��������","��԰","����/����","ϴԡ","��ԡ��Ħ","�Ļ�����",
            		"DIY�ֹ���","�����","������Ϸ","������������"},
            new String[] {"ȫ����","������","�ư�","���","KTV","��ӰԺ","��������","��԰","����/����","ϴԡ","��ԡ��Ħ","�Ļ�����",
            		"DIY�ֹ���","�����","������Ϸ","������������"},
            new String[] {"ȫ������","������","�ư�","���","KTV","��ӰԺ","��������","��԰","����/����","ϴԡ","��ԡ��Ħ","�Ļ�����",
            		"DIY�ֹ���","�����","������Ϸ","������������"},
            new String[] {"ȫ��������","������","�ư�","���","KTV","��ӰԺ","��������","��԰","����/����","ϴԡ","��ԡ��Ħ","�Ļ�����",
            		"DIY�ֹ���","�����","������Ϸ"},
            new String[] {"ȫ����������","������","�ư�","���","KTV","��ӰԺ","��������","��԰","����/����","ϴԡ","��ԡ��Ħ","�Ļ�����",
            		"DIY�ֹ���","�����","������Ϸ","������������"},
            new String[] {"ȫ������aaa","������","�ư�","���","KTV","��ӰԺ","��������","��԰","����/����","ϴԡ","��ԡ��Ħ","�Ļ�����",
            		"DIY�ֹ���","�����","������Ϸ"},
            };
		String foods[] =new String []{"ȫ��Ƶ��","��ʳ","��������","����","�Ƶ�","����","�˶�����","���","����","����","�������"};
		int images[] = new int[]{R.drawable.ic_category_0,R.drawable.ic_category_10,R.drawable.ic_category_30,R.drawable.ic_category_20
				,R.drawable.ic_category_60,R.drawable.ic_category_50,R.drawable.ic_category_45,R.drawable.ic_category_50,R.drawable.ic_category_70,
				R.drawable.ic_category_65,R.drawable.ic_category_80};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();
        myAdapter=new MyAdapter(getApplicationContext(), foods, images);
        listView.setAdapter(myAdapter);
    
        selectDefult();
        
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				final int location=position;
				myAdapter.setSelectedPosition(position);
				myAdapter.notifyDataSetInvalidated();
				subAdapter=new SubAdapter(getApplicationContext(), cities, position);
				subListView.setAdapter(subAdapter);
				subListView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int position, long arg3) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), cities[location][position], Toast.LENGTH_SHORT).show();
					}
				});
			}
		});
        
    }
   private void init(){
	   listView=(MyListView) findViewById(R.id.listView);
	   subListView=(MyListView) findViewById(R.id.subListView);
   }
   
   private void selectDefult(){
	   final int location=0;
	 		myAdapter.setSelectedPosition(0);
	 		myAdapter.notifyDataSetInvalidated();
	 		subAdapter=new SubAdapter(getApplicationContext(), cities, 0);
	 		subListView.setAdapter(subAdapter);
	 		subListView.setOnItemClickListener(new OnItemClickListener() {

	 			@Override
	 			public void onItemClick(AdapterView<?> arg0, View arg1,
	 					int position, long arg3) {
	 				// TODO Auto-generated method stub
	 				Toast.makeText(getApplicationContext(), cities[location][position], Toast.LENGTH_SHORT).show();
	 			}
	 		});
   }
  
}
