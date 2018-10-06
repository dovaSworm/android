package com.example.danij.actionbarwithcardview;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<Card> implements Filterable {

    private static final String TAG = "CustomListAdapter";
    private Context mContext;
    private int mResource;
    private int lastPosition = -1;
//    private Filter personFilter;
//    private ArrayList<Card> personList;
//    private ArrayList<Card> returnList;


    /**
     * Holds variables in a View
     */
    private static class ViewHolder {

        ProgressBar progressBar;
        TextView title;
        ImageView image;
    }

    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public CustomListAdapter(Context context, int resource, ArrayList<Card> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
        //get the persons information
        setupImageLoader();
    }

//    public void resetData() {
//        personList = returnList;
//    }
//
//    public int getCount() {
//        return personList.size();
//    }
//
//    public Card getItem(int position) {
//        return personList.get(position);
//    }
//
//    public long getItemId(int position) {
//        return personList.get(position).hashCode();
//    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String title = getItem(position).getTitle();
        String imgUrl = getItem(position).getImageUrl();

        try {
            //create the view result for showing the animation
            final View result;

            //ViewHolder object
            final ViewHolder holder;

            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(mResource, parent, false);
                holder = new ViewHolder();
                holder.title = (TextView) convertView.findViewById(R.id.cardTitle);
                holder.image = (ImageView) convertView.findViewById(R.id.cardImage);
                holder.progressBar = (ProgressBar) convertView.findViewById(R.id.cardProgressDialog);
                result = convertView;
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
                result = convertView;
            }

//            Animation animation = AnimationUtils.loadAnimation(mContext,
//                    (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
//            result.startAnimation(animation);
            lastPosition = position;

            int defaultImage = mContext.getResources().getIdentifier("@drawable/image_failed", null, mContext.getPackageName());
            ImageLoader imageLoader = ImageLoader.getInstance();
            DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                    .cacheOnDisc(true).resetViewBeforeLoading(true)
                    .showImageForEmptyUri(defaultImage)
                    .showImageOnFail(defaultImage)
                    .showImageOnLoading(defaultImage).build();
            imageLoader.displayImage(imgUrl, holder.image, options, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {
                    holder.progressBar.setVisibility(View.VISIBLE);
                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                    holder.progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    holder.progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {

                }
            });
            holder.title.setText(title);

            return convertView;
        }catch (Exception e){
            Log.e(TAG, "getView: Exception: " + e.getMessage() );
            return convertView;
        }
    }

    private void setupImageLoader(){
        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }

//    @Override
//    public Filter getFilter() {
//        if (personFilter == null)
//            personFilter = new PersonFilter();
//        return personFilter;
//    }

//    private class PersonFilter extends Filter {



//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            FilterResults results = new FilterResults();
//            // We implement here the filter logic
//            if (constraint == null || constraint.length() == 0) {
//                // No filter implemented we return all the list
//                results.values = returnList;
//                results.count = returnList.size();
//            }
//            else {
//                // We perform filtering operation
//                List<Person> nPersonList = new ArrayList<Person>();
//
//                for (Person p : personList) {
//                    if (p.getName().toUpperCase().startsWith(constraint.toString().toUpperCase()))
//                        nPersonList.add(p);
//                }
//
//                results.values = nPersonList;
//                results.count = nPersonList.size();
//
//            }
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint,
//                                      FilterResults results) {
//
//            // Now we have to inform the adapter about the new list filtered
//            if (results.count == 0)
//                notifyDataSetInvalidated();
//            else {
//                personList = (ArrayList<Person>) results.values;
//                notifyDataSetChanged();
//            }

//        }

//    }
}