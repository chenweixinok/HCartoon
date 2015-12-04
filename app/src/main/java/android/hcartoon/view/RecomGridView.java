package android.hcartoon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Lenovo on 2015/11/18.
 */
public class RecomGridView extends GridView{

    public RecomGridView(Context context) {
        super(context);
    }

    public RecomGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RecomGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
