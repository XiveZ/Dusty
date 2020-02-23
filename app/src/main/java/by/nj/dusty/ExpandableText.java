package by.nj.dusty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

class ExpdandableText extends BaseExpandableListAdapter {

    private List<String> parent;
    private HashMap<String, List<String>> child;
    private Context context;

    ExpdandableText (Context context, List<String> title, HashMap<String, List<String>> child){
        this.context = context;
        this.parent = title;
        this.child = child;
    }

    @Override
    public int getGroupCount() {
        return this.parent.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return this.child.get(this.parent.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return this.parent.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return this.child.get(this.parent.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String title = (String) this.getGroup(i);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.expandable_title,null);
        }

        TextView textView = (TextView)view.findViewById(R.id.TextTitle);
        textView.setText(title);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String child = (String) this.getChild(i,i1);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.expandable_text,null);
        }
        TextView textView = view.findViewById(R.id.TextChild);
        textView.setText(child);
        return view;
    }



    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}