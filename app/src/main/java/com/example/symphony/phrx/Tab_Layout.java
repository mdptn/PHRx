package com.example.symphony.phrx;

/**
 * Created by Megan on 8/10/2016.
 */

        import android.content.Context;
        import android.support.annotation.DrawableRes;
        import android.support.annotation.StringRes;
        import android.support.design.widget.TabLayout;
        import android.util.AttributeSet;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.widget.ImageView;

public class Tab_Layout extends TabLayout {

    public Tab_Layout(Context context){
        super(context);
    }

    public Tab_Layout(Context context, AttributeSet attr){
        super(context, attr);
    }

    public Tab_Layout(Context context, AttributeSet attr,int style){
        super(context, attr, style);
    }

    public void createTabs() {
        addTab(R.drawable.hometab, R.string.home);
        addTab(R.drawable.personaltab, R.string.health);
        addTab(R.drawable.medictab, R.string.medic);
        addTab(R.drawable.immunetab, R.string.immune);
        addTab(R.drawable.allergytab, R.string.allergy);
        addTab(R.drawable.conditiontab, R.string.condition);
    }

    private void addTab(@DrawableRes int iconId, @StringRes int contentDescriptionId) {
        View tabView = LayoutInflater.from(getContext()).inflate(R.layout.tabicon, null);
        ImageView imageView = (ImageView) tabView.findViewById(R.id.tab_icon);
        imageView.setImageResource(iconId);
        Tab tab = newTab();
        tab.setCustomView(tabView).setContentDescription(contentDescriptionId);
        addTab(tab);
    }
}
