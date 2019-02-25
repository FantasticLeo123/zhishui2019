package com.example.asus.zhishui.bookpage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ramotion.expandingcollection.ECCardContentListItemAdapter;
import com.example.asus.zhishui.bookpage.pojo.Content;

import java.util.List;
import com.example.asus.zhishui.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressLint({"SetTextI18n", "InflateParams"})
public class CommentArrayAdapter extends ECCardContentListItemAdapter<Content> {

    public CommentArrayAdapter(@NonNull Context context, @NonNull List<Content> objects) {
        super(context, R.layout.list_element, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());

            rowView = inflater.inflate(R.layout.list_element, null);
            // configure view holder
            viewHolder = new ViewHolder();
            viewHolder.line1 = (TextView) rowView.findViewById(R.id.subtitle);
            viewHolder.line2 = (TextView) rowView.findViewById(R.id.body);
            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) rowView.getTag();
        }

        final Content objectItem = getItem(position);
        if (objectItem != null) {
            viewHolder.line1.setText(objectItem.getTextSubtitle());
            viewHolder.line2.setText(objectItem.getTextBody());
        }


        return rowView;
    }

    static class ViewHolder {
        TextView line1;
        TextView line2;
    }

}
