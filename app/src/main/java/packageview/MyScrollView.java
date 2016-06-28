package packageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

import com.example.administrator.mygittest01.R;

public class MyScrollView extends ScrollView {
    private View zoonView;
    //记录上次的事件的Y轴
    private float lastMotionY;
     //记录总共的滚动距离
    private int allScroll=-1;
   //控件原本的高度
    private int  height =0;
    //被放大的控件Id
    private int zoomId;
    //最大放大值
    private int maxZoom;
     //滚动监听
    private ScrollerViewListener myListener;
    public MyScrollView(Context context) {
        super(context);
    }
    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs){
        TypedArray t = getContext().obtainStyledAttributes(attrs, R.styleable.ObservableScrollView);
        zoomId = t.getResourceId(R.styleable.ObservableScrollView_zoomId,-1);
    }


    //这个接口主要用来随着拖动设置监听动画
   interface ScrollerViewListener {
       void onScrollChanged(MyScrollView scrollView,int x,int y,int oldx,int lody);
   }
}
