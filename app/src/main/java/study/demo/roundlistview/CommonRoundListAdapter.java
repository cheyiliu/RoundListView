package study.demo.roundlistview;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheyiliu on 17/2/4.
 */

public class CommonRoundListAdapter extends BaseAdapter {
    protected Activity mContext;
    protected LayoutInflater mInflater;
    protected List<SampleModel> mModelInfos;

    public CommonRoundListAdapter(Activity context, List<SampleModel> infos) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);

        mModelInfos = infos;
        if (mModelInfos == null) {
            mModelInfos = new ArrayList<>();
        }
    }


    @Override
    public int getCount() {
        return mModelInfos.size();
    }

    @Override
    public SampleModel getItem(int position) {
        if (position >= 0 && position < mModelInfos.size()) {
            return mModelInfos.get(position);
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.common_round_list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        SampleModel sampleModel = mModelInfos.get(position);
        viewHolder.mImageViewIcon.setImageResource(sampleModel.mIcon);

        // 设置文本内容
        viewHolder.mTextViewName.setText(sampleModel.mName);

        // 设置文本颜色
        viewHolder.mTextViewName.setTextColor(Color.rgb(0x1f, 0xb9, 0xd5));//蓝
//            viewHolder.mTextViewName.setTextColor(Color.rgb(0xc7, 0xc7, 0xcd));//灰
//            viewHolder.mTextViewName.setTextColor(Color.rgb(0x3a, 0x3a, 0x48));//黑

        // 设置背景边框
        if (getCount() == 1) {
            convertView.setBackgroundResource(R.drawable.common_list_only_one_item_selector);
        } else if (getCount() > 1) {
            if (position == 0) {
                convertView.setBackgroundResource(R.drawable.common_list_more_than_one_top_item_selector);
            } else if (position == getCount() - 1) {
                convertView.setBackgroundResource(R.drawable.common_list_more_than_one_bottom_item_selector);
            } else {
                convertView.setBackgroundResource(R.drawable.common_list_more_than_one_middle_item_selector);
            }
        }

        // 事件处理
        // TODO

        return convertView;
    }

    public static class ViewHolder {
        public ImageView mImageViewIcon;
        public TextView mTextViewName;

        public ViewHolder(View view) {
            mImageViewIcon = (ImageView) view.findViewById(R.id.icon_iv);
            mTextViewName = (TextView) view.findViewById(R.id.name_tv);
        }
    }
}